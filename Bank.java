import java.util.Vector;

public class Bank {
    public static Vector<Client> dataBase = new Vector<Client>();

    static boolean checkCredentials(String _id, String _password) throws Exception {
        int i = 0;
        // String data = DataBase.passwordQuery(_id);
        // System.out.println("wywolano dla" + _id + " " + _password);

        // System.out.println(dataBase.get(i).getId() + " " + i);
        if (_id.equals(DataBase.IdQuery(_id)) && i < Client.numberOfClients) {
            // System.out.println("correct id" + _id);
            if (_password.equals(DataBase.PasswordQuery(_id))) {
                // System.out.println("correct password" + DataBase.PasswordQuery(_id));
                return true;
            }

        }

        return false;

        // System.out.println(_id + " " + _password);

    }

    static Client returnClient(String _id) {
        int i = 0;
        // System.out.println(_id + " " + _password);
        while (i < Client.numberOfClients) {
            // System.out.println(dataBase.get(i).getId());
            if (_id.equals(dataBase.get(i).getId()) && i < Client.numberOfClients) {
                return dataBase.get(i);
            } else
                i++;
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
        Client client1 = new Client("Karol", "Śmiałek", "04-07-2000", 'M', "11111111", "Karol");
        Client client2 = new Client("Wiktoria", "Bodzioch", "16-12-2001", 'F', "22222222", "Wiktoria");
        Client client3 = new Client("Anna", "Piatek", "6-12-195", 'F', "33333333", "Anna");
        Client client4 = new Client("Olivier", "Gajewski", "09-11-1998", 'M', "44444444", "Olivier");
        Client client5 = new Client("Volodymyr", "Polak", "10-03-2000", 'M', "55555555", "Volodymyr");
        Client client6 = new Client("Dominika", "Nowakowska", "16-12-1970", 'F', "66666666", "Dominika");
        Client client7 = new Client("Damian", "Świątek", "05-05-1950", 'M', "77777777", "Damian");
        Client client8 = new Client("Nicola", "Dziedzic", "16-12-1980", 'F', "88888888", "Nicola");
        Client client9 = new Client("Aneta", "Wróbel", "03-09-1995", 'F', "99999999", "Aneta");

        dataBase.add(client1);
        dataBase.add(client2);
        dataBase.add(client3);
        dataBase.add(client4);
        dataBase.add(client5);
        dataBase.add(client6);
        dataBase.add(client7);
        dataBase.add(client8);
        dataBase.add(client9);

        Gui gui = new Gui();
        DataBase data = new DataBase();

    }

}
