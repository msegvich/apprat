package com.pragmatic.apprat.bootstrap;

import com.pacificlife.apprat.domain.*;
import com.pacificlife.apprat.repositories.*;
import com.pragmatic.apprat.domain.*;
import com.pragmatic.apprat.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@Slf4j
@org.springframework.stereotype.Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ApplicationRepository applicationRepository;
    private ComponentRepository componentRepository;
    private IntegrationRepository integrationRepository;
    private ServerRepository serverRepository;
    private BusinessFunctionRepository businessFunctionRepository;

    public DevBootstrap(ApplicationRepository applicationRepository,
                        ComponentRepository componentRepository,
                        IntegrationRepository integrationRepository,
                        ServerRepository serverRepository,
                        BusinessFunctionRepository businessFunctionRepository){
        this.applicationRepository = applicationRepository;
        this.componentRepository = componentRepository;
        this.integrationRepository = integrationRepository;
        this.serverRepository = serverRepository;
        this.businessFunctionRepository = businessFunctionRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData(){
        //add application
        Application app1 = new Application();
        app1.setName("Navigator");
        app1.setHostingType(Hosting.ON_PREM);
        app1.setArchitectureStyle(ArchitectureStyle.CLIENT_SERVER);
        app1.setRto("4");
        app1.setNotes("One of the entry points to illustrations and submissions");

        Application app2 = new Application();
        app2.setName("iPipeline");
        app2.setHostingType(Hosting.SAAS);
        app2.setArchitectureStyle(ArchitectureStyle.CLIENT_SERVER);
        app2.setNotes("3rd party application that provides illustrations and is used for the submission process");

        //add component
        Component component1 = new Component();
        component1.setName("Navigator Core");
        component1.setComponentType(ComponentType.SERVICE);
        component1.setHosting(Hosting.ON_PREM);
        component1.setPlatform(".NET");
        component1.setVersion("10.1");
        component1.setDescription("Core app for Navigator");
        app1.addComponent(component1);

        Component component2 = new Component();
        component2.setName("WFAPP01");
        component2.setComponentType(ComponentType.DB);
        component2.setHosting(Hosting.ON_PREM);
        component2.setDescription("DB for Navigator");
        app1.addComponent(component2);

        //add server
        Server server1 = new Server();
        server1.setName("LPNAV01LV");
        server1.setOperatingSystem(OperatingSystem.WINDOWS);
        component1.addServer(server1);

        Server server2 = new Server();
        server2.setName("LPSQLI18V");
        server2.setOperatingSystem(OperatingSystem.WINDOWS);
        component2.addServer(server2);

        //add integration
        Integration integration1 = new Integration();
        integration1.setIntegrationDirection(IntegrationDirection.OUT);
        integration1.setIntegrationStyle(IntegrationStyle.RPC);
        app1.getIntegrations().add(integration1);

        //add business function
        BusinessFunction bf1 = new BusinessFunction();
        bf1.setBusinessArea(BusinessArea.QUOTING);
        bf1.getApplications().add(app1);
        bf1.getApplications().add(app2);
    }
}
