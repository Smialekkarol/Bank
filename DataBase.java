import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    static ResultSet rs;
    static String data;

    public static String PasswordQuery(String _id) {

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "password");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select password  from bazaklientow WHERE id=" + _id);
            while (rs.next())
                data = rs.getString(1);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return data;

    }

    public static String IdQuery(String _id) {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "password");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select id  from bazaklientow WHERE id=" + _id);
            while (rs.next())
                data = rs.getString(1);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return data;
    }

    public static String Query(String query, String queryWhat, String queryFrom) {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "password");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select " + queryWhat + "  from bazaklientow" + queryWhat);
            while (rs.next())
                data = rs.getString(1);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return data;
    }

}
