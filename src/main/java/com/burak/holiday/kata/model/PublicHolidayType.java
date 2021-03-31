package com.burak.holiday.kata.model;

public enum PublicHolidayType {
    PUBLIC("Public"), BANK("Bank"), SCHOOL("School"), AUTHORITIES("Authorities"), OPTIONAL("Optional"), OBSERVANCE("Observance");

    private final String publicHolidayType;

    PublicHolidayType(String publicHolidayType) {
        this.publicHolidayType = publicHolidayType;
    }

    public String getPublicHolidayType() {
        return publicHolidayType;
    }
}
