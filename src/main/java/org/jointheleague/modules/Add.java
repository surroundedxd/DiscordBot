package org.jointheleague.modules;

import net.aksingh.owmjapis.api.APIException;
import org.javacord.api.event.message.MessageCreateEvent;

/**
 * A simple class that takes two integers and an operator (+, -, *, /) and computes that value
 *
 * @author surroundedxd
 * @since 1/10/2022
 */
@SuppressWarnings("ConstantConditions")
public class Add extends CustomMessageCreateListener {
    private static final char[] supportedOperators = {'+', '-', '*', '/'};

    private String previousMessage = "";

    public Add(String channelName) {
        super(channelName);

    }

    @Override
    public void handle(MessageCreateEvent event) throws APIException {
        if (previousMessage.equals(event.getMessageContent())) return; // Too lazy to look through the docs lol

        String contents = event.getMessageContent().replace(" ", "");

        if (contents.length() < 3) return;
        if (Character.isDigit(contents.charAt(0))) {
            /* Safety Checks */
            int operatorType = getOperator(contents);

            if (operatorType == -1) {
                event.getChannel().sendMessage("It seems like you sent an unknown operator. Try one of the following: `+` `-` `*` `/`");
                return;
            }

            int operatorIndex = findFirst(supportedOperators[operatorType], contents);

            if (operatorIndex == -1) {
                event.getChannel().sendMessage("An error occurred while parsing the string to find the operator.");
                return;
            }

            /* Parse Values */
            int firstVariable = 0;
            int secondVariable = 0;
            int output;

            //** Catch **//
            try {
                firstVariable = Integer.parseInt(contents.substring(0, operatorIndex));
            } catch (NumberFormatException exception) {
                event.getChannel().sendMessage("Type mismatch. " + contents.substring(0, operatorIndex) + " is not a valid integer.");
                return;
            }

            try {
                secondVariable = Integer.parseInt(contents.substring(operatorIndex + 1)); // There has to be a better way to do this...
            } catch (NumberFormatException exception) {
                event.getChannel().sendMessage("Type mismatch. " + contents.substring(operatorIndex + 1) + " is not a valid integer.");
                return;
            }

            switch (operatorType) {
                case 0:
                    output = firstVariable + secondVariable;
                    break;
                case 1:
                    output = firstVariable - secondVariable;
                    break;
                case 2:
                    output = firstVariable * secondVariable;
                    break;
                case 3:
                    output = Math.round((float) firstVariable / secondVariable);
                    break;
                default:
                    throw new UnsupportedOperationException("Attempted to calculate an unsupported equation past checks.");
            }
            previousMessage = contents + " = " + output;
            event.getChannel().sendMessage(previousMessage);
        }
    }

    /**
     * Returns the first index of the specified character. Returns -1 if not found.
     */
    private int findFirst(char character, String contents) {
        for (int i = 0; i < contents.length(); i++) {
            if (contents.charAt(i) == character) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the current operator based on the input string
     * <p>
     * -1 = unknown
     * 0 = addition
     * 1 = subtraction
     * 2 = multiplication
     * 3 = division
     */
    private int getOperator(String contents) {
        if (contents.contains("+")) {
            return 0;
        }
        if (contents.contains("-")) {
            return 1;
        }
        if (contents.contains("*")) {
            return 2;
        }
        if (contents.contains("/")) {
            return 3;
        }
        return -1;
    }
}