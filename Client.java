
public class Client {

    private String name;
    private String surname;
    Account account;

    Client(String n, String s, String id, String password) {
        this.name = n;
        this.surname = s;
        account = new Account(id, password, DataBase.AccountQuery(id));
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
