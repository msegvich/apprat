package com.pragmatic.apprat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class BusinessFunction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BusinessArea businessArea;

    @OneToMany(mappedBy = "businessFunction")
    private Set<Application> applications;

    @Enumerated(EnumType.STRING)
    private CloudDisposition cloudDisposition;

}
