package com.yixihan.sunday.one;

/**
 * Levels of salary.
 */
enum SalaryLevel {
    ENTRY (1), JUNIOR (1.25), SENIOR (1.5), EXECUTIVE (2);

    // Add missing code here.
    private final double scale;

    SalaryLevel(double scale) {
        this.scale = scale;
    }

    public double getScale () {
        return scale;
    }

}