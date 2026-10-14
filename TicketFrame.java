import javax.swing.*;
import java.awt.*;
public class TicketFrame extends JFrame {
    TicketFrame(Ticket t) {
        setTitle("Ticket Confirmation"); setSize(520,400); setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea area=new JTextArea(); area.setFont(new Font("Monospaced",Font.PLAIN,15)); area.setEditable(false);
        area.setText("====================================\n       RAILWAY TICKET CONFIRMED      \n====================================\n\n"+
            "PNR            : "+t.pnr+"\nPassenger      : "+t.passengerName+"\nTrain          : "+t.trainNumber+" - "+t.trainName+
            "\nClass          : "+t.travelClass+"\nBooking Type   : "+t.type+"\nSeat           : "+t.seat+
            "\nFare           : Rs. "+t.fare+"\n\n        BOOKING SUCCESSFUL!\n====================================");
        add(new JScrollPane(area));
    }
}
