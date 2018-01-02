package com.globallogic.store.jersey.model;

/**
 * Class which consist of fields and methods of all entities
 *
 * @author oleksii.slavik
 */
public abstract class Entity {

    /**
     * Format part
     */
    private static final String FORMAT = "%15s|";

    /**
     * Count of chars of one cell of separator
     */
    private static final int CELL_LENGTH = 16;

    /**
     * Separator char
     */
    private static final String SEPARATOR = "-";

    /**
     * Entity id
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Table row representation of given columns
     *
     * @param columns column data
     * @return string representation of table row
     */
    public String row(String... columns) {
        return String.format(createFormat(columns.length), columns);
    }

    /**
     * Separator for given column count
     *
     * @param columnCount count of columns
     * @return string representation of separator
     */
    public String separator(int columnCount) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < CELL_LENGTH * columnCount; i++) {
            builder.append(SEPARATOR);
        }

        return builder.toString();
    }

    /**
     * Format for console output
     *
     * @return format of output
     */
    private String createFormat(int columnCount) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < columnCount; i++) {
            builder.append(FORMAT);
        }

        return builder.toString();
    }

    /**
     * Header of table
     *
     * @return row of table
     */
    public abstract String header();

    /**
     * Separator between table rows
     *
     * @return string representation of separator
     */
    public abstract String separator();
}
