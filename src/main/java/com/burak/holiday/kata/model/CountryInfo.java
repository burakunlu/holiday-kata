package com.burak.holiday.kata.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "country_info")
public class CountryInfo {

    @Id
    @Column(name="country_code")
    private String countryCode;

    @Column
    private String commonName;

    @Column
    private String officialName;

    @Column
    private String region;

    @OneToMany(mappedBy="countryCode", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<PublicHoliday> publicHolidays;

}
