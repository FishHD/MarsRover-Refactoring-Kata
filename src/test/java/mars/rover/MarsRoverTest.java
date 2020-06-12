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

    @Test
    public void lucas_test_1() {
        String newPosition = MarsRover.move(0, 0, 'S', "MMMMMMM");
        assertEquals("0 0 S", newPosition);
    }

    @Test
    public void lucas_test_2() {
        String newPosition = MarsRover.move(0, 0, 'W', "MMMMMMMMMMMMMM");
        assertEquals("0 0 W", newPosition);
    }

    @Test
    public void lucas_test_3() {
        String newPosition = MarsRover.move(1, 1, 'N', "MMMRM");
        assertEquals("2 4 E", newPosition);
    }

    @Test
    public void lucas_test_4() {
        String newPosition = MarsRover.move(1, 1, 'N', "M");
        assertEquals("1 2 N", newPosition);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lucas_test_5() {
        String newPosition = MarsRover.move(-1, -1, 'N', "M");
    }

}