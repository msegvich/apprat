package com.pragmatic.apprat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String version;
    private String platform;
    @Enumerated(EnumType.STRING)
    private Hosting hosting;
    @Enumerated(EnumType.STRING)
    private ComponentType componentType;
    @Enumerated(EnumType.STRING)
    private CloudDisposition cloudDisposition;

    @ManyToOne
    private Application application;

    @ManyToMany
    @JoinTable(name = "component_server",
            joinColumns = @JoinColumn(name = "component_id"),
            inverseJoinColumns = @JoinColumn(name = "server_id"))
    private Set<Server> servers;

    private Boolean faultTolerant;

    public void addServer(Server server) {
        server.getComponents().add(this);
        this.servers.add(server);
    }

}
