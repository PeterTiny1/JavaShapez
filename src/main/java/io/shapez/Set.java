package io.shapez;

public interface Set<T> {
    Set add(Class T);

    void clear();

    boolean delete(Class T);

    void forEach();

    boolean has(Class T);

    int size();
}
