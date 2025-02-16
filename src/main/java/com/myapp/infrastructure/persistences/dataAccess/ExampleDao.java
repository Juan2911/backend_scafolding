package com.myapp.infrastructure.persistences.dataAccess;

import com.myapp.application.out.ExamplePersistencePort;
import com.myapp.infrastructure.persistences.repositories.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExampleDao implements ExamplePersistencePort {

    private ExampleRepository exampleRepository;

}
