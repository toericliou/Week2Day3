package org.jenkinsci.plugins.AkkaListeners.ActorRefs;

import akka.actor.UntypedActor;
import lombok.extern.log4j.Log4j2;


/**
 * Created by eerilio on 5/14/15.
 */
@Log4j2
public class BuildListenerActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
        if(o.equals("Started")){
            log.info("Build Listener Triggered: Build Started");
            getSender().tell("Done", getSelf());
        }
        else if (o.equals("Finished")){
            log.info("Build Listener Triggered: Build Finished");
            getSender().tell("Done", getSelf());
        }
    }
}
