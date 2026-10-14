import javax.swing.*;
import java.awt.*;
public class Dashboard extends JFrame {
    Dashboard(String user) {
        setTitle("Railway Reservation System");
        setSize(650, 480); setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel main = new JPanel(new BorderLayout(10, 10));
        main.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        JLabel title = new JLabel("Welcome, " + user, SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24)); main.add(title, BorderLayout.NORTH);
        JPanel buttons = new JPanel(new GridLayout(5, 1, 15, 15));
        JButton search = new JButton("Search & Book Train");
        JButton tatkal = new JButton("Tatkal Booking");
        JButton history = new JButton("Booking History");
        JButton cancel = new JButton("Cancel Ticket");
        JButton exit = new JButton("Exit");
        buttons.add(search); buttons.add(tatkal); buttons.add(history); buttons.add(cancel); buttons.add(exit);
        search.addActionListener(e -> new BookingFrame(false).setVisible(true));
        tatkal.addActionListener(e -> new BookingFrame(true).setVisible(true));
        history.addActionListener(e -> new HistoryFrame().setVisible(true));
        cancel.addActionListener(e -> new CancellationFrame().setVisible(true));
        exit.addActionListener(e -> System.exit(0));
        main.add(buttons, BorderLayout.CENTER); add(main);
    }
}
