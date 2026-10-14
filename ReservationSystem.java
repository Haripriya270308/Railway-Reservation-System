import java.util.*;
public class ReservationSystem {
    static ArrayList<Train> trains = new ArrayList<>();
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static {
        trains.add(new Train(12785, "Kacheguda Express", "Hyderabad", "Bangalore", 30, 15, 8, 650, 1200, 1750));
        trains.add(new Train(12760, "Charminar Express", "Hyderabad", "Chennai", 25, 12, 6, 600, 1100, 1600));
        trains.add(new Train(17015, "Visakha Express", "Hyderabad", "Visakhapatnam", 20, 10, 5, 550, 1050, 1500));
    }
    static String generatePNR() { return String.valueOf(1000000000L + new Random().nextInt(900000000)); }
    static int getSeats(Train t, String cls) {
        if (cls.equals("SL")) return t.sleeperSeats;
        if (cls.equals("3A")) return t.ac3Seats;
        return t.ac2Seats;
    }
    static void reduceSeat(Train t, String cls) {
        if (cls.equals("SL")) t.sleeperSeats--;
        else if (cls.equals("3A")) t.ac3Seats--;
        else t.ac2Seats--;
    }
    static boolean cancelTicket(String pnr) {
        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            if (ticket.pnr.equals(pnr)) {
                for (Train train : trains) {
                    if (String.valueOf(train.number).equals(ticket.trainNumber)) {
                        if (ticket.travelClass.equals("SL")) train.sleeperSeats++;
                        else if (ticket.travelClass.equals("3A")) train.ac3Seats++;
                        else if (ticket.travelClass.equals("2A")) train.ac2Seats++;
                        break;
                    }
                }
                tickets.remove(i);
                return true;
            }
        }
        return false;
    }
}
