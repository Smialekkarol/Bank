
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel message;
    private JButton withdraw, deposit, checkBalance, logout;
    private Client client;
    private JTextField input;

    Window(Client cli) {

        frame = new JFrame();
        panel = new JPanel();
        message = new JLabel();
        input = new JTextField();
        panel.setLayout(null);
        client = cli;
        frame.setSize(600, 1000);

        withdraw = new JButton("withdraw");
        withdraw.setBounds(250, 100, 100, 50);

        deposit = new JButton("deposit");
        deposit.setBounds(250, 200, 100, 50);

        checkBalance = new JButton("Check Balance");
        checkBalance.setBounds(250, 300, 100, 50);

        logout = new JButton("wyloguj");
        logout.setBounds(490, 10, 90, 30);

        withdraw.addActionListener(this);
        deposit.addActionListener(this);
        checkBalance.addActionListener(this);
        logout.addActionListener(this);

        message.setBounds(260, 400, 100, 30);

        input.setBounds(250, 600, 100, 30);

        // panel.add(input);
        panel.add(logout);
        panel.add(message);
        panel.add(withdraw);
        panel.add(deposit);
        panel.add(checkBalance);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Panel klienta " + client.getName());
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source.equals(withdraw)) {

            // message.setText(client.account.checkBalance() + "");
            String s = (String) JOptionPane.showInputDialog(frame, "podaj kwote do wypłaty");
            client.account.withdraw(Double.parseDouble(s));
        }

        if (source.equals(deposit)) {

            String s = (String) JOptionPane.showInputDialog(frame, "podaj kwote do wpłaty");
            client.account.deposit(Double.parseDouble(s));
            // message.setText(client.account.checkBalance() + "");
        }

        if (source.equals(checkBalance)) {

            message.setText(client.account.checkBalance() + "");
        }

        if (source.equals(logout)) {
            frame.setVisible(false);
            frame.dispose();
            Gui g = new Gui();
        }

    }

}
