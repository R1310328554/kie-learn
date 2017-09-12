package com.myteam.baoxiao1;

import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomWorkingMemoryEventListener
        implements WorkingMemoryEventListener {
    private static final Logger logger = LoggerFactory
            .getLogger(CustomWorkingMemoryEventListener.class);

    public void objectInserted(org.drools.event.rule.ObjectInsertedEvent objectInsertedEvent) {
        System.out.println("CustomWorkingMemoryEventListener.objectInserted");
    }

    public void objectUpdated(org.drools.event.rule.ObjectUpdatedEvent objectUpdatedEvent) {
        System.out.println("CustomWorkingMemoryEventListener.objectUpdated");
    }

    public void objectRetracted(ObjectRetractedEvent objectRetractedEvent) {
        System.out.println("CustomWorkingMemoryEventListener.objectRetracted");
    }

//    public void objectInserted(ObjectInsertedEvent event) {
//        logger.info("Object Inserted: " +
//                event.getFactHandle() +
//                " Knowledge Runtime: " +
//                event.getKnowledgeRuntime());
//    }
//
//    public void objectRetracted(ObjectRetractedEvent event) {
//        logger.info("Object Retracted: " +
//                event.getFactHandle() +
//                " Knowledge Runtime: " +
//                event.getKnowledgeRuntime());
//    }
//
//    public void objectUpdated(ObjectUpdatedEvent event) {
//        logger.info("Object Updated: " +
//                event.getFactHandle() +
//                " Knowledge Runtime: " +
//                event.getKnowledgeRuntime());
//    }
}