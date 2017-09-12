//import org.drools.core.io.impl.ClassPathResource;
//import org.kie.api.KieBaseConfiguration;
//import org.kie.api.KieServices;
//import org.kie.api.io.ResourceType;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//import org.kie.api.runtime.StatelessKieSession;
//import org.kie.api.runtime.rule.QueryResults;
//import org.kie.api.runtime.rule.QueryResultsRow;
//import org.kie.internal.KnowledgeBase;
//import org.kie.internal.KnowledgeBaseFactory;
//import org.kie.internal.builder.KnowledgeBuilder;
//import org.kie.internal.builder.KnowledgeBuilderErrors;
//import org.kie.internal.builder.KnowledgeBuilderFactory;
//import org.kie.internal.definition.KnowledgePackage;
//import org.kie.internal.runtime.StatefulKnowledgeSession;
//import test.Applicant;
//import test.Application;
//import test.Customer;
//import test.PointDomain;
//import xx.Message;
//
//import java.util.*;
//import org.drools.KnowledgeBase;
//import org.drools.KnowledgeBaseFactory;
//import org.drools.builder.KnowledgeBuilder;
//import org.drools.builder.KnowledgeBuilderFactory;
//import org.drools.builder.ResourceType;
//import org.drools.io.impl.ClassPathResource;
//import org.drools.runtime.StatefulKnowledgeSession;
//
//public class KieTest {
//    public static void main(String[] args) {
//        test3();
//    }
//    private static void test3() {
//
//        KieServices kieServices = KieServices.Factory.get();
//        KieContainer kContainer = kieServices.getKieClasspathContainer();
//        KieSession kSession =  kContainer.newKieSession("ksession-rules");
//
////        StatelessKieSession kSession = kContainer.newStatelessKieSession();
//
//
//        Applicant applicant = new Applicant( "Mr John Smith", 16 );
//        Application application = new Application();
////        assertTrue( application.isValid() );
////        ksession.execute( Arrays.asList( new Object[] { application, applicant } ) );
////        assertFalse( application.isValid() );
//
//        kSession.insert(applicant);
//        kSession.insert(application);
//
//        Message message = new Message();
//        message.setMessage("ni hao ma ");
//        message.setStatus(0);
//
//        kSession.insert(message);
//        kSession.fireAllRules();
////        kSession.dispose();
//    }
//}