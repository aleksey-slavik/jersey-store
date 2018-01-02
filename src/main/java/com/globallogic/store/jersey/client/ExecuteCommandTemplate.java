package com.globallogic.store.jersey.client;

import com.globallogic.store.jersey.common.Command;
import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.globallogic.store.jersey.exception.IllegalCommandException;
import com.globallogic.store.jersey.executor.ExecutorInterface;
import com.globallogic.store.jersey.model.Entity;

import java.util.List;

public class ExecuteCommandTemplate<T extends Entity> {

    public void execute(Command command, String key, ExecutorInterface<T> executor) throws EmptyResponseException, IllegalCommandException {
        /*System.out.println(T.header());
        System.out.println(T.separator());*/

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

    private void printItemList(List<T> list) {
        for (T item : list) {
            printSimpleItem(item);
        }
    }

    private void printSimpleItem(T item) {
        System.out.println(item);
        System.out.println(item.separator());
    }
}
