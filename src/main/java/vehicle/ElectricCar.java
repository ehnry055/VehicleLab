package vehicle;
public abstract class ElectricCar extends Car {
    double milesOnMaxCharge;
    double mileage;
    double charge;
    /**
     * Note: Car begins with a full charge (and thus range).
     * 
     * @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.
     */
    public ElectricCar(String make, String model, double startingMileage, double milesOnMaxCharge) {
        super(make, model, startingMileage);
        this.milesOnMaxCharge = milesOnMaxCharge;
        mileage = startingMileage;
        charge = milesOnMaxCharge;
        if (milesOnMaxCharge < 0){
            throw new IllegalArgumentException();
        }
    }
    /**
     * Defaults mileage to 0.
     * 
     * @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.
     */
    public ElectricCar(String make, String model, double milesOnMaxCharge) {
        super(make,model);
        this.milesOnMaxCharge = milesOnMaxCharge;
    }

    /**
     * Drives the full given number of miles.
     * 
     * @throws IllegalArgumentException if miles is negative.
     * @throws IllegalArgumentException if miles is too high given the current charge.
     */
    public void drive(double miles) {
        mileage += miles;
        if (miles < 0 || miles > getRemainingRange()){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns how many more miles the car can currently go without
     * recharging.
     */
    public double getRemainingRange() {
        return charge;
    }

    /** Returns how many miles the car could go on a full charge. */
    public double getMaxRange() {
        return milesOnMaxCharge;
    }

    /** Recharges the car to max range capability. */
    public void recharge() {
        charge += (milesOnMaxCharge - charge);
    }

    /**
     * Decreases the amount of energy in the battery based by the number
     * of miles passed as an argument.
     */
    protected void decreaseCharge(double miles) {
        charge = milesOnMaxCharge - miles;
    }
}

