package za.ac.cput.service;

import java.util.List;

/**
 * IService.java
 *
 * @author Zachariah Matsimella
 * Student Num: 220097429
 * @date 06-Sep-24
 */

public interface IService<T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

    List<T> getAll();
}
