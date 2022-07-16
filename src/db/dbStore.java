package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class dbStore {
    static Connection con;

    dbStore() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "jonyj", "jony");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    String name, pass;

    public dbStore(String name, String pass) {
        this();
        this.name = name;
        this.pass = pass;
    }

    public boolean insertUser() {
        String query = "insert into users values(?,?)";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, pass);
            st.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
