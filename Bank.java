
import java.util.Vector;

public class Bank {
    public static Vector<Client> dataBase = new Vector<Client>();

    static boolean checkCredentials(String _id, String _password) throws Exception {

        if (_id.equals(DataBase.LoginQuery(_id, "id"))) {

            if (_password.equals(DataBase.LoginQuery(_id, "password"))) {
                return true;
            }
        }
        return false;

    }

    static Client returnClient(String _id) {

        if (_id.equals(DataBase.LoginQuery(_id, "id"))) {
            return new Client(DataBase.LoginQuery(_id, "name"), DataBase.LoginQuery(_id, "surname"),
                    DataBase.LoginQuery(_id, "id"), DataBase.LoginQuery(_id, "password"));
        } else

            return null;
    }

    public static void main(String[] args) throws Exception {
        Gui gui = new Gui();
        DataBase data = new DataBase();

    }

}
