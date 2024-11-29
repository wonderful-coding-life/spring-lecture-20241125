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
/*
    @NotNull : Null이 아닌지 검증합니다.
    @NotEmpty : Null도 아니고 값이 비어있지 않은지 검증합니다. 문자열 뿐만 아니라 리스트도 검증할 수 있습니다.
    @NotBlank : Null도 아니고 문자열의 경우 스페이스로만 이루어지 않았는지도 검증합니다. 즉, " "는 검증을 통과하지 못 합니다.
    @Email : 이메일 형식인지 검사합니다. 다만 입력된 이메일 문자열이 비어있어도 검증을 통과하므로 비어있지 않은지도 함께 확인하려면 @NotBlank를 추가합니다.
    @Size(min=최소 길이, max=최대 길이) : 문자열의 길이를 검증합니다.
    @Max(value = 최대 값) : 숫자의 최대 값을 검증합니다.
    @Min(value = 최소 값) : 숫자의 최소 값을 검증합니다.
    @Positive : 값이 0 보다 큰 양수인지 검증합니다.
    @PositiveOrZero : 값이 0 또는 양수인지 검증합니다.
    @Negative : 값이 0 보다 작은 음수인지 검증합니다.
    @NegativeOrZero : 값이 0 또는 음수인지 검증합니다.
 */
