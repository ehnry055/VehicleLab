public abstract class Car {
    private String mke;
    private String mdl;
    private Double mlg;

    public Car(String make, String model, double startingMileage) {
        if (startingMileage < 0) {
            throw new IllegalArgumentException();
        }
        mke = make;
        mdl = model;
        mlg = startingMileage;
    }
    
    public Car(String make, String model) {
        startingMileage = 0;
    }

    public boolean canDrive(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException();
        }
        if (mlg - miles < 0) {
            return false;
        }
        return true;
    }

    public abstract void drive(double miles);

public String toString()
public double getMileage()
public String getMake()
public String getModel()
public abstract double getRemainingRange()

@throws IllegalArgumentException 
protected void addMileage(double miles);

@throws IllegalArgumentException 
public int roadTrip(List<Double> milesEachDay)
    public String toString() {
        return ("%s and %s (%f mi)", mke, mdl, mlg);
    }

    public double getMileage() {
        return mlg;
    }
    public String getMake() {
        return mke;
    }
    public String getModel() {
        return mdl;
    }
    public abstract double getRemainingRange(); 

    protected void addMileage(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException();
        }
        mlg += miles;
    }
    //dont know if this workssssssssss
    public int roadTrip(List<Double> milesEachDay) {
        Double remain = mlg;
        int i = 0;
        for(Double d : milesEachDay) {
            if (d < 0) {
                throw new IllegalArgumentException();
            }
            remain -= d;
            if (remain < 0) {
                return i;
            }
            i++;
        }
        return i;
    }
}
