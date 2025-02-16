package com.myapp.application.services;

import com.myapp.application.in.ExamplePresentationPort;
import com.myapp.application.out.ExamplePersistencePort;
import com.myapp.domain.models.Example;
import com.myapp.infrastructure.rest.dtos.ExampleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService implements ExamplePresentationPort {

    private final ExamplePersistencePort persistencePort;

    @Override
    public void saveExample(ExampleDto exampleDto) {
        Example example = Example.builder()
                .id(exampleDto.getId())
                .field1(exampleDto.getField1())
                .field2(exampleDto.getField2())
                .build();

        persistencePort.saveExampleEntity(example);
    }

    @Override
    public ExampleDto findExampleById(Long id) {
        Example example = persistencePort.findExampleEntityById(id);

        return ExampleDto.builder()
                .id(example.getId())
                .field1(example.getField1())
                .field2(example.getField2())
                .build();
    }

    @Override
    public List<ExampleDto> findAllExamples() {
        List<Example> examples = persistencePort.findAllExampleEntities();

        return examples.stream()
                .map(example -> ExampleDto.builder()
                        .id(example.getId())
                        .field1(example.getField1())
                        .field2(example.getField2())
                        .build())
                .toList();
    }

    @Override
    public void updateExample(Long id, ExampleDto exampleDto) {
        Example example = Example.builder()
                .id(exampleDto.getId())
                .field1(exampleDto.getField1())
                .field2(exampleDto.getField2())
                .build();

        persistencePort.updateExampleEntity(id, example);
    }

    @Override
    public void deleteExample(Long id) {
        persistencePort.deleteExampleEntity(id);
    }
}
