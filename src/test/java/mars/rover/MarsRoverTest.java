package mars.rover;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

    @Test
    public void acceptance_test_1() {
        String newPosition = MarsRover.move(1, 2, 'N', "LMLMLMLMM");
        assertEquals("1 3 N", newPosition);
    }

    @Test
    public void acceptance_test_2() {
        String newPosition = MarsRover.move(3, 3, 'E', "MMRMMRMRRM");
        assertEquals("5 1 E", newPosition);
    }

    @Test(expected = IllegalArgumentException.class)
    public void acceptance_test_3() {
        String newPosition = MarsRover.move(-1, -1, 'S', "RMMR");
    }

    @Test
    public void acceptance_test_4_position_error() {
        String newPosition = MarsRover.move(0, 0, 'N', "LM");
        assertEquals("0 0 W", newPosition);
    }

    @Test
    public void acceptance_test_5() {
        String newPosition = MarsRover.move(0, 0, 'N', "LLLL");
        assertEquals("0 0 N", newPosition);
    }

    @Test
    public void acceptance_test_6() {
        String newPosition = MarsRover.move(0, 0, 'N', "RRRR");
        assertEquals("0 0 N", newPosition);
    }

    @Test
    public void acceptance_test_7() {
        String newPosition = MarsRover.move(0, 0, 'N', "MRMRMRMR");
        assertEquals("0 0 N", newPosition);
    }

    @Test
    public void acceptance_test_8() {
        String newPosition = MarsRover.move(5, 5, 'W', "MLMLMRMLMLMRMRMLMLMLMRMRMLMRMRMLMLMLMRMLMLMRMRMRMLMLMRMRMLMRMRM");
        assertEquals("9 9 S", newPosition);
    }

    @Test
    public void acceptance_test_9() {
        String newPosition = MarsRover.move(3, 2, 'S', "RMLMRMLLMMMLMRMRMMRMMMMRM");
        assertEquals("1 1 N", newPosition);
    }

    @Test
    public void acceptance_test_10() {
        String newPosition = MarsRover.move(1, 1, 'S', "LMMMMLMMLMLMRMMMRRMLMRMLM");
        assertEquals("3 4 N", newPosition);
    }

    @Test
    public void acceptance_test_empty_string() {
        String newPosition = MarsRover.move(5, 5, 'N', "");
        assertEquals("5 5 N", newPosition);
    }

    @Test(expected = IllegalArgumentException.class)
    public void acceptance_test_wrong_command() {
        String newPosition = MarsRover.move(5, 5, 'N', "F");
    }

    @Test(expected = IllegalArgumentException.class)
    public void acceptance_test_wrong_char() {
        String newPosition = MarsRover.move(5, 5, 'F', "MM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void acceptance_test_space_command() {
        String newPosition = MarsRover.move(5, 5, 'N', "MRM RMRMR");
    }

}