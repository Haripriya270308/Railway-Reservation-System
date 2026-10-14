public class Train {
    int number; String name, source, destination;
    int sleeperSeats, ac3Seats, ac2Seats;
    double sleeperFare, ac3Fare, ac2Fare;
    Train(int number, String name, String source, String destination, int sleeperSeats, int ac3Seats, int ac2Seats,
          double sleeperFare, double ac3Fare, double ac2Fare) {
        this.number=number; this.name=name; this.source=source; this.destination=destination;
        this.sleeperSeats=sleeperSeats; this.ac3Seats=ac3Seats; this.ac2Seats=ac2Seats;
        this.sleeperFare=sleeperFare; this.ac3Fare=ac3Fare; this.ac2Fare=ac2Fare;
    }
    public String toString() { return number + " - " + name + " (" + source + " → " + destination + ")"; }
}
