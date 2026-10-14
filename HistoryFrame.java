import javax.swing.*;
public class HistoryFrame extends JFrame {
    HistoryFrame() {
        setTitle("Booking History"); setSize(700,400); setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String[] columns={"PNR","Passenger","Train","Class","Type","Seat","Fare"};
        String[][] data=new String[ReservationSystem.tickets.size()][7];
        for(int i=0;i<ReservationSystem.tickets.size();i++) {
            Ticket t=ReservationSystem.tickets.get(i);
            data[i][0]=t.pnr; data[i][1]=t.passengerName; data[i][2]=t.trainNumber+" "+t.trainName;
            data[i][3]=t.travelClass; data[i][4]=t.type; data[i][5]=t.seat; data[i][6]="Rs. "+t.fare;
        }
        add(new JScrollPane(new JTable(data,columns)));
    }
}
