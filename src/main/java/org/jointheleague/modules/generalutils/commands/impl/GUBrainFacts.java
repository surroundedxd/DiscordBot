package org.jointheleague.modules.generalutils.commands.impl;

import org.javacord.api.event.message.MessageCreateEvent;
import org.jointheleague.modules.BrainFacts;
import org.jointheleague.modules.generalutils.commands.GUCommand;
import org.jointheleague.modules.generalutils.commands.util.FakeMessageEvent;

public class GUBrainFacts extends GUCommand {
    private BrainFacts brainFacts = new BrainFacts(null);

    public GUBrainFacts() {
        super(new String[]{
                "brain",
                "brainfact"});
    }

    @Override
    public void invoke(MessageCreateEvent event, String input) {
        brainFacts.handle(new FakeMessageEvent(event,"!brain"));
    }
}