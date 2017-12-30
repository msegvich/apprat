package com.pragmatic.apprat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Database {
    private Long id;
    private String name;
    private String type;
    @ManyToMany(mappedBy = "databases")
    private Set<Application> applications;
    @OneToMany
    private Set<Server> servers;

    @Enumerated(EnumType.STRING)
    private CloudDisposition disposition;
}
