package com.globallogic.store.jersey.common;

import com.globallogic.store.jersey.exception.IllegalCommandException;

/**
 * Enum of commands
 *
 * @author oleksii.slavik
 */
public enum Command {

    FIND_ALL("all"),
    FIND_BY_ID("id"),
    FIND_BY_KEY("find"),
    DELETE("delete");

    /**
     * String representation of command
     */
    String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    /**
     * Find command by his string representation
     *
     * @param key string representation of command
     * @return command object
     * @throws IllegalCommandException throws when command don`t find by given key
     */
    public static Command getByKey(String key) throws IllegalCommandException {
        for (Command command : Command.values()) {
            if (command.getCommand().equals(key)) {
                return command;
            }
        }

        throw new IllegalCommandException();
    }
}
