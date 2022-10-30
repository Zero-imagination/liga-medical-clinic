package liga.medical.personservice.api.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();

    T getById(long id);

    int insert(T entity);
}
