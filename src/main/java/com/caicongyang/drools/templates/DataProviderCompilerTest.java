package com.caicongyang.drools.templates;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.drools.core.base.dataproviders.MVELDataProvider;
import org.drools.core.spi.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message.Level;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.io.KieResources;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 *
 * Drools模板实例应用
 *
 * @author caicongyang1
 * @version id: Message, v 0.1 16/9/29 下午3:06 caicongyang1 Exp $$
 */
public class DataProviderCompilerTest {

    public static void main(String[] args) {
        ArrayList<String[]> rows = new ArrayList<String[]>();
        rows.add(new String[] { "3", "status == 0" });

        MyDataProvider tdp = new MyDataProvider(rows);
        DataProvider dataProvider = new MVELDataProvider();
//        dataProvider.

        DataProviderCompiler converter = new DataProviderCompiler();


        String template = "/rule_template_1.dl";
        InputStream templateStream = converter.getClass().getResourceAsStream(template);
        System.out.println("templateStream = " + templateStream);
        URL resource = converter.getClass().getResource("/");
        System.out.println("resource = " + resource);

        String drl = converter.compile(tdp, template);

        System.out.println(drl);

        KieServices kieServices = KieServices.Factory.get();
        KieResources resources = kieServices.getResources();
        KieModuleModel kieModuleModel = kieServices.newKieModuleModel();//1

        KieBaseModel baseModel = kieModuleModel.newKieBaseModel("FileSystemKBase").addPackage("rules");//2
        baseModel.newKieSessionModel("FileSystemKSession");//3
        KieFileSystem fileSystem = kieServices.newKieFileSystem();

        String xml = kieModuleModel.toXML();
        System.out.println(xml);//4
        fileSystem.writeKModuleXML(xml);//5

        String path = DataProviderCompilerTest.class.getClass().getResource("/").getPath();
        fileSystem.write("src/main/resources/rules/rule1.drl", drl);

        KieBuilder kb = kieServices.newKieBuilder(fileSystem);
        kb.buildAll();//7
        if (kb.getResults().hasMessages(Level.ERROR)) {
            throw new RuntimeException("Build Errors:\n" + kb.getResults().toString());
        }
        KieContainer kContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());

        KieSession kSession = kContainer.newKieSession("FileSystemKSession");

        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.GOODBYE);

        kSession.insert(message);
        kSession.fireAllRules();
        kSession.dispose();

    }

}  