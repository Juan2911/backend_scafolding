package com.myapp.application.services;

import com.myapp.application.in.ExamplePresentationPort;
import com.myapp.application.out.ExamplePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleService implements ExamplePresentationPort {

    private ExamplePersistencePort persistencePort;

}
