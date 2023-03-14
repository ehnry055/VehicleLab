package vehicle;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{

    public FordFrivolous (double startingMileage) {
        super("Ford", "Frivolous", startingMileage, 23.6, 20);
    }

    public FordFrivolous() {
        super("Ford", "Frivolous", 0, 23.6, 20);
    }

    public void driveAutonomously(double miles) {
        super.drive(miles);
        super.decreaseFuelLevel(miles);
    }

    public boolean canFly(double miles) {
        if (tank - (miles / per) < 0) {
            return false;
        }
        return true;
    }

    public void fly(double miles) {
        if (miles < 0 || ) {
            throw new IllegalArgumentException();
        }
        tank -= 3*(miles / per);
    }
}
