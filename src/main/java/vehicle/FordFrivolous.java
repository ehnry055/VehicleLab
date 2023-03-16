package vehicle;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{

    public FordFrivolous (double startingMileage) {
        super("Ford", "Frivolous", startingMileage, 23.6, 20);
    }

    public FordFrivolous() {
        super("Ford", "Frivolous", 0, 23.6, 20);
    }

    public void driveAutonomously(double miles) {
        drive(miles);
        decreaseFuelLevel(miles);
    }

    public boolean canFly(double miles) {
        //will change later
        if (getRemainingRange() - 3*miles < 0) {
            return false;
        }
        return true;
    }

    public void fly(double miles) {
        //will also change later
        if (miles < 0 || getRemainingRange()-3*miles < 0) {
            throw new IllegalArgumentException();
        }
        decreaseFuelLevel(3*miles);
    }
}
