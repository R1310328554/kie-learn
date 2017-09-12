/**
 * caicongyang.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.caicongyang.drools.drools;

import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import xx.Message;

import java.io.File;


/**
 * @author caicongyang1
 * @version id: tableTest, v 0.1 16/11/28 下午8:16 caicongyang1 Exp $$
 */
public class DecisionTableTest {

    /**
     * 默认规则文件所在路径
     */
    private static final String RULES_PATH = "dtables";

    public static void main(String[] args) {
        hw();


    }

    private static void hw() {
        //把excel翻译成drl文件
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String xx = "Sample.xls";
        String drl = compiler.compile(ResourceFactory.newClassPathResource(RULES_PATH + File.separator + xx, "UTF-8"), "Tables");
        System.out.println(drl);
        Long start = System.currentTimeMillis();
        //执行决策表
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieModuleModel kieModuleModel = ks.newKieModuleModel();
            KieFileSystem kieFileSystem = ks.newKieFileSystem();
//            kieFileSystem


            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-dtables");

            Message message = new Message();
            message.setMessage("maa");
            message.setStatus(0);
            kSession.insert(message);
            kSession.fireAllRules();
            kSession.dispose();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("COST:"+String.valueOf(System.currentTimeMillis()-start));
    }

    private static void policy() {
        //把excel翻译成drl文件
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String perseonXls = "Example.xls";
        perseonXls = "Example.xls";
        String drl = compiler.compile(ResourceFactory.newClassPathResource(RULES_PATH + File.separator + perseonXls, "UTF-8"), "rule-table");
        System.out.println(drl);
        Long start = System.currentTimeMillis();
        //执行决策表
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("tablesKiession");
            Person person = new Person();
            person.setName("Tony");
            kSession.insert(person);
            kSession.fireAllRules();
            kSession.dispose();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("COST:"+String.valueOf(System.currentTimeMillis()-start));
    }


}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}