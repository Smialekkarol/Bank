
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
    static ResultSet rs;
    static String data;
    static double val;

    public static String LoginQuery(String _id, String arg) {

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "password");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select " + arg + " from bazaklientow WHERE id=" + _id);
            while (rs.next())
                data = rs.getString(1);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return data;

    }

    public static double AccountQuery(String _id) {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "password");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select stan_konta  from bazakont WHERE id=" + _id);

            while (rs.next())
                val = rs.getDouble(1);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return val;
    }

    public static void balanceUpdate(String id, double val) {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "password");
            Statement stmt = con.createStatement();
            boolean b = stmt.execute("UPDATE bazakont SET stan_konta= " + val + "WHERE id=" + id);
            if (b) {
                con.close();
                stmt.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void AddClient(String name, String surname, String id, String password) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "password");
            Statement stmt = con.createStatement();
            boolean b = stmt.execute("INSERT INTO bazaklientow VALUES(\"" + name + "\",\"" + surname + "\",\"" + id
                    + "\",\"" + password + "\")");
            if (b) {
                boolean c = stmt.execute("INSERT INTO bazakont VALUES(\"" + id + 1000 + "\")");
                con.close();
                stmt.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
