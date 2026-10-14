import javax.swing.*;
import java.awt.*;
public class BookingFrame extends JFrame {
    JComboBox<Train> trainBox; JComboBox<String> classBox;
    JTextField nameField, ageField, sourceField, destinationField; boolean tatkal;
    BookingFrame(boolean tatkal) {
        this.tatkal=tatkal; setTitle(tatkal ? "Tatkal Booking" : "Normal Railway Booking");
        setSize(600, 500); setLocationRelativeTo(null); setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel(new GridLayout(8, 2, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        p.add(new JLabel("Source")); sourceField=new JTextField("Hyderabad"); p.add(sourceField);
        p.add(new JLabel("Destination")); destinationField=new JTextField(); p.add(destinationField);
        p.add(new JLabel("Train")); trainBox=new JComboBox<>(); for (Train t:ReservationSystem.trains) trainBox.addItem(t); p.add(trainBox);
        p.add(new JLabel("Passenger Name")); nameField=new JTextField(); p.add(nameField);
        p.add(new JLabel("Age")); ageField=new JTextField(); p.add(ageField);
        p.add(new JLabel("Class")); classBox=new JComboBox<>(new String[]{"SL","3A","2A"}); p.add(classBox);
        p.add(new JLabel("Booking Type")); p.add(new JLabel(tatkal ? "TATKAL" : "NORMAL"));
        JButton book=new JButton(tatkal ? "Book Tatkal Ticket" : "Book Ticket"); p.add(new JLabel()); p.add(book);
        book.addActionListener(e -> bookTicket()); add(p);
    }
    void bookTicket() {
        String name=nameField.getText().trim();
        if (name.isEmpty()) { JOptionPane.showMessageDialog(this,"Enter passenger name"); return; }
        try { if (Integer.parseInt(ageField.getText().trim()) <= 0) throw new Exception(); }
        catch(Exception e) { JOptionPane.showMessageDialog(this,"Enter a valid age"); return; }
        Train t=(Train)trainBox.getSelectedItem(); String cls=(String)classBox.getSelectedItem();
        int seats=ReservationSystem.getSeats(t,cls);
        if (seats<=0) { JOptionPane.showMessageDialog(this,"No seats available in "+cls); return; }
        double fare=cls.equals("SL") ? t.sleeperFare : cls.equals("3A") ? t.ac3Fare : t.ac2Fare;
        if (tatkal) fare+=200;
        ReservationSystem.reduceSeat(t,cls);
        String pnr=ReservationSystem.generatePNR();
        String seat=cls+"-"+(31-seats);
        Ticket ticket=new Ticket(pnr,name,String.valueOf(t.number),t.name,cls,tatkal?"TATKAL":"NORMAL",seat,fare);
        ReservationSystem.tickets.add(ticket); new TicketFrame(ticket).setVisible(true); dispose();
    }
}
