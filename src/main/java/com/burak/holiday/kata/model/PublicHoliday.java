package com.burak.holiday.kata.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name="public_holiday")
public class PublicHoliday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "local_name")
    private String localName;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "country_code", referencedColumnName = "country_code")
    private CountryInfo countryCode;

    /*
    @OneToOne(mappedBy = "publicHoliday", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "country_code")
    private CountryInfo countryCode;
    */

    @Column(name = "fixed")
    private boolean fixed;

    @Column(name = "global")
    private boolean global;

    @Column(name = "counties")
    private String counties;

    @Column(name = "launch_year")
    private int launchYear;

    @Column(name = "type")
    private String type;
}
