
package com.revature.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class GenericDAO<T> {

    public static int id = 0;
    Map<Integer, T> storage = new HashMap<Integer, T>();

    public Integer add(T t) {
        storage.put(id, t);
        return id++;
    }

    public T getById(int id) {
        return storage.get(id);
    }

    public Set<T> getAll() {
        Set toReturn = new HashSet<T>();
        for (int i : storage.keySet()) {
            toReturn.add(storage.get(i));
        }
        return toReturn;
    }

    public void update(int id, T updated) {
        storage.put(id, updated);
    }

    public void delete(int id) {
        System.out.println("Removing " + this.getById(id));
        storage.remove(id);
    }


}