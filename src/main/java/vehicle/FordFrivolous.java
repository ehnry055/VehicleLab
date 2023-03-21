package vehicle;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{

    public FordFrivolous (double startingMileage) {
        super("Ford", "Frivolous", startingMileage, 23.6, 20);
    }

    public FordFrivolous() {
        super("Ford", "Frivolous", 0, 23.6, 20);
    }

    public void driveAutonomously(double miles) throws IllegalArgumentException{
        if(miles < 0) {
            throw new IllegalArgumentException();
        }
        if (getRemainingRange() < miles*2) {
            addMileage(getRemainingRange()/2);
            decreaseFuelLevel(getRemainingRange());
        }
        else {
            addMileage(miles);
            decreaseFuelLevel(miles*2);
        }
    }

    public boolean canFly(double miles) throws IllegalArgumentException{
        if (miles < 0) {
            throw new IllegalArgumentException();
        }
        if (getRemainingRange() < 3*miles) {
            return false;
        }
        return true;
    }

    public void fly(double miles) throws IllegalArgumentException {
        //will also change later
        if (miles < 0 || miles*3 > getRemainingRange()) {
            throw new IllegalArgumentException();
        }
        decreaseFuelLevel(3*miles);
    }
}
