package Interfaces;

import java.util.List;

public interface Manageable <T>{
    T add();
    void remove(String id);
    List<T> getAll();
}