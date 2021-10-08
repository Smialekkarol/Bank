
interface operations {
    void deposit(double value);

    void withdraw(double value);

    double checkBalance();

}

public class Account implements operations {
    private String id;
    private String password;
    static int numberOfAccounts;
    double balance;
    String menu[] = new String[] { "Deposit", "Withdraw", "Balance", "Change the password", "Quit" };

    public Account(String _id, String _password) {
        id = _id;
        password = _password;
        numberOfAccounts++;
    }

    public void deposit(double value) {
        balance += value;
    }

    public void withdraw(double value) {
        if (value <= balance) {
            balance -= value;
        } else
            System.out.println("You can not withdraw : " + value + " There is not enough resources on your account");
    }

    public double checkBalance() {
        return balance;
    }

    void changePassword(String pass) {
        password = pass;
    }

    void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " -- " + menu[i]);
        }
    }

    String getPassword() {
        return password;
    }

    String getId() {
        return id;
    }

}
