package com.myapp.infrastructure.persistences.dataAccess;

import com.myapp.application.out.ExamplePersistencePort;
import com.myapp.domain.exceptions.ExampleCustomException;
import com.myapp.domain.models.Example;
import com.myapp.infrastructure.persistences.entities.ExampleEntity;
import com.myapp.infrastructure.persistences.repositories.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExampleDao implements ExamplePersistencePort {

    private final ExampleRepository exampleRepository;

    @Override
    public void saveExampleEntity(Example example) {
        ExampleEntity entity = ExampleEntity.builder()
                .id(example.getId())
                .field1(example.getField1())
                .field2(example.getField2())
                .build();

        exampleRepository.save(entity);
    }

    @Override
    public Example findExampleEntityById(Long aLong) {
        ExampleEntity entityFound = exampleRepository.findById(aLong)
                .orElseThrow(() -> new ExampleCustomException("Not found"));

        return Example.builder()
                .id(entityFound.getId())
                .field1(entityFound.getField1())
                .field2(entityFound.getField2())
                .build();
    }

    @Override
    public List<Example> findAllExampleEntities() {
        List<ExampleEntity> entitiesFound = exampleRepository.findAll();

        return entitiesFound.stream()
                .map(entity -> Example.builder()
                        .id(entity.getId())
                        .field1(entity.getField1())
                        .field2(entity.getField2())
                        .build())
                .toList();
    }

    @Override
    public void updateExampleEntity(Long aLong, Example example) {
        ExampleEntity entity = exampleRepository.findById(aLong)
                .orElseThrow(() -> new ExampleCustomException("Not found"));

        entity.setField1(example.getField1());
        entity.setField2(example.getField2());

        exampleRepository.save(entity);
    }

    @Override
    public void deleteExampleEntity(Long aLong) {
        if(exampleRepository.existsById(aLong)) {
            exampleRepository.deleteById(aLong);
        }
    }
}
