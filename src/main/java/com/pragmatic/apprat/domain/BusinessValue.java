package com.pragmatic.apprat.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BusinessValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private BusinessValueMetrics strategic;
    @Enumerated
    private BusinessValueMetrics critical;
    @Enumerated
    private BusinessValueMetrics activelyDeveloped;

    @OneToOne
    private Application application;

    // add a function to calculate business value based on metrics - might belong in a service
}
