package mars.rover;

import sun.security.util.ArrayUtil;

import java.util.stream.IntStream;

/*
#######################################

Project: MarsRover
forked from: https://github.com/aatwi/MarsRover-Refactoring-Kata
Lucas Straub, Yannik Wailzer

#######################################
 */

public class MarsRover {

    public static String move(int x, int y, char direction, String instructions) {
        if(x<0 || y<0) {
            throw new IllegalArgumentException();
        }

        if(direction!='N' && direction!='E' && direction!='S' && direction!='W') {
            throw new IllegalArgumentException();
        }



        if (!instructions.isEmpty()) {
            char instruction = instructions.charAt(0);

            if(instruction!='L' && instruction!='M' && instruction!='R') {
                throw new IllegalArgumentException();
            }

            char nextDirection = nextDirection(instruction, direction);
            if(x+moveX(instruction, nextDirection)>=0 && y+moveY(instruction, nextDirection)>=0) {
                return move(x+moveX(instruction, nextDirection), y+moveY(instruction, nextDirection), nextDirection, instructions.substring(1));
            }

        }

        return x + " " + y + " " + direction;

    }

    private static char nextDirection(char instruction, char direction) {
        char[] DIRECTIONS = {'N', 'E', 'S', 'W'};

        int len = DIRECTIONS.length;
        int index = IntStream.range(0, len)
                .filter(i -> direction == DIRECTIONS[i])
                .findFirst()
                .orElse(-1);

        if(instruction=='L') {
            index--;
        } else if(instruction=='R') {
            index++;
        } else {
            // do nothing
        }

        if(index<0) {
            index=DIRECTIONS.length-1;
        }
        if(index>=DIRECTIONS.length) {
            index=0;
        }

        return DIRECTIONS[index];
    };

    private static int moveX(char instruction, char direction) {
        if(instruction=='M') {
            if(direction=='E') {
                return 1;
            } else if (direction=='W') {
                return -1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }

    }

    private static int moveY(char instruction, char direction) {
        if(instruction=='M') {
            if(direction=='N') {
                return 1;
            } else if(direction=='S') {
                return -1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
