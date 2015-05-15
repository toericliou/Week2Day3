package org.jenkinsci.plugins.AkkaListeners;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import hudson.Extension;
import hudson.Plugin;
import lombok.Getter;
import org.jenkinsci.plugins.AkkaListeners.ActorRefs.*;


/**
 * Created by eerilio on 5/14/15.
 */

public class AkkaPlugin extends Plugin {

    private ActorSystem system = ActorSystem.create();

    private static AkkaPlugin INSTANCE;

    @Getter
    private static ActorRef itemListenerActorRef;

    @Getter
    private static ActorRef runListenerActorRef;

    @Getter
    private static ActorRef savableListenerActorRef;

    @Getter
    private static ActorRef buildListenerActorRef;

    @Override
    public void start(){
        itemListenerActorRef = system.actorOf(Props.create(ItemListenerActor.class));
        runListenerActorRef = system.actorOf(Props.create(RunListenerActor.class));
        savableListenerActorRef = system.actorOf(Props.create(SavableListenerActor.class));
        buildListenerActorRef = system.actorOf(Props.create(BuildListenerActor.class));
    }

    public AkkaPlugin getInstance(){
        if(INSTANCE ==null)
            return INSTANCE=new AkkaPlugin();
        return null;
    }


}
