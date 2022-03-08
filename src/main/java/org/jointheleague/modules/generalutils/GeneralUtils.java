package org.jointheleague.modules.generalutils;

import net.aksingh.owmjapis.api.APIException;
import org.javacord.api.event.message.MessageCreateEvent;
import org.jointheleague.modules.CustomMessageCreateListener;
import org.jointheleague.modules.generalutils.commands.GUCommand;
import org.jointheleague.modules.generalutils.commands.impl.*;
import org.jointheleague.modules.generalutils.commands.util.JaroWinkler;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
public class GeneralUtils extends CustomMessageCreateListener {
    private static final char prefix = ';'; // Command prefix
    private static final double threshold = 0.7; // JaroWrinkler threshold

    private final GUCommand[] commands = new GUCommand[]{
            new GUHelp(),
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

            if (commands.length < 1) return;

            int best = 0;
            double bestValue = 0.0;

            for (int i = 0; i < this.commands.length; i++) {
                for (String alias : this.commands[i].getAliases()) {
                    double distance = JaroWinkler.jaro_distance(commands[0], alias);
                    if (distance > threshold && distance > bestValue) {
                        best = i;
                        bestValue = distance;
                    }
                }
            }

            this.commands[best].invoke(event, commands);
        }
    }
}