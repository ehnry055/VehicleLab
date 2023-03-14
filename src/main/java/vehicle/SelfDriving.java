package vehicle;
public interface SelfDriving {
    public void driveAutonomously(double miles) {
        
    }
}

interface Flying {
    public boolean canFly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException();
        }
    }

    public void fly(double miles) {

    }
}
