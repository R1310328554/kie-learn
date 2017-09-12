import org.drools.core.io.impl.ClassPathResource;
import org.drools.core.runtime.rule.impl.FlatQueryResultRow;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import test.Customer;
import test.PointDomain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
//import org.drools.KnowledgeBase;
//import org.drools.KnowledgeBaseFactory;
//import org.drools.builder.KnowledgeBuilder;
//import org.drools.builder.KnowledgeBuilderFactory;
//import org.drools.builder.ResourceType;
//import org.drools.io.impl.ClassPathResource;
//import org.drools.runtime.StatefulKnowledgeSession;

public class Test {
    public static void main(String[] args) {
        test3();
    }

    private static void test3() {
        KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
        System.setProperty( "drools.dateformat","yyyy-MM-dd hh:mm:ss");
        kb.add(new ClassPathResource("addpoint.drl"), ResourceType.DRL);
//        kb.add(new ClassPathResource("subpoint.drl"), ResourceType.DRL);

        if(kb.hasErrors()){
            System.out.println("规则中存在错误，错误消息如下：");
            KnowledgeBuilderErrors kbuidlerErrors = kb.getErrors();
            for(Iterator
                iter=kbuidlerErrors.iterator();iter.hasNext();){
                System.out.println(iter.next());
            }
        }
        KieBaseConfiguration kbConf =
                KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
        kbConf.setProperty( "org.drools.sequential", "true");



        Collection<KnowledgePackage> knowledgePackages = kb.getKnowledgePackages();

//        KieBase
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(knowledgePackages);

        StatefulKnowledgeSession statefulKnowledgeSession = kbase.newStatefulKnowledgeSession();

        PointDomain domain = new PointDomain();
//        domain.setBackMondy(0);
        domain.setBillThisMonth(200);
        domain.setBuyMoney(500);
        domain.setBirthDay(true);
//        domain.setBackNums(20);
        domain.setUserName("Jack");

//        statefulKnowledgeSession.insert(domain);
//
//
//        statefulKnowledgeSession.fireAllRules();
//        statefulKnowledgeSession.dispose();

        StatelessKieSession statelessKieSession = kbase.newStatelessKieSession();

        List lsits = new ArrayList();
        lsits.add(domain);

        statelessKieSession.execute(lsits);

//        statelessKieSession.setGlobal();

        statefulKnowledgeSession.setGlobal("asd", "ddd");
        System.out.println("domain = " + domain);


        QueryResults queryResults = statefulKnowledgeSession.getQueryResults("qq aa");

        for (QueryResultsRow qr: queryResults) {
            Object aa = qr.get("aa");
            System.out.println("aa = " + aa);


        }


    }

    private static void test2() {
        KnowledgeBuilder
                kb=KnowledgeBuilderFactory.newKnowledgeBuilder();
        kb.add(new ClassPathResource("test.drl"),
                ResourceType.DRL);
        Collection collection=kb.getKnowledgePackages();
        KnowledgeBase
                knowledgeBase=KnowledgeBaseFactory.newKnowledgeBase();
//        Object(fieldName matches “正则表达式”)
        knowledgeBase.addKnowledgePackages(collection);
        StatefulKnowledgeSession
                statefulSession=knowledgeBase.newStatefulKnowledgeSession();
        Customer cus1=new Customer();
        cus1.setName("张三");
        Customer cus2=new Customer();
        cus2.setName("李四");
        Customer cus3=new Customer();
        cus3.setName("王二");
        Customer cus4=new Customer();
        cus4.setName("李小龙");
        statefulSession.insert(cus1);
        statefulSession.insert(cus2);
        statefulSession.insert(cus3);
        statefulSession.insert(cus4);
        statefulSession.fireAllRules();
        statefulSession.dispose();
        System.out.println("end.....");

    }

    private static void test1() {
        KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
//        kb.add(new ClassPathResource("src/main/resources/test.drl"),
        kb.add(new ClassPathResource("test.drl"),
                ResourceType.DRL);
        Collection collection = kb.getKnowledgePackages();
        KnowledgeBase
                knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(collection);
        StatefulKnowledgeSession statefulSession = knowledgeBase.newStatefulKnowledgeSession();
        statefulSession.fireAllRules();
        statefulSession.dispose();
        System.out.println("end.....");
    }
}