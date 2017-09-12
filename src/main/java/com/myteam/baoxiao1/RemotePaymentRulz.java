package com.myteam.baoxiao1;

import org.drools.core.io.impl.UrlResource;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import java.io.InputStream;
 
public class RemotePaymentRulz {
 
    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8080/kie-drools/maven2/com/myteam/baoxiao1/1.0.0/baoxiao1-1.0.0.jar";
    //    ReleaseIdImpl releaseId = new ReleaseIdImpl("org.sky。drools", "ApprovalDecision", "LATEST");
        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        UrlResource urlResource = (UrlResource) ks.getResources().newUrlResource(url);
        urlResource.setUsername("tomcat");
        urlResource.setPassword("tomcat");
        urlResource.setBasicAuthentication("enabled");
        InputStream is = urlResource.getInputStream();
        KieModule kModule = kr.addKieModule(ks.getResources().newInputStreamResource(is));
        KieContainer kContainer = ks.newKieContainer(kModule.getReleaseId());
        StatelessKieSession kSession = kContainer.newStatelessKieSession("defaultStatelessKieSession");

//        KieSession kieSession = kContainer.newKieSession();
        kSession.addEventListener(new CustomAgendaEventListener());
//        kieSession.

        int cnt = 0;
        while (cnt < 1000) {
            PaymentInfo m = new PaymentInfo();
            m.setMoneyAmount(10000);
            kSession.execute(m);
            System.out.println(m.getDecisionPath());
            if (m.getDecisionPath().equalsIgnoreCase("m")) {
                System.out.println( cnt + "数额<=10000需要经理审批");
            } else {
                System.out.println( cnt + "数额>10000需要总经理审批");
            }
            Thread.sleep(5000);
            cnt ++;
        }
    }

}