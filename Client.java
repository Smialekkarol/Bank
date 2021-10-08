
public class Client {

    private String name;
    private String surname;
    private String dateOfBirth;
    private char sex;
    Account account;
    static int numberOfClients;

    Client(String n, String s, String date, char _sex, String id, String password) {
        this.name = n;
        this.surname = s;
        dateOfBirth = date;
        sex = _sex;
        account = new Account(id, password);
        System.out.println("client nr. " + numberOfClients + " created");
        numberOfClients++;
    }

    String getId() {
        return account.getId();
    }

    String getPassword() {
        return account.getPassword();
    }

    String getName() {
        return name + " " + surname;
    }

}
