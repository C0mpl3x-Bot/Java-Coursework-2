import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Flight{
    //private instances
    private int flightNumber;
    private Aircraft craft;
    private String startLocation;
    private String endLocation;
    private double distance;

    //getters and setters
    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Aircraft getCraft() {
        return craft;
    }

    public void setCraft(Aircraft craft) {
        this.craft = craft;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    //creates two new array lists one for seats and one for crew member
    public ArrayList<Seat> seats;
    public ArrayList<CrewMember> crew = new ArrayList<>();

    //flight constructor
    //populates the seats arraylist by using the scanner class and calling the layout file from the aircraft class.
    public Flight(int flightNumber, Aircraft craft, String startLocation, String endLocation, double distance) {
        this.flightNumber = flightNumber;
        this.craft = craft;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
        this.seats = new ArrayList<>();
        //program statements to monitor for exceptions are placed in the try block
        try {
            //Populates Array List with available seats in specific flight classes using the layout file that was called in aircraft class
            Scanner in = new Scanner(craft.getLayoutFile());
            int row = 0;
            while (in.hasNextLine()) {
                String[] nextLine = in.nextLine().split(",");
                /* loops over the length of number of seats in the aircraft and then checks if it is First class or economy
                and depending it would populate the Array so if the File contains F it means that seat is first class seat
                and if it contains E it means that seat is an economy seat and this would be added to the array list with
                the row and the index and flight class of the seat */
                for (int i = 0; i < nextLine.length; i++) {
                    if (nextLine[i].contains("F")) {
                        seats.add(new Seat(row, i, "first"));
                    } else if (nextLine[i].contains("E")) {
                        seats.add(new Seat(row, i, "economy"));
                    }
                }
                //at the end of each iteration of the for loop increase the number of rows so new seats can be added to the arraylist.
                row++;
            }
        }
        //block of code to be run if an exception is raised in the try block
        catch (FileNotFoundException e) {
            System.out.println("Cant Find Flight Layout File");
        }
        this.crew = crew;

    }

    //calculates the aircraft's final weight if its too heavy it would return -1 if its is not it would return the final weight
    public double calculateTakeOffWeight() {
        double TotalPassengerWeight = 0;
        double TotalCrewWeight = 0;

        //calculates the total weight of the crew members and adds it on to the TotalCrewWeight variable
        for (int i = 0; i < crew.size(); i++) {
            TotalCrewWeight += crew.get(i).calculatePersonWeight();
        }
        /*calculates the total weight of the passenger members and adds it on to the TotalPassengerWeight variable
        if the seat you are looking at is null this would mean there are no passengers allocated to that seat so you
        would add 0 to the TotalPassengerWeight */
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).getAllocatedTo() == null) {
                TotalPassengerWeight += 0;
            } else {
                //adds on to the passengers weight at that seat tot he TotalPassengerWeight variable
                TotalPassengerWeight += seats.get(i).getAllocatedTo().calculatePersonWeight();
            }
        }

        //calculates the total weight of the aircraft by adding craft weight with total crew weight with total passenger weight.
        double TotalWeight = TotalCrewWeight + TotalPassengerWeight + craft.getCraftWeight();

        //if totalWeight is heavier than the maximum TakeoffWeight then it would return -1 indicating aircraft is too heavy
        //else it would return the total weight of the aircraft
        if (TotalWeight > craft.getMaximumTakeoffWeight()) {
            return -1;
        }
        return TotalWeight;
    }

    public int bookSeat(Passenger p) {
        //loops over the seats checks flight class and checks if there is space at that specific passengers flight class if there is it would return 1
        //else it would not do anything and downgrade or upgrade or return that the plane is full for that passenger
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).getFlyingClass().equals(p.getFlightClass())) {
                if (seats.get(i).getAllocatedTo() == null) {
                    seats.get(i).setAllocatedTo(p);
                    return 1;//booking complete
                }
            }
        }
        /* checks if the flight class of that specific passenger is first and if it is it would set their flight class
        to economy and check if there is a spare seat and allocate that spare seat to that passenger and it would
        return 3 if a seat is allocated in that new class */
        if (p.getFlightClass().equals("first")) {
            p.setFlightClass("economy");
            for (int i = 0; i < seats.size(); i++) {
                if (seats.get(i).getFlyingClass().equals(p.getFlightClass())) {
                    if (seats.get(i).getAllocatedTo() == null) {
                        seats.get(i).setAllocatedTo(p);
                        return 3;//downgrade the passenger flight class
                    }
                }
            }
        }

        /* checks if the flight class of that specific passenger is economy and if it is it would set their flight class
        to first and check if there is a spare seat and allocate that spare seat to that passenger and it would
        return 2 if a seat is allocated in that new class */
        else if (p.getFlightClass().equals("economy")) {
            p.setFlightClass("first");
            for (int i = 0; i < seats.size(); i++) {
                if (seats.get(i).getFlyingClass().equals(p.getFlightClass())) {
                    if (seats.get(i).getAllocatedTo() == null) {
                        seats.get(i).setAllocatedTo(p);
                        return 2; //upgrades the passenger flight class
                    }
                }
            }
        }

        //if no seats are available on the aircraft for that passenger then it return -1
        return -1; //plane is full
    }

    //overrides the toString method so when called it can return all the information about the flight and aircraft
    @Override
    public String toString() {
        String Space = "\n";
        String StartBreaker = "-------------" + "\n";
        String FlightNumber = "* Flight " + "#" + flightNumber + " *" + "\n"; //returns flight number
        String StartLocation = "From: " + startLocation + "\n"; //returns the start location of the aircraft
        String EndLocation = "To: " + endLocation + "\n"; //returns the end location of the aircraft
        String DistanceCovered = "Distance: " + distance + "\n"; //returns the distance covered
        String FirstClassPassengers = "First Class Passengers: "; //returns number of first class passengers
        String EconomyClassPassengers = "Economy Passengers: "; //returns number of passengers in economy class
        String SpareSeats = "Unallocated Seats: "; //returns the number of unallocated seats
        String CrewMemberNames = "Crew: "; //returns all crew members names.
        String Breaker = "-------------------------------------";
        String AircraftDetails = "\n" + "Aircraft Details: " + craft; //returns all the information of the aircraft by calling craft

        //for loop goes over the size of the crew gets each of their names and adds it to String seven.
        for (int i = 0; i < crew.size(); i++) {
            //adds each crew members name to the String followed with a comma
            CrewMemberNames += crew.get(i).getName() + " , ";
        }

        //create three new variables
        int NumberOfFirstSeats = 0;
        int NumberOfEconomySeats = 0;
        int UnallocatedSeats = 0;

        //loops over the number of seats available on the aircraft
        for (int j = 0; j < seats.size(); j++) {
            //checks if the seat is a first class seat and that a passenger is allocated
            //if both statements are true then it would increment the variable for NumberOfFirstSeats by 1
            if (seats.get(j).getFlyingClass().equals("first") && seats.get(j).getAllocatedTo() != null) {
                NumberOfFirstSeats++; //increment by 1
            }
            //else checks if the seat is an economy class seat and that a passenger is allocated
            //if both statements are true then it would increment the variable for NumberOfEconomySeats by 1
            else if (seats.get(j).getFlyingClass().equals("economy") && seats.get(j).getAllocatedTo() != null) {
                NumberOfEconomySeats++;//increment by 1
            }
            //else if the seat is an empty seat so there are no passengers allocated to the seat then increment UnallocatedSeats by 1
            else if (seats.get(j).getAllocatedTo() == null) {
                UnallocatedSeats++;//increment by 1
            }
        }
        //changes the int NumberOfFirstSeats to a string and adds it to the string that would return the number of first class seats in that aircraft
        FirstClassPassengers += String.valueOf(NumberOfFirstSeats) + "\n";

        //changes the int NumberOfEconomySeats to a string and adds it to the string that would return the number of economy class seats in that aircraft
        EconomyClassPassengers += String.valueOf(NumberOfEconomySeats) + "\n";

        //changes the int UnallocatedSeats to a string and adds it to the string that would return the number of unallocated seats in that aircraft
        SpareSeats += String.valueOf(UnallocatedSeats) + "\n";

        //this would put all the information about the flight and aircraft and would return it.
        return (
                Space +
                StartBreaker +
                FlightNumber +
                StartBreaker +
                StartLocation +
                EndLocation +
                DistanceCovered +
                FirstClassPassengers +
                EconomyClassPassengers +
                SpareSeats +
                CrewMemberNames +
                Space +
                Breaker +
                AircraftDetails +
                Space +
                Breaker
        );
    }
}



