public class Seat {
    //private instances
    private int row;
    private int seat;
    private String flyingClass;
    private Passenger allocatedTo;

    //getters and setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getFlyingClass() {
        return flyingClass;
    }

    public void setFlyingClass(String flyingClass) {
        this.flyingClass = flyingClass;
    }

    public Passenger getAllocatedTo() {
        return allocatedTo;
    }

    //allocates seats to Passenger
    public void setAllocatedTo(Passenger allocatedTo) {
        this.allocatedTo = allocatedTo;
    }

    //Seat constructor
    public Seat(int row, int seat, String flyingClass) {
        this.row = row;
        this.seat = seat;
        this.flyingClass = flyingClass;
    }

}
