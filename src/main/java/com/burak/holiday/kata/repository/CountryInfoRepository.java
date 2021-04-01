package com.burak.holiday.kata.repository;

import com.burak.holiday.kata.model.CountryInfo;
import org.springframework.data.repository.CrudRepository;

public interface CountryInfoRepository extends CrudRepository<CountryInfo, String> {
}
