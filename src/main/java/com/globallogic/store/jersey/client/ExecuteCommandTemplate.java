package com.globallogic.store.jersey.client;

import com.globallogic.store.jersey.common.Command;
import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.globallogic.store.jersey.exception.IllegalCommandException;
import com.globallogic.store.jersey.executor.ExecutorInterface;
import com.globallogic.store.jersey.model.Entity;

import java.util.List;

/**
 * Execute request of command
 *
 * @param <T> command type
 * @author oleksii.slavik
 */
public class ExecuteCommandTemplate<T extends Entity> {

    /**
     * Execute request of given command
     *
     * @param command  given command
     * @param key      given key
     * @param executor executor of given type
     * @throws EmptyResponseException  throws when response is empty
     * @throws IllegalCommandException throws when call unknown command
     */
    public void execute(Command command, String key, ExecutorInterface<T> executor) throws EmptyResponseException, IllegalCommandException {
        switch (command) {
            case FIND_ALL:
                printItemList(executor.findAll());
                break;
            case FIND_BY_ID:
                Long id = Long.parseLong(key);
                printSimpleItem(executor.findById(id));
                break;
            case FIND_BY_KEY:
                printItemList(executor.findByKey(key));
                break;
            case DELETE:
                id = Long.parseLong(key);
                printSimpleItem(executor.delete(id));
            default:
                throw new IllegalCommandException();
        }
    }

    /**
     * Print list of items to console
     *
     * @param list list of items
     */
    private void printItemList(List<T> list) {
        boolean isHeaderPrinted = false;

        for (T item : list) {
            if (!isHeaderPrinted) {
                printHeader(item);
                isHeaderPrinted = true;
            }

            printItem(item);
        }
    }

    /**
     * Print one item to console.
     * Used if response contains exactly one item
     *
     * @param item given item
     */
    private void printSimpleItem(T item) {
        printHeader(item);
        printItem(item);
    }

    /**
     * Print table header for given item
     *
     * @param item given item
     */
    private void printHeader(T item) {
        System.out.println(item.header());
        System.out.println(item.separator());
    }

    /**
     * Print one row of response table
     *
     * @param item given item
     */
    private void printItem(T item) {
        System.out.println(item);
        System.out.println(item.separator());
    }
}
