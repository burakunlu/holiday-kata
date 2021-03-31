package com.burak.holiday.kata.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name="country_info")
public class CountryInfo {

    @Id
    @GeneratedValue(generator="country-code")
    @GenericGenerator(name="country-code", strategy = "uuid")
    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "official_name")
    private String officialName;

    @Column(name = "region")
    private String region;

    @OneToOne(mappedBy = "countryCode")
    private PublicHoliday publicHoliday;

}
