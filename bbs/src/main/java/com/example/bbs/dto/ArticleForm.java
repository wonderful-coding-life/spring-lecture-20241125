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
public class ArticleForm {
    private Long id;
    @NotBlank(message = "제목을 비워 두면 안됩니다.")
    private String title;
    @NotBlank(message = "본문을 비워 두면 안됩니다.")
    private String description;
}
