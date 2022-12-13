//abstract class
public abstract class person {
    //private instances
    private String name;
    private int passportNumber;

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
    public person(String name, int passportNumber){
        this.name = name;
        this.passportNumber = passportNumber;
    }

    //creates a public abstract function
    public abstract double calculatePersonWeight();
}
