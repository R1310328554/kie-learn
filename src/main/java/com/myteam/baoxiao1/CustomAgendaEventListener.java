package com.myteam.baoxiao1;

import org.drools.core.event.*;
import org.drools.core.event.AgendaGroupPoppedEvent;
import org.drools.core.event.AgendaGroupPushedEvent;
import org.kie.api.event.rule.*;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomAgendaEventListener
        implements AgendaEventListener {
    private static final Logger logger =
            LoggerFactory.getLogger(CustomAgendaEventListener.class);

    public void activationCancelled(ActivationCancelledEvent event) {
        logger.info("Activation Cancelled: " +
                event.getActivation());
    }

    public void activationCreated(ActivationCreatedEvent
                                          event) {
        logger.info("Activation Created: " +
                event.getActivation());
    }

    public void beforeActivationFired(
            BeforeActivationFiredEvent event) {
        logger.info("Before Activation Fired: " +
                event.getActivation());
    }

    public void afterActivationFired(AfterActivationFiredEvent
                                             event) {
        logger.info("After Activation Fired: " +
                event.getActivation());
    }

    public void agendaGroupPopped(AgendaGroupPoppedEvent
                                          event) {
        logger.info("Agenda Group Popped: " +
                event.getAgendaGroup());
    }

    public void agendaGroupPushed(AgendaGroupPushedEvent
                                          event) {
        logger.info("Agenda Group Pushed: " +
                event.getAgendaGroup());
    }


    /**
     *
     * @param matchCreatedEvent
     */
    public void matchCreated(MatchCreatedEvent matchCreatedEvent) {

        System.out.println("CustomAgendaEventListener.matchCreated");
    }

    public void matchCancelled(MatchCancelledEvent matchCancelledEvent) {
        System.out.println("CustomAgendaEventListener.matchCancelled");
    }

    public void beforeMatchFired(BeforeMatchFiredEvent beforeMatchFiredEvent) {
        System.out.println("CustomAgendaEventListener.beforeMatchFired");
    }

    public void afterMatchFired(AfterMatchFiredEvent afterMatchFiredEvent) {
        System.out.println("CustomAgendaEventListener.afterMatchFired");

    }

    public void agendaGroupPopped(org.kie.api.event.rule.AgendaGroupPoppedEvent agendaGroupPoppedEvent) {
        System.out.println("CustomAgendaEventListener.agendaGroupPopped");
    }

    public void agendaGroupPushed(org.kie.api.event.rule.AgendaGroupPushedEvent agendaGroupPushedEvent) {
        System.out.println("CustomAgendaEventListener.agendaGroupPushed");
    }

    public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent ruleFlowGroupActivatedEvent) {
        System.out.println("CustomAgendaEventListener.beforeRuleFlowGroupActivated");
    }

    public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent ruleFlowGroupActivatedEvent) {
        System.out.println("CustomAgendaEventListener.afterRuleFlowGroupActivated");
    }

    public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent ruleFlowGroupDeactivatedEvent) {
        System.out.println("CustomAgendaEventListener.beforeRuleFlowGroupDeactivated");
    }

    public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent ruleFlowGroupDeactivatedEvent) {
        System.out.println("CustomAgendaEventListener.afterRuleFlowGroupDeactivated");
    }
}