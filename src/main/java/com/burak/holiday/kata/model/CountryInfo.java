package com.burak.holiday.kata.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "country_info")
public class CountryInfo {

    @Id
    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "official_name")
    private String officialName;

    @Column(name = "region")
    private String region;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "public_holiday")
    private PublicHoliday publicHoliday;

}
