
package com.revature.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.revature.singleton.LoggerSingleton.getLogger;


public class GenericDAO<T> {

    private final Class<T> clazz;
    public static int id = 0;
    Map<Integer, T> storage = new HashMap<Integer, T>();

    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Integer add(T t) {
        storage.put(id, t);
        getLogger(GenericDAO.class).debug("Added " + clazz.getSimpleName() + " with ID =" + id);
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

    public Map<Integer, T> getAllMap() {

        return storage;
    }

    public Integer size() {

        return storage.size();
    }

    public void update(int id, T updated) {
        storage.put(id, updated);
    }

    public boolean delete(int id) {
        System.out.println(storage);
        if (storage.containsKey(id)) {
            storage.remove(id);
            getLogger(GenericDAO.class).debug("Removed " + clazz.getSimpleName() + " with ID = " + id);
            return true;
        }
        getLogger(GenericDAO.class).error("ID not found");
        return false;
    }


}