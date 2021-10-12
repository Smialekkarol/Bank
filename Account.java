
import javax.swing.JOptionPane;

interface operations {
    void deposit(double value);

    void withdraw(double value);

    double checkBalance();

}

public class Account implements operations {
    private String id;
    private String password;
    double balance;

    public Account(String _id, String _password, double status) {
        this.id = _id;
        this.password = _password;
        this.balance = status;

    }

    public void deposit(double value) {
        balance += value;
        DataBase.balanceUpdate(id, balance);
    }

    public void withdraw(double value) {
        if (value <= balance) {
            balance -= value;
            DataBase.balanceUpdate(id, balance);
        } else
            JOptionPane.showMessageDialog(null,
                    "You can not withdraw : " + value + " There is not enough resources on your account");

    }

    public double checkBalance() {
        return DataBase.AccountQuery(id);
    }

    void changePassword(String pass) {
        password = pass;
    }

    String getPassword() {
        return password;
    }

    String getId() {
        return id;
    }

}
