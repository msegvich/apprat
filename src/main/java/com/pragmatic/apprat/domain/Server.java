package com.pragmatic.apprat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private OperatingSystem operatingSystem;
    private String version;
    private String ram;
    private String cpu;
    private String disk_space;

    @ManyToMany(mappedBy = "servers")
    private Set<Component> components;
}
