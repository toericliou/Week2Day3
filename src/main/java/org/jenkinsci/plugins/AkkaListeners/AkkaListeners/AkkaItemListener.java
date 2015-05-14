package org.jenkinsci.plugins.AkkaListeners.AkkaListeners;

import akka.actor.*;
import hudson.Extension;
import hudson.model.*;
import hudson.model.listeners.ItemListener;
import org.jenkinsci.plugins.AkkaListeners.AkkaPlugin;


/**
 * Created by eerilio on 5/14/15.
 */
@Extension
public class AkkaItemListener extends ItemListener {

    private ActorRef itemListener = AkkaPlugin.getItemListenerActorRef();

    @Override
    public void onCreated(Item item) {
        super.onCreated(item);
        itemListener.tell("Item Created", itemListener);
    }

    @Override
    public void onDeleted(Item item) {
        super.onDeleted(item);
        itemListener.tell("Item Deleted", itemListener);

    }

    @Override
    public void onRenamed(Item item, String oldName, String newName) {
        super.onRenamed(item, oldName, newName);
        itemListener.tell("Item Renamed", itemListener);
    }
}
