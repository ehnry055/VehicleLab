package vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FordFrivolous_Tests {

    @Test
    public void fordConstructorTest1() {
        FordFrivolous ford = new FordFrivolous();
        assertEquals(0, ford.getMileage(), 0.1, "Default mileage should be zero.");
        assertEquals(20, ford.getFuelCapacity(),  0.1, "Initial fuel capacity not correct.");
        assertEquals(ford.getFuelCapacity(), ford.getFuelLevel(), 0.1, "The car should begin full.");
        assertEquals(23.6, ford.getMPG(), 0.1, "Initial mpg not correct.");
        assertEquals(ford.getFuelCapacity() * ford.getMPG(), ford.getRemainingRange(), 0.1,
                "Remaining range of car not correct at creation.");
        assertEquals("Ford Frivolous (0.0 mi)", ford.toString(), "toString does not match");
    }

    @Test
    public void fordConstructorTest2() {
        FordFrivolous ford = new FordFrivolous();

        assertThrows(IllegalArgumentException.class, () -> {
            ford.drive(-1);
        }, "Driving mileage cannot be negative.");

       assertTrue(ford.canDrive(30), "canDrive should be true");
       ford.drive(30);
        assertEquals(30, ford.getMileage(), .1, "Mileage should be 30 after first drive.");

        ford.drive(200);
        assertEquals(230, ford.getMileage(), .1, "Mileage should be 230 after second drive.");

        assertEquals(ford.getFuelCapacity() * ford.getMPG() - 230, ford.getRemainingRange(), .1,
                "Remaining range of car not correct after driving twice.");

        assertFalse(ford.canDrive(243), "Driving 243 should fail.");
        assertTrue(ford.canDrive(242), "Driving 242 should succeed.");

        ford.drive(242);
        assertEquals(472, ford.getMileage(), .1, "Mileage should be 481 after third drive.");

        assertThrows(IllegalArgumentException.class, () -> {
            ford.drive(5);
        }, "Driving beyond empty should fail.");
    }

    @Test
    public void fordConstructorTest3() {
        FordFrivolous ford = new FordFrivolous(2309185);

        
    }

    @Test
    public void fordConstructorTest4() {
        FordFrivolous ford = new FordFrivolous();
        assertThrows(IllegalArgumentException.class, () -> {
            ford.driveAutonomously(.5);
        }, "Driving beyond empty should fail.");

        ford.driveAutonomously(45);
        assertEquals(45, ford.getMileage(), .1, "Mileage should be 30 after first drive.");
        assertEquals(472-90, ford.getRemainingRange(), 0.1,"Remaining range should be subtracted by double the amount");
        assertTrue(ford.canDrive(382), "Driving 382 should fail.");
        assertTrue(ford.canDrive(191), "Driving 191 should succeed.");
        assertTrue(ford.canDrive(192), "Driving 192 should fail.");
        ford.driveAutonomously(191);
        assertEquals(236, ford.getMileage(), .1, "Mileage should be 236.");
        assertEquals(0, ford.getRemainingRange(), 0.1,"Remaining range should be 0");

        assertThrows(IllegalArgumentException.class, () -> {
            ford.driveAutonomously(5);
        }, "Driving beyond empty should fail.");


    }
}
