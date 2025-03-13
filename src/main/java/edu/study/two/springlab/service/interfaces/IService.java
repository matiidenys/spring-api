package edu.study.two.springlab.service.interfaces;

/*
    @author  matiidenys
    @project  springlab
    @class  IService
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

import java.util.List;

public interface IService<T> {
    T create(T t);
    T get(String id);
    T update(T t);
    void delete(String id);
    List<T> getAll();
}
