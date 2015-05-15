package org.jenkinsci.plugins.AkkaListeners.AkkaListeners;

import akka.actor.*;
import hudson.Extension;
import hudson.model.*;
import hudson.model.listeners.ItemListener;
import lombok.Getter;
import lombok.Setter;
import org.jenkinsci.plugins.AkkaListeners.AkkaPlugin;


/**
 * Created by eerilio on 5/14/15.
 */
@Extension
public class AkkaItemListener extends ItemListener {

    @Getter
    @Setter
    private ActorRef itemActorRef = AkkaPlugin.getItemListenerActorRef();

    @Override
    public void onCreated(Item item) {
        super.onCreated(item);
        itemActorRef.tell("Item Created", itemActorRef);
    }

    @Override
    public void onDeleted(Item item) {
        super.onDeleted(item);
        itemActorRef.tell("Item Deleted", itemActorRef);

    }

    @Override
    public void onRenamed(Item item, String oldName, String newName) {
        super.onRenamed(item, oldName, newName);
        itemActorRef.tell("Item Renamed", itemActorRef);
    }
}
