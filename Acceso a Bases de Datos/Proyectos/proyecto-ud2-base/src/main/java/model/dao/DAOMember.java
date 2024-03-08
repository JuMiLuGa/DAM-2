package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.config.database.Engine;
import model.entity.Member;
import utils.ANSI;
import utils.Util;

public class DAOMember extends DAO {
    private Connection connection;

    private Engine engine;

    public static final String TABLE_NAME = "members";

    public DAOMember(Connection connection, Engine engine) {
        this.connection = connection;
        this.engine = engine;
        checkTable();
    }

    private void checkTable() {
        Util.executeSQLFromTableName(this.connection, this.engine, "members");
    }

    public void dropTable() throws Exception {
        String sql = String.format("DROP TABLE %s", new Object[] { "members" });
        Statement st = this.connection.createStatement();
        st.execute(sql);
    }

    public void resetTable() throws Exception {
        dropTable();
        checkTable();
    }

    public void save(Member member) throws Exception {
        ANSI.printCyan("DAOMember.save()");
        String sql = String.format("INSERT INTO %s VALUES(?, ?, ?);", new Object[] { "members" });
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, member.getDni());
        ps.setString(2, member.getName());
        ps.setString(3, member.getEmail());
        ps.executeUpdate();
    }

    public String[][] getAll() throws Exception {
        ANSI.printCyan("DAOMember.getAll()");
        String sql = String.format("SELECT * FROM %s", new Object[] { "members" });
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<String[]> rows = (ArrayList)new ArrayList<>();
        while (rs.next()) {
            String[] row = { rs.getString("dni"), rs.getString("name"), rs.getString("email") };
            rows.add(row);
        }
        String[][] data = (String[][])rows.stream().toArray(x$0 -> new String[x$0][]);
        return data;
    }

    public ArrayList<Member> all() throws Exception {
        ANSI.printCyan("DAOMember.all()");
        String sql = String.format("SELECT * FROM %s", new Object[] { "members" });
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Member> rows = new ArrayList<>();
        while (rs.next())
            rows.add(new Member(rs
                    .getString("dni"), rs
                    .getString("name"), rs
                    .getString("email")));
        return rows;
    }

    public void importAll(ArrayList<Member> members) throws Exception {
        ANSI.printCyan("DAOMember.importAll()");
        resetTable();
        for (Member member : members)
            save(member);
    }

    public Member getByDni(String dni) throws Exception {
        ANSI.printCyan("DAOMember.getByDni()");
        String sql = String.format("SELECT * FROM %s WHERE dni = ?", new Object[] { "members" });
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Member member = new Member(rs.getString("dni"), rs.getString("name"), rs.getString("email"));
        rs.close();
        return member;
    }

    public int getCount() throws Exception {
        ANSI.printCyan("DAOMember.getCount()");
        String sql = String.format("SELECT COUNT(*) FROM %s", new Object[] { "members" });
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        return count;
    }
}
