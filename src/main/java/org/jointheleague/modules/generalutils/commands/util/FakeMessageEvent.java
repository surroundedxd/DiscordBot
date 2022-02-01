package org.jointheleague.modules.generalutils.commands.util;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.emoji.Emoji;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.CertainMessageEvent;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.event.message.MessageEvent;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Used to create fake (sussy imposter) messages to pass to pre-existing
 * commands other students made without editing their code.
 */
public class FakeMessageEvent implements MessageCreateEvent, CertainMessageEvent, MessageEvent {
    private String message = "";
    private MessageCreateEvent actualMessage;

    public FakeMessageEvent(MessageCreateEvent actualMessage, String message) {
        this.actualMessage = actualMessage;
        this.message = message;
    }

    @Override
    public String getMessageContent() {
        return message;
    }

    @Override
    public Message getMessage() {
        return null;
    }

    @Override
    public long getMessageId() {
        return 0;
    }

    @Override
    public Optional<Server> getServer() {
        return Optional.empty();
    }

    @Override
    public CompletableFuture<Void> deleteMessage() {
        return null;
    }

    @Override
    public CompletableFuture<Void> deleteMessage(String s) {
        return null;
    }

    @Override
    public CompletableFuture<Void> editMessage(String s) {
        return null;
    }

    @Override
    public CompletableFuture<Void> editMessage(EmbedBuilder embedBuilder) {
        return null;
    }

    @Override
    public CompletableFuture<Void> editMessage(String s, EmbedBuilder embedBuilder) {
        return null;
    }

    @Override
    public CompletableFuture<Void> addReactionToMessage(String s) {
        return null;
    }

    @Override
    public CompletableFuture<Void> addReactionToMessage(Emoji emoji) {
        return null;
    }

    @Override
    public CompletableFuture<Void> addReactionsToMessage(Emoji... emojis) {
        return null;
    }

    @Override
    public CompletableFuture<Void> addReactionsToMessage(String... strings) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeAllReactionsFromMessage() {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeReactionByEmojiFromMessage(User user, Emoji emoji) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeReactionByEmojiFromMessage(User user, String s) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeReactionByEmojiFromMessage(Emoji emoji) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeReactionByEmojiFromMessage(String s) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeReactionsByEmojiFromMessage(User user, Emoji... emojis) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeReactionsByEmojiFromMessage(User user, String... strings) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeReactionsByEmojiFromMessage(Emoji... emojis) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeReactionsByEmojiFromMessage(String... strings) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeOwnReactionByEmojiFromMessage(Emoji emoji) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeOwnReactionByEmojiFromMessage(String s) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeOwnReactionsByEmojiFromMessage(Emoji... emojis) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeOwnReactionsByEmojiFromMessage(String... strings) {
        return null;
    }

    @Override
    public CompletableFuture<Void> pinMessage() {
        return null;
    }

    @Override
    public CompletableFuture<Void> unpinMessage() {
        return null;
    }

    @Override
    public TextChannel getChannel() {
        return actualMessage.getChannel();
    }

    @Override
    public DiscordApi getApi() {
        return null;
    }
}