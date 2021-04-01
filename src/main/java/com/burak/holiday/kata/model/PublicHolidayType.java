package com.burak.holiday.kata.model;

import java.util.Locale;

public enum PublicHolidayType {
    PUBLIC, BANK, SCHOOL, AUTHORITIES, OPTIONAL, OBSERVANCE, UNKNOWN;

    /**
     * Retrieve enum type for given string input
     * By default assign UNKNOWN
     * @param type
     * @return
     */
    public static PublicHolidayType fromString(String type) {
        try {
            return PublicHolidayType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }

    /**
     * Override default toString() function to get string value in different format
     * Only first letter is upper case
     * @return String
     */
    @Override
    public String toString() {
        String name = name().toLowerCase(Locale.ROOT);
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }
}
