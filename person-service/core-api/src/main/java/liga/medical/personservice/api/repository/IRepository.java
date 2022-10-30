package liga.medical.personservice.api.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();

    T getById(long id);

    int insert(T entity);
}
