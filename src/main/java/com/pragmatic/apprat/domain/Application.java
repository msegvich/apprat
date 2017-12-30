package com.pragmatic.apprat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Hosting hostingType;
    @Enumerated(EnumType.STRING)
    private ArchitectureStyle architectureStyle;
    private Boolean clustered;
    private String rto;
    private String rpo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
    private Set<Component> components;

    @ManyToMany
    @JoinTable(name = "application_integration",
            joinColumns = @JoinColumn(name = "application_id"),
            inverseJoinColumns = @JoinColumn(name = "integration_id"))
    private Set<Integration> integrations;

    @OneToOne(cascade = CascadeType.ALL)
    private BusinessValue businessValue;
    @Enumerated(EnumType.STRING)
    private CloudDisposition cloudDisposition;

    @ManyToMany
    @JoinTable(name = "application_database",
            joinColumns = @JoinColumn(name = "application_id"),
            inverseJoinColumns = @JoinColumn(name = "database_id"))
    private Set<Database> databases;

    @ManyToOne
    private BusinessFunction businessFunction;

    private Boolean saasOffering;

    @Lob
    private String notes;

    public void addComponent(Component component) {
        component.setApplication(this);
        this.components.add(component);
    }
}
