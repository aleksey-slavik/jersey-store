package com.globallogic.store.jersey.common;

import com.globallogic.store.jersey.exception.IllegalCommandException;

public enum Command {

    FIND_ALL("all"),
    FIND_BY_ID("id"),
    FIND_BY_KEY("key"),
    DELETE("delete");

    String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static Command getByKey(String key) throws IllegalCommandException {
        for (Command command : Command.values()) {
            if (command.getCommand().equals(key)) {
                return command;
            }
        }

        throw new IllegalCommandException();
    }
}
