package com.myapp.domain.useCases;

import java.util.List;

public interface ExampleInputUseCases<T, U>{

    void saveExample(T exampleDto);
    T findExampleById (U id);
    List<T> findAllExamples();
    void updateExample(U id, T exampleDto);
    void deleteExample(U id);

}
