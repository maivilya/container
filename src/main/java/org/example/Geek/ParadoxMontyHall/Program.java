package org.example.Geek.ParadoxMontyHall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Program {

    private static final Map<Integer, Boolean> STATISTIC_CHANGE_DOOR = new HashMap<>();
    private static final Map<Integer, Boolean> STATISTIC_D0_NOT_CHANGE_DOOR = new HashMap<>();
    private static final Random random = new Random();
    private static final int DOORS_COUNT = 3;
    private static final int DOT_GOAT = 0;
    private static final int DOT_CAR = 1;
    private static final int[] DOORS = new int[DOORS_COUNT];
    private static final int ATTEMPTS = 1000;

    public static void main(String[] args) {

    }

    /**
     * За каждую дверь ставим козла, но за одну случайную дверь ставим главный приз - машину.
     */
    private static void initDoors() {
        Arrays.fill(DOORS, DOT_GOAT);
        DOORS[random.nextInt(3)] = DOT_CAR;
    }

    /**
     * В этом методе мы намеренно заставляем игрока быть верным своему изнчальному выбору.
     * По сути, в этом методе переменная leadingOpenDoor не нужна, потому что визуально(графически)
     * мы двери не открываем, и переменная secondChoice в любом случае будет равна firstChoice.
     * @param attempt игровой шаг
     */
    private static void playerDoNotChangeDoor(int attempt) {
        int winDoor = -1;
        int firstChoice = random.nextInt(DOORS_COUNT);
        int leadingChoiceDoor = -1;
        int secondChoice = -1;

        for (int i = 0; i < DOORS.length; i++) {
            if (DOORS[i] == DOT_CAR) {
                winDoor = i;
            }
        }

        for (int i = 0; i < DOORS.length; i++) {
            if ((i != winDoor) && (i != firstChoice)) {
                leadingChoiceDoor = i;
            }
        }

        for (int i = 0; i < DOORS.length; i++) {
            if (i == firstChoice) {
                secondChoice = firstChoice;
                break;
            }
        }
        STATISTIC_D0_NOT_CHANGE_DOOR.put(attempt, secondChoice == winDoor);
    }

    /**
     * В этом методе мы намеренно заставляем игрока изменить свой выбор.
     * @param attempt игровая попытка
     */
    private static void playerChangeDoor(int attempt) {
        int winDoor = -1;
        int firstChoice = random.nextInt(DOORS_COUNT);
        int leadingChoiceDoor = -1;
        int secondChoice = -1;

        for (int i = 0; i < DOORS.length; i++) {
            if (DOORS[i] == DOT_CAR) {
                winDoor = i;
            }
        }

        for (int i = 0; i < DOORS.length; i++) {
            if ((i != winDoor) && (i != firstChoice)) {
                leadingChoiceDoor = i;
            }
        }

        for (int i = 0; i < DOORS.length; i++) {
            if ((i != firstChoice) && (i != leadingChoiceDoor)) {
                secondChoice = i;
            }
        }
        STATISTIC_CHANGE_DOOR.put(attempt, secondChoice == winDoor);
    }
}
