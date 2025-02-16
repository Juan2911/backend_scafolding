package com.myapp.application.in;

import com.myapp.domain.useCases.ExampleInputUseCases;
import com.myapp.infrastructure.rest.dtos.ExampleDto;

public interface ExamplePresentationPort extends ExampleInputUseCases<ExampleDto, Long> {
}
