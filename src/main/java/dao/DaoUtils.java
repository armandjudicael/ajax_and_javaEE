package dao;

import java.util.List;

public interface DaoUtils<T> {
   boolean create(T o);
   int update(T o);
   int delete(T o);
   List<T> findAll();
   T findById(int id);
}
