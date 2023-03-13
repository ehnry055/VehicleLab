@throws IllegalArgumentException if startingMileage is negative*/

public Car(String make, String model, double startingMileage)

public Car(String make, String model)

@throws IllegalArgumentException 
public boolean canDrive(double miles)
@throws IllegalArgumentException 
public abstract void drive(double miles)

public String toString()
public double getMileage()
public String getMake()
public String getModel()
public abstract double getRemainingRange()

@throws IllegalArgumentException 
protected void addMileage(double miles);

@throws IllegalArgumentException 
public int roadTrip(List<Double> milesEachDay)