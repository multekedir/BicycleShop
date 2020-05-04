package com.revature.data;

import java.util.Set;

public interface Dao<T> {

    boolean insert(T t);

    T getUserByID(int id);

    Set<T> getAll();

    boolean update(T t);

    boolean delete(T t);
}
