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
@Table(name = "public_holiday")
public class PublicHoliday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private String localName;

    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_code", referencedColumnName = "country_code")
    private CountryInfo countryCode;

    @Column(nullable = false)
    private boolean fixed;

    @Column(nullable = false)
    private boolean global;

    @Column(nullable = false)
    private String counties;

    @Column
    private int launchYear;

    @Column(nullable = false)
    private String type;
}
