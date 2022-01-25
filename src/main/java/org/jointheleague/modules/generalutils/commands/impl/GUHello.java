package org.jointheleague.modules.generalutils.commands.impl;

import org.javacord.api.event.message.MessageCreateEvent;
import org.jointheleague.modules.generalutils.commands.GUCommand;

import java.util.Random;

public class GUHello extends GUCommand {
    public static final String[] responses = new String[]{"Hi!", "Hello.", "ello", "yo wassup g"};

    public GUHello() {
        super(new String[]{"hello", "hi"});
    }

    @Override
    public void invoke(MessageCreateEvent event, String input) {
        int random = new Random().nextInt(4);

        event.getChannel().sendMessage(responses[random]);
    }
}