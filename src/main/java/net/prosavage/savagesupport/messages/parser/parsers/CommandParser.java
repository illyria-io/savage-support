package net.prosavage.savagesupport.messages.parser.parsers;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.User;
import net.prosavage.savagesupport.action.Action;
import net.prosavage.savagesupport.messages.parser.MessageParser;
import net.prosavage.savagesupport.storage.Commands;
import net.prosavage.savagesupport.storage.Questions;

public class CommandParser extends MessageParser {

    public MessageEmbed parseCommand(String message, User user) {
        if (!message.startsWith("!")) return null;
        message = message.replaceFirst("!", "");
        if (Questions.questionAnswerMap.containsKey(message)) {
            return Questions.questionAnswerMap.get(message).build();
        }
        if (!Commands.commands.containsKey(message)) return null;
        Action action = Commands.commands.get(message);
        return action.processCommand(user);
    }

}
