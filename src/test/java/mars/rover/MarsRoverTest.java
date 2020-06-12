package mars.rover;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

    @Test
    public void
    acceptance_test_1() {
        String newPosition = MarsRover.move(1, 2, 'N', "LMLMLMLMM");
        assertEquals("1 3 N", newPosition);
    }

    @Test
    public void
    acceptance_test_2() {
        String newPosition = MarsRover.move(3, 3, 'E', "MMRMMRMRRM");
        assertEquals("5 1 E", newPosition);
    }

    @Test(expected = IllegalArgumentException.class)
    public void
    yannikTest1() {
        String newPosition = MarsRover.move(-1, -1, 'S', "RMMR");
    }

    @Test
    public void
    yannikTest2() {
        String newPosition = MarsRover.move(-1, -1, 'S', "RMMR");
        assertEquals("-1 -1 S", newPosition);
    }

}