package org.jointheleague.modules.generalutils.commands.impl;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.jointheleague.modules.generalutils.commands.GUCommand;

public class GUHelp extends GUCommand {
    public GUHelp() {
        super(new String[]{"help"});
    }

    @Override
    public void invoke(MessageCreateEvent event, String[] input) {
        EmbedBuilder builder = new EmbedBuilder()
                .setTitle("General Utils Help")
                .setDescription("idk check the commands list or something");

        event.getChannel().sendMessage(builder);
    }
}
