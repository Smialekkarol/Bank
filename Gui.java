
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    private static JFrame frame;
    private JPanel panel;
    private JLabel usernameLabel, passwordLabel;
    private JPasswordField password;
    private JButton loginButton;
    private JPasswordField username;
    private JLabel loginErrorLabel;

    public Gui() {
        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(null);
        frame.setSize(300, 230);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(20, 20, 80, 30);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 75, 80, 30);

        password = new JPasswordField();
        password.setBounds(110, 75, 80, 30);

        username = new JPasswordField();
        username.setBounds(110, 20, 80, 30);
        username.setEchoChar((char) 0);

        loginButton = new JButton("Login");
        loginButton.setBounds(110, 120, 80, 30);
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        loginButton.addActionListener(this);

        loginErrorLabel = new JLabel();
        loginErrorLabel.setBounds(20, 140, 80, 30);

        panel.add(username);
        panel.add(password);
        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(loginButton);
        panel.add(loginErrorLabel);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bank");
        frame.setVisible(true);

    }

    static void setVisibility(boolean arg) {
        frame.setVisible(arg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String pas = String.valueOf(password.getPassword());
        String user = String.valueOf(username.getPassword());

        if (source == loginButton) {

            try {
                if (Bank.checkCredentials(user, pas)) {
                    Gui.setVisibility(false);
                    frame.dispose();
                    Window window = new Window(Bank.returnClient(user));

                }
            } catch (Exception e1) {

                e1.printStackTrace();
            }

        }
    }

}
