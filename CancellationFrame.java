import javax.swing.*;
import java.awt.*;
public class CancellationFrame extends JFrame {
    private JTextField pnrField;
    public CancellationFrame() {
        setTitle("Cancel Railway Ticket"); setSize(480,220); setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel=new JPanel(new GridLayout(3,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(25,30,25,30));
        panel.add(new JLabel("Enter the PNR of the ticket to cancel:"));
        pnrField=new JTextField(); panel.add(pnrField);
        JButton cancelButton=new JButton("Cancel Ticket");
        cancelButton.addActionListener(e -> cancelTicket()); panel.add(cancelButton); add(panel);
    }
    private void cancelTicket() {
        String pnr=pnrField.getText().trim();
        if(pnr.isEmpty()) { JOptionPane.showMessageDialog(this,"Please enter a PNR number."); return; }
        int choice=JOptionPane.showConfirmDialog(this,
            "Are you sure you want to cancel ticket PNR "+pnr+"?","Confirm Cancellation",JOptionPane.YES_NO_OPTION);
        if(choice!=JOptionPane.YES_OPTION) return;
        if(ReservationSystem.cancelTicket(pnr)) {
            JOptionPane.showMessageDialog(this,"Ticket cancelled successfully. The seat is available again.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,"No active ticket found with PNR "+pnr+".","PNR Not Found",JOptionPane.WARNING_MESSAGE);
        }
    }
}
