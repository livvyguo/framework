package com.lvy.appexec.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by livvy on 14/12/30.
 */
public class Main {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer container = kieServices.getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("ksession-rules");

    }
}
