import javax.swing.*;
import java.awt.*;
public class LoginFrame extends JFrame {
    JTextField username;
    JPasswordField password;
    LoginFrame() {
        setTitle("Railway Reservation - Login");
        setSize(420, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel(new GridLayout(5, 1, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        p.add(new JLabel("Username"));
        username = new JTextField(); p.add(username);
        p.add(new JLabel("Password"));
        password = new JPasswordField(); p.add(password);
        JButton login = new JButton("Login"); p.add(login);
        login.addActionListener(e -> {
            if (username.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter username"); return;
            }
            new Dashboard(username.getText().trim()).setVisible(true); dispose();
        });
        add(p);
    }
}
