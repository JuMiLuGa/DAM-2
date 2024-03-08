package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.config.database.Engine;
import model.entity.Rent;
import utils.ANSI;
import utils.Util;

public class DAORent extends DAO {
    private Connection connection;

    private Engine engine;

    private ArrayList<Rent> list;

    public static final String TABLE_NAME = "rents";

    public DAORent(Connection connection, ArrayList<Rent> list, Engine engine) {
        this.connection = connection;
        this.list = list;
        this.engine = engine;
        checkTable();
    }

    public DAORent(Connection connection, Engine engine) {
        this(connection, new ArrayList<>(), engine);
    }

    private void checkTable() {
        Util.executeSQLFromTableName(this.connection, this.engine, "rents");
    }

    public void dropTable() throws Exception {
        String sql = String.format("DROP TABLE %s", new Object[] { "rents" });
        Statement st = this.connection.createStatement();
        st.execute(sql);
    }

    public void resetTable() throws Exception {
        dropTable();
        checkTable();
    }

    public void save(Rent rent) throws Exception {
        String sql = String.format("INSERT INTO %s (uuid, idBook, dniMember, startRentDate) VALUES(?, ?, ?, ?);", new Object[] { "rents" });
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, rent.getUuid());
        ps.setInt(2, rent.getIdBook().intValue());
        ps.setString(3, rent.getDniMember());
        ps.setTimestamp(4, rent.getStartRentDate());
        ps.executeUpdate();
    }

    public Rent getRentedByUUID(String uuid) throws Exception {
        ANSI.printCyan("DAORent.getRentedByUUID()");
        try {
            String sql = String.format("SELECT * FROM %s WHERE uuid = ? AND endRentDate IS NULL", new Object[] { "rents" });
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, uuid);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            Rent rent = null;
            while (rs.next())
                rent = new Rent(rs.getString("uuid"), Integer.valueOf(rs.getInt("idBook")), rs.getString("dniMember"), rs.getTimestamp("startRentDate"), rs.getTimestamp("endRentDate"));
            rs.close();
            return rent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Rent> all() throws Exception {
        ANSI.printCyan("DAORent.all()");
        String sql = String.format("SELECT * FROM %s", new Object[] { "rents" });
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Rent> rows = new ArrayList<>();
        while (rs.next())
            rows.add(new Rent(rs
                    .getString("uuid"),
                    Integer.valueOf(rs.getInt("idBook")), rs
                    .getString("dniMember"), rs
                    .getTimestamp("startRentDate"), rs
                    .getTimestamp("endRentDate")));
        rs.close();
        return rows;
    }

    public void importAll(ArrayList<Rent> rents) throws Exception {
        ANSI.printCyan("DAORent.importAll()");
        resetTable();
        for (Rent rent : rents)
            save(rent);
    }

    public String[][] getRented() throws Exception {
        String sql = String.format("SELECT * FROM %s LEFT JOIN %s ON %s.id = %s.idBook LEFT JOIN %s ON %s.dni = %s.dniMember WHERE startRentDate IS NOT NULL ", new Object[] { "books", "rents", "books", "rents", "members", "members", "rents" });
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<String[]> rows = (ArrayList)new ArrayList<>();
        while (rs.next()) {
            String[] row = { rs.getString("uuid"), rs.getString("id"), rs.getString("title"), rs.getString("author"), rs.getString("dniMember"), rs.getString("name"), rs.getString("email"), Util.formatDate(rs.getTimestamp("startRentDate")), Util.formatDate(rs.getTimestamp("endRentDate")) };
            rows.add(row);
        }
        String[][] data = (String[][])rows.stream().toArray(x$0 -> new String[x$0][]);
        rs.close();
        return data;
    }

    public void update(Rent rent) throws Exception {
        String sql = String.format("UPDATE %s SET idBook = ?, dniMember = ?, startRentDate = ?, endRentDate = ? WHERE uuid = ?", new Object[] { "rents" });
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1, rent.getIdBook().intValue());
        ps.setString(2, rent.getDniMember());
        ps.setTimestamp(3, rent.getStartRentDate());
        ps.setTimestamp(4, rent.getEndRentDate());
        ps.setString(5, rent.getUuid());
        System.out.println(ps);
        int count = ps.executeUpdate();
        System.out.println(count);
        if (count != 1)
            throw new Exception("No se ha actualizado ninguna fila");
    }
}

