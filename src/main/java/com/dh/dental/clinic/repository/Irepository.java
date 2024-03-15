package com.dh.dental.clinic.repository;

import java.util.List;

public interface Irepository<T> {
    T save(T t);
    List<T> searchAll(Long id);
    T searchById(Long id);
    void delete(Long id);
    void update(T t);
}
