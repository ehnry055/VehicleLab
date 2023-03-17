package vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Group3_5_ChevroletBird_Tests {
    @Test
    public void birdNoMileageConstructor() {
        ChevroletBird bird = new ChevroletBird();
        assertEquals(0, bird.getMileage(), 0.1, "Default mileage should be zero.");
        assertEquals(250, bird.getRemainingRange(),  0.1, "Initial charge not correct.");
        assertEquals(bird.getMaxRange(), bird.getRemainingRange(), 0.1, "The car should begin full.");
        assertEquals("Bird Chevrolet (0.0 mi)", bird.toString(), "toString does not match");
    }

    @Test
    public void birdMileageConstructor() {
        ChevroletBird bird = new ChevroletBird(500);
        assertEquals(500, bird.getMileage(), 0.1, "Default mileage should be 500.");
        assertEquals(250, bird.getRemainingRange(),  0.1, "Initial charge not correct.");
        assertEquals(bird.getMaxRange(), bird.getRemainingRange(), 0.1, "The car should begin full.");
        assertEquals("Bird Chevrolet (0.0 mi)", bird.toString(), "toString does not match");
    }

    @Test
    public void hondaConstructorTest2() {
        HondaAccordian honda = new HondaAccordian(2018);

        assertThrows(IllegalArgumentException.class, () -> {
            honda.drive(-1);
        }, "Driving mileage cannot be negative.");

       assertTrue(honda.canDrive(30), "canDrive should be true");
       honda.drive(30);
        assertEquals(30, honda.getMileage(), .1, "Mileage should be 30 after first drive.");

        honda.drive(200);
        assertEquals(230, honda.getMileage(), .1, "Mileage should be 230 after second drive.");

        assertEquals(honda.getFuelCapacity() * honda.getMPG() - 230, honda.getRemainingRange(), .1,
                "Remaining range of car not correct after driving twice.");

        assertFalse(honda.canDrive(252), "Driving 252 should fail.");
        assertTrue(honda.canDrive(251), "Driving 251 should succeed.");

        honda.drive(251);
        assertEquals(481, honda.getMileage(), .1, "Mileage should be 481 after third drive.");

        assertThrows(IllegalArgumentException.class, () -> {
            honda.drive(5);
        }, "Driving beyond empty should fail.");
    }
}
