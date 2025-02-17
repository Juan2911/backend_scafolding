package com.myapp.domain.useCases;

import java.util.List;

public interface ExampleOutputUseCases<T, ID> {

    void saveExampleEntity(T example);
    T findExampleEntityById(ID id);
    List<T> findAllExampleEntities();
    void updateExampleEntity(ID id, T example);
    void deleteExampleEntity(ID id);

}
