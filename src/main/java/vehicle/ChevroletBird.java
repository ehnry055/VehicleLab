package vehicle;

public class ChevroletBird extends ElectricCar implements Flying{
    double fullcharge = 250;
    boolean wings;
    /** Chevrolet Birds have a 250 mile range on a full charge. They
    start with their wings retracted.*/
    public ChevroletBird(double startingMileage){
        super("Chevrolet", "Bird", startingMileage, 250);
    }

    /** Defaults mileage to 0. */
    public ChevroletBird(){
        super("Chevrolet", "Bird", 0, 250);

    }

    /** Returns whether the wings are currently extended. */
    public boolean checkWingsExtended() {
       return wings; 
    }

    /**
     * Drives just like all other Electric Cars, except make sure that
     * you retract your wings first (duh).
     * Coding tip: Write this method to re-use the behavior of the
     * superclass drive. Don’t copy-and-paste the same code here.
     */
    public void drive(double miles) {
        wings = false;
        super.drive(miles);
    }

    public boolean canFly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException();
        }
        if (getRemainingRange() >= miles) {
            return true;
        }
        else {
            return false;
            }
        } 

    /** @throws IllegalArgumentException if miles is negative.
    @throws IllegalArgumentException if miles exceeds the remaining
    range of the car.
    */
    public void fly(double miles) {
        if (miles < 0 || miles > getRemainingRange()) {
            throw new IllegalArgumentException();
        }
        wings = true;
        decreaseCharge(miles);
    }
}
