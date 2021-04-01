package com.burak.holiday.kata.repository;

import com.burak.holiday.kata.model.CountryInfo;
import com.burak.holiday.kata.model.PublicHoliday;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicHolidayRepository extends CrudRepository<PublicHoliday, Long> {
    @Query("select p from PublicHoliday p where year(p.date) = ?1 and countryCode = ?2")
    List<PublicHoliday> findByYearAndCountryCode(int year, CountryInfo countryCode);
}
