public class Ticket {
    String pnr, passengerName, trainName, trainNumber, travelClass, type, seat;
    double fare;
    Ticket(String pnr, String passengerName, String trainNumber, String trainName,
           String travelClass, String type, String seat, double fare) {
        this.pnr=pnr; this.passengerName=passengerName; this.trainNumber=trainNumber;
        this.trainName=trainName; this.travelClass=travelClass; this.type=type; this.seat=seat; this.fare=fare;
    }
}
