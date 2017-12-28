package com.globallogic.store.jersey.common;

public enum Command {

    FIND_ALL("all"),
    FIND_BY_ID("id"),
    FIND_BY_KEY("key"),
    CREATE("create"),
    UPDATE("update"),
    DELETE("delete");

    String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static Command getByKey(String key) {
        for (Command command : Command.values()) {
            if (command.getCommand().equals(key)) {
                return command;
            }
        }

        throw new IllegalStateException();
    }
}
