package org.jointheleague.modules.generalutils.commands.impl;

import org.javacord.api.event.message.MessageCreateEvent;
import org.jointheleague.modules.generalutils.commands.GUCommand;

public class GUPing extends GUCommand {
    public GUPing() {
        super(new String[]{"ping"});
    }

    @Override
    public void invoke(MessageCreateEvent event, String[] input) {
        event.getChannel().sendMessage("Pong!");
    }
}