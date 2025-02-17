package com.myapp.infrastructure.rest;

import com.myapp.application.in.ExamplePresentationPort;
import com.myapp.infrastructure.ExampleEndpoints;
import com.myapp.infrastructure.rest.dtos.ExampleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExampleRestController implements ExampleEndpoints {

    private final ExamplePresentationPort presentationPort;

    @Override
    public ResponseEntity<String> saveExample(ExampleDto exampleDto) {
        presentationPort.saveExample(exampleDto);
        return new ResponseEntity<>("Example saved", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ExampleDto> findExampleById(Long id) {
        ExampleDto exampleDto = presentationPort.findExampleById(id);
        return new ResponseEntity<>(exampleDto, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<ExampleDto>> findAllExamples() {
        List<ExampleDto> examples = presentationPort.findAllExamples();
        return new ResponseEntity<>(examples, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<String> updateExample(Long id, ExampleDto exampleDto) {
        presentationPort.updateExample(id, exampleDto);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteExample(Long id) {
        presentationPort.deleteExample(id);
        return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
    }
}
