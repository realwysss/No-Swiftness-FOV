/*
 * Decompiled with CFR 0.152.
 */
package dev.noswiftnessfov;

public final class SpeedFovMath {
    private static final double SPEED_BONUS_PER_LEVEL = 0.2;

    private SpeedFovMath() {
    }

    public static double removeSwiftnessModifier(double movementSpeed, int amplifier) {
        int effectLevel = amplifier + 1;
        return movementSpeed / (1.0 + 0.2 * (double)effectLevel);
    }
}

