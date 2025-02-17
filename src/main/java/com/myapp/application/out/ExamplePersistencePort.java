package com.myapp.application.out;

import com.myapp.domain.models.Example;
import com.myapp.domain.useCases.ExampleOutputUseCases;

public interface ExamplePersistencePort extends ExampleOutputUseCases<Example, Long> {
}
