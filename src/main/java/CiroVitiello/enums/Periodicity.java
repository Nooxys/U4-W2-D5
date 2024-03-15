package CiroVitiello.enums;

import java.util.Random;

public enum Periodicity {
    WEEKLY, MONTHLY, HALF_YEARLY;

    private static final Random random = new Random();

    public static Periodicity randomPeriodicity() {
        Periodicity[] periodicities = values();
        return periodicities[random.nextInt(periodicities.length)];
    }

}
