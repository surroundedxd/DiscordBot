package org.jointheleague.modules.generalutils.commands;

import org.javacord.api.event.message.MessageCreateEvent;

public abstract class GUCommand {
    private final String[] aliases;

    public GUCommand(String[] aliases) {
        this.aliases = aliases;
    }

    /**
     * Called the user invokes this command
     *
     * @param input The input message without the prefix
     */
    public abstract void invoke(MessageCreateEvent event, String[] input);

    // no lobmok :(
    public String[] getAliases() {
        return this.aliases;
    }
}