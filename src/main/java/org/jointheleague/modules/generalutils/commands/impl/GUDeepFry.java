package org.jointheleague.modules.generalutils.commands.impl;

import org.javacord.api.event.message.MessageCreateEvent;
import org.jointheleague.modules.DeepFrier;
import org.jointheleague.modules.generalutils.commands.GUCommand;
import org.jointheleague.modules.generalutils.commands.util.FakeMessageEvent;

public class GUDeepFry extends GUCommand {
    private DeepFrier deepFrier = new DeepFrier(null);

    public GUDeepFry() {
        super(new String[]{"deepfry", "fry"});
    }

    @Override
    public void invoke(MessageCreateEvent event, String[] input) {
        try {
            deepFrier.handle(new FakeMessageEvent(event, "!deepfry " + input[1]));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
