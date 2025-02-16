package com.myapp.infrastructure.rest;

import com.myapp.application.in.ExamplePresentationPort;
import com.myapp.infrastructure.ExampleEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example")
@RequiredArgsConstructor
public class ExampleRestController implements ExampleEndpoints {

    private ExamplePresentationPort presentationPort;

}
