//Passenger is a subclass of person
public class Passenger extends person {
    //private instances
    private int holdBags;
    private String flightClass;

    //Passenger constructor calls super keyword.
    public Passenger(String name, int passportNumber, String flightClass, int holdBags) {
        super(name, passportNumber);
        this.flightClass = flightClass;
        this.holdBags = holdBags;
    }

    //getters and setters
    public int getHoldBags() {
        return holdBags;
    }

    public void setHoldBags(int holdBags) {
        this.holdBags = holdBags;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    //calculates the total weight of the passengers on the aircraft by checking their flight class.
    public double calculatePersonWeight() {
        double PassengerWeight = 0;
        //if passenger flight class is first then add their weight on to PassengerWeight
        if(flightClass.equals("first")){
            PassengerWeight += (87.5 + (holdBags * 25));
        }
        //if passenger flight class is economy then add their weight on to PassengerWeight
        else if(flightClass.equals("economy")){
            PassengerWeight += (80 + (holdBags * 25));
        }
        //return total PassengerWeight
        return PassengerWeight;

    }
}
