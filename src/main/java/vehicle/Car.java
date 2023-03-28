package vehicle;

import java.util.List;

public abstract class Car {
    private String mke;
    private String mdl;
    protected Double mlg;

    public Car(String make, String model, double startingMileage) {
        if (startingMileage < 0) {
            throw new IllegalArgumentException();
        }
        mke = make;
        mdl = model;
        mlg = startingMileage;
    }
    
    public Car(String make, String model) {
        this(make, model, 0);
    }

    public boolean canDrive(double miles) throws IllegalArgumentException{
        if (miles < 0) {
            throw new IllegalArgumentException();
        }
        if (miles > getRemainingRange()) {
            return false;
        }
        return true;
    }

    public abstract void drive(double miles);

    public String toString() {
        return String.format("%s %s (%.1f mi)", mke, mdl, mlg);
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
    public int roadTrip(List<Double> milesEachDay) throws IllegalArgumentException {
        int i = 0;
        for(Double d : milesEachDay) {
            if (d < 0) {
                throw new IllegalArgumentException();
            }
            if (!canDrive(d)) {
                return i;
            }
            drive(d);
            i++;
        }
        return i;
    }
}
