import java.io.File;

public class Aircraft {
    //private instances
    private String make;
    private String model;
    private String tailNumber;
    private double craftWeight;
    private double maximumTakeoffWeight;
    private File layoutFile;

    //getters and setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public double getCraftWeight() {
        return craftWeight;
    }

    public void setCraftWeight(double craftWeight) {
        this.craftWeight = craftWeight;
    }

    public double getMaximumTakeoffWeight() {
        return maximumTakeoffWeight;
    }

    public void setMaximumTakeoffWeight(double maximumTakeoffWeight) {
        this.maximumTakeoffWeight = maximumTakeoffWeight;
    }

    //gets the file of the specific aircraft
    public File getLayoutFile() {
        return layoutFile;
    }

    public void setLayoutFile(File layoutFile) {
        this.layoutFile = layoutFile;
    }

    //Aircraft Constructor
    public Aircraft(String make, String model, String tailNumber, double craftWeight, double maximumTakeoffWeight, File layoutFile) {
        this.make = make;
        this.model = model;
        this.tailNumber = tailNumber;
        this.craftWeight = craftWeight;
        this.maximumTakeoffWeight = maximumTakeoffWeight;
        this.layoutFile = layoutFile;
    }

    //overrides the toString method so when called it can return all the details of the specific aircraft you are looking at
    @Override
    public String toString() {
        String Make= '\n' + "   Make: " + make + '\n'; //returns Aircraft Make
        String Model = "   Model: " + model + '\n' ; //returns Aircraft Model
        String TailNumber = "   Tail Number: " + tailNumber + '\n'; //returns Aircraft tailNumber
        String CraftWeight = "   Craft Weight: " + craftWeight + '\n'; //returns Aircraft Weight
        String MaximumTakeOffWeight = "   Maximum Take Off Weight: " + maximumTakeoffWeight; //returns Aircraft Maximum take of weight


        //this would put all the information about the aircraft and would return it.
        return(
                Make +
                Model +
                TailNumber +
                CraftWeight +
                MaximumTakeOffWeight
        );

    }


}

