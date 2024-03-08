package model.config.file;

import java.io.Serializable;
import java.util.HashMap;
import model.config.database.DatabaseConnection;
import model.config.database.Engine;
import utils.ANSI;

public class FileData implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Engine DEFAULT_ENGINE = Engine.mysql;

    private Engine engine;

    private HashMap<Engine, DatabaseConnection> databases;

    public FileData() {
        ANSI.printCyan("FileData()");
        this.engine = DEFAULT_ENGINE;
        this.databases = new HashMap<>();
    }

    public void set(DatabaseConnection conf) {
        ANSI.printCyan("FileData.set()");
        String className = conf.getClass().toString();
        System.out.println(className);
        if (className.contains("MySQLConnection")) {
            this.databases.put(Engine.mysql, conf);
            this.engine = Engine.mysql;
            return;
        }
        if (className.contains("SQLiteConnection")) {
            this.databases.put(Engine.sqlite, conf);
            this.engine = Engine.sqlite;
            return;
        }
        System.out.println("FileData.set(): ERROR: no es mysql ni sqlite");
    }

    public DatabaseConnection get() {
        return this.databases.get(this.engine);
    }

    public DatabaseConnection get(Engine engine) {
        return this.databases.get(engine);
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String toString() {
        return "FileData{engine=" + String.valueOf(this.engine) + ", databases=" + String.valueOf(this.databases) + "}";
    }
}

