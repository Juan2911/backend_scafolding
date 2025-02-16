package com.myapp.infrastructure;

import com.myapp.infrastructure.rest.dtos.ExampleDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/example")
public interface ExampleEndpoints {

    @PostMapping
    ResponseEntity<String> saveExample(@RequestBody @Valid ExampleDto exampleDto);

    @GetMapping("/{id}")
    ResponseEntity<ExampleDto> findExampleById(@PathVariable("id") Long id);

    @GetMapping("/all")
    ResponseEntity<List<ExampleDto>> findAllExamples();

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateExample(@PathVariable("id") Long id, @RequestBody @Valid ExampleDto exampleDto);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteExample(@PathVariable("id") Long id);
}
