package vehicle;

public abstract class GasPoweredCar extends Car {
    private double per;
    private double tank;
    private double cap;

    public GasPoweredCar(String make, String model, double startingMileage, double mpg, double fuelCapacityGallons) {
        super(make, model, startingMileage);
        if (mpg < 0 || fuelCapacityGallons < 0) {
            throw new IllegalArgumentException();
        }
    
        per = mpg;
        tank = fuelCapacityGallons;
        cap = fuelCapacityGallons;

    }
    public GasPoweredCar (String make, String model, double mpg, double fuelCapacityGallons) {
        this(make, model, 0, mpg, fuelCapacityGallons);
    }

    public void drive(double miles) throws IllegalArgumentException {
        if (miles < 0 || miles > getRemainingRange()) {
            throw new IllegalArgumentException();
        }
        super.addMileage(miles);
        decreaseFuelLevel(miles);
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

    public void refillTank(double gallons) throws IllegalArgumentException {
        if(gallons < 0 || tank + gallons > cap) {
            throw new IllegalArgumentException();
        }
        tank += gallons;
    }

    protected void decreaseFuelLevel(double miles) {
        tank -= (miles / per);
    }
}
