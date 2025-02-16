package com.myapp.infrastructure.rest.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExampleDto {

    @NotBlank(message = "Cannot be blank")
    private String field1;
    @Min(value = 18, message = "Not under 18")
    private Integer field2;

}
