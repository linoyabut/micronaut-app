package org.micronaut;

public final class Utils {

    private Utils() {
    }

    public static double calculateScorePercentage(int totalScoreUser, int totalAttemptUser) {
        return (totalScoreUser * 100) / (totalAttemptUser * 10);
    }
}
