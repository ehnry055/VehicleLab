package vehicle;
public abstract class GasPoweredCar extends Car {
    private String mke;
    private String mdl;
    private double mlg;
    private double per;
    private double tank;
    private double cap;

    public GasPoweredCar(String make, String model, double startingMileage, double mpg, double fuelCapacityGallons) {
        if (mpg < 0 || fuelCapacityGallons < 0) {
            throw new IllegalArgumentException();
        }
        mke = make;
        mdl = model;
        mlg = startingMileage;
        per = mpg;
        tank = fuelCapacityGallons;
        cap = fuelCapacityGallons;

    }
    public GasPoweredCar (String make, String model, double mpg, double fuelCapacityGallons) {
        if (mpg < 0 || fuelCapacityGallons < 0) {
            throw new IllegalArgumentException();
        }
        mke = make;
        mdl = model;
        mlg = 0;
        per = mpg;
        tank = fuelCapacityGallons;
        cap = fuelCapacityGallons;
    }

    public void drive(double miles) {
        mlg += miles;
        tank -= (miles / per); 
    }

    public double getMPG() {
        return per;
    }

    public double getFuelLevel() {
        return tank;
    }

    public double getFuelCapacity() {
        return cap;
    }

    public void refillTank() {
        tank = cap;
    }

    public double getRemainingRange() {
        return tank * per;
    }

    public void refillTank(double gallons) {
        if(gallons < 0 || tank + gallons > cap) {
            throw new IllegalArgumentException();
        }
        tank += gallons;
    }

    protected void decreaseFuelLevel(double miles) {
        tank -= (miles / per);
    }
}
