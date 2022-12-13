//CrewMember is a subclass of person
public class CrewMember extends person {
    //CrewMember constructor uses the super keyword
    CrewMember(String name, int passportNumber){
        super(name,passportNumber);
    }

    //Calculates the Weight of the Crew Members
    public double calculatePersonWeight() {
        return 75; //returns 75 as each crew member has a limit of 75
    }

}
