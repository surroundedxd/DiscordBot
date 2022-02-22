package org.jointheleague.modules.generalutils;

import net.aksingh.owmjapis.api.APIException;
import org.javacord.api.event.message.MessageCreateEvent;
import org.jointheleague.modules.CustomMessageCreateListener;
import org.jointheleague.modules.generalutils.commands.GUCommand;
import org.jointheleague.modules.generalutils.commands.impl.*;
import org.jointheleague.modules.generalutils.commands.util.JaroWinkler;

public class GeneralUtils extends CustomMessageCreateListener {
    public static final char prefix = ';';

    private final GUCommand[] commands = new GUCommand[]{
            new GUHello(),
            new GUPing(),
            new GUBrainFacts(),
            new GUDeepFry()
            // new GUCurrencyConverter()
    };

    public GeneralUtils(String channelName) {
        super(channelName);
    }

    @Override
    public void handle(MessageCreateEvent event) throws APIException {
        String message = event.getMessageContent();

        if (message.isEmpty() || event.getMessageAuthor().isYourself() || message.length() < 3) return;

        if (message.charAt(0) == prefix) {
            String[] commands = message.substring(1).split(" ");

            if (commands.length < 1) return ;

            for (GUCommand command : this.commands) {
                for (String alias : command.getAliases()) {
                    if (JaroWinkler.jaro_distance(commands[0], alias) > 0.7) {
                        command.invoke(event, commands);
                        return;
                    }
                }
            }
        }
    }
}