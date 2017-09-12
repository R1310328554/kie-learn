//package com.sample;
///**
// 2  * Tools for Drools
// 3  * @author kevin
// 4  * @version Date: 2009-7-7 Time: 10:34:58
// 5  */
// public class DroolsUtil {
//     private KnowledgeAgent kagent;
//     private static DroolsUtil instance;
//
//     /**
//      *  return the default agent with name "agent" and interval "5"
//      */
//     private DroolsUtil(){
//         this.kagent = getKnowledgeAgent("agent","5");
//     }
//
//     /**
//      * return the agent with the specified name and interval
//      * @param agentName The name of the agent
//      * @param interval The interval to scan resources
//      */
//     private DroolsUtil(String agentName,String interval){
//         this.kagent = getKnowledgeAgent(agentName,interval);
//     }
//
//     /**
//      * return the instance with default agent
//      * @return DroolsUtil's instance
//      */
//     public static DroolsUtil getInstance(){
//         if(instance == null){
//             instance = new DroolsUtil();
//         }
//         return instance;
//     }
//
//     /**
//      * return the instance with agent which is given specified name and  interval
//      * @param agentName The name of the agent
//      * @param interval The interval to scan resources
//      * @return DroolsUtil's instance
//      */
//     public static DroolsUtil getInstance(String agentName,String interval){
//         if(instance == null){
//            instance = new DroolsUtil(agentName,interval);
//         }
//         return instance;
//     }
//
//     /**
//      * Get the KnowledgeAgent and make it scan the resources per 5 seconds
//      * @param agentName The name of the agent
//      * @param interval The interval to scan resources
//      * @return KnowledgeAgent
//      */
//     public KnowledgeAgent getKnowledgeAgent(String agentName,String interval){
//         ResourceChangeScannerConfiguration sconf = ResourceFactory.getResourceChangeScannerService().newResourceChangeScannerConfiguration();
//         sconf.setProperty("drools.resource.scanner.interval",interval);
//         ResourceFactory.getResourceChangeScannerService().configure(sconf);
//         ResourceFactory.getResourceChangeScannerService().start();
//         ResourceFactory.getResourceChangeNotifierService().start();
//         KnowledgeAgentConfiguration aconf = KnowledgeAgentFactory.newKnowledgeAgentConfiguration();
//         aconf.setProperty("drools.agent.scanDirectories","true");
//         aconf.setProperty("drools.agent.newInstance","true");
//         KnowledgeAgent kagent = KnowledgeAgentFactory.newKnowledgeAgent(agentName,aconf);
//         kagent.applyChangeSet(ResourceFactory.newClassPathResource("resource.xml"));
//         return kagent;
//     }
//
//     /**
//      * Get the KnowledgeBase
//      * @return KnowledgeBase
//      */
//     public KnowledgeBase getKnowledgeBase(){
//         return kagent.getKnowledgeBase();
//     }
//
//     /**
//      * Get the StatefulKnowledgeSession
//      * @return StatefulKnowledgeSession
//      */
//     public StatefulKnowledgeSession getStatefulKnowledgeSession(){
//         return getKnowledgeBase().newStatefulKnowledgeSession();
//     }
//
//     /**
//      * Get the StatelessKnowledgeSession
//      * @return StatelessKnowledgeSession
//      */
//     public StatelessKnowledgeSession getStatelessKnowledgeSession(){
//         return getKnowledgeBase().newStatelessKnowledgeSession();
//     }
//
// }