package com.fractal.usecase;

import java.util.List;

public interface Usecase<T, I> {

    List<T> getAll();
    T getById(I id);
    void delete(I id);
    T create(T object);
    T update(T object);
    T updateName(I id, String name);
    T updateDailyIncome(I id, Double name);
}
