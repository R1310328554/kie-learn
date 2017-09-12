/**
 * caicongyang.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import com.sample.DroolsTest.Message;
import org.kie.api.runtime.StatelessKieSession;

public class DrlTest {

    /**
     * 默认规则文件所在路径
     */
    private static final String RULES_PATH = "rules";

    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();

        KieContainer kieContainer = kieServices.newKieClasspathContainer();

        String sessionPackages = "ksession-rules";
        sessionPackages =  null;
        KieSession kieSession = kieContainer.newKieSession( );


        StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession();
//        statelessKieSession.execute("");

//        kieSession.
        Message message = new Message();
        message.setStatus(0);


        kieSession.insert(message);


        int i = kieSession.fireAllRules();

        kieSession.dispose();


    }

}
