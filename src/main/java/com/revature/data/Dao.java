package com.revature.data;

import java.util.Set;

public interface Dao<T> {
    T getUser();

    Set<T> getAll();

    Object getByID(int id);

    boolean insert(T t);

    boolean update(T t);

    boolean delete(T t);
}
