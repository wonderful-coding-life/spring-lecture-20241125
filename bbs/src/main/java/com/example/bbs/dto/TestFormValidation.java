package com.example.bbs.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestFormValidation {
    @NotBlank(message = "이름을 넣어 주세요")
    private String name;
    @NotBlank(message = "주소를 넣어 주세요")
    private String address;
}
