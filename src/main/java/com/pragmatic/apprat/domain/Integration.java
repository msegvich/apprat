package com.pragmatic.apprat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Integration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "integrations")
    private Set<Application> applications;

    @Enumerated(EnumType.STRING)
    private IntegrationStyle integrationStyle;

    @Enumerated(EnumType.STRING)
    private IntegrationDirection integrationDirection;

    private Boolean encrypted;
}
