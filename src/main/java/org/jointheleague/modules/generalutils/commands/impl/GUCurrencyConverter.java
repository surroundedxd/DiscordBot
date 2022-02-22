package org.jointheleague.modules.generalutils.commands.impl;

import org.javacord.api.event.message.MessageCreateEvent;
import org.jointheleague.modules.CurrencyConverter;
import org.jointheleague.modules.generalutils.commands.GUCommand;
import org.jointheleague.modules.generalutils.commands.util.FakeMessageEvent;

public class GUCurrencyConverter extends GUCommand {
    private final CurrencyConverter currencyConverter = new CurrencyConverter("");

    public GUCurrencyConverter() {
        super(new String[]{
                "currency"});
    }

    @Override
    public void invoke(MessageCreateEvent event, String[] input) {
        currencyConverter.handle(new FakeMessageEvent(event,"!currency " + input[1]));
    }
}
