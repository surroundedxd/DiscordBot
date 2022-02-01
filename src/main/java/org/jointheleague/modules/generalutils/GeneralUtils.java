package org.jointheleague.modules.generalutils;

import net.aksingh.owmjapis.api.APIException;
import org.javacord.api.event.message.MessageCreateEvent;
import org.jointheleague.modules.CustomMessageCreateListener;
import org.jointheleague.modules.generalutils.commands.GUCommand;
import org.jointheleague.modules.generalutils.commands.impl.GUBrainFacts;
import org.jointheleague.modules.generalutils.commands.impl.GUHello;
import org.jointheleague.modules.generalutils.commands.impl.GUPing;

public class GeneralUtils extends CustomMessageCreateListener {
    public static final char prefix = ';'; // Find all doesn't yield this prefix being used anywhere else

    private final GUCommand[] commands = new GUCommand[]{
            new GUHello(),
            new GUPing(),
            new GUBrainFacts()
    };

    public GeneralUtils(String channelName) {
        super(channelName);
    }

    @Override
    public void handle(MessageCreateEvent event) throws APIException {
        String message = event.getMessageContent();

        if (message.isEmpty()) return;
        if (message.length() < 3) return;

        if (message.charAt(0) == prefix) {
            String command = message.replace(" ", "");
            if (command.length() <= 1) return;
            command = command.substring(1);
            boolean found = false;

            for (GUCommand guCommand : commands) {
                if (found) return;
                for (String alias : guCommand.getAliases()) {
                    if (command.length() < alias.length()) continue;
                    if (alias.toLowerCase().contains(command)) {
                        guCommand.invoke(event, command);
                        found = true;
                    }
                }
            }
        }
    }
}