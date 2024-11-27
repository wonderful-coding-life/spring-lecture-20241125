package com.example.api.controller;

import com.example.api.dto.MemberRequest;
import com.example.api.dto.MemberResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("회원 통합 테스트")
public class MemberControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("여러명 배치 생성")
    public void createBatch() throws Exception {
        List<MemberRequest> memberRequests = List.of(
                MemberRequest.builder()
                        .name("윤서준")
                        .email("Seojun-Yoon@hanbit.co.kr")
                        .age(10).build(),
                MemberRequest.builder()
                        .name("윤광철")
                        .email("Kwangcheol-Yoon@hanbit.co.kr")
                        .age(43).build());

        String userRequestString = objectMapper.writeValueAsString(memberRequests);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/members/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(userRequestString);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        List<MemberResponse> memberResponses = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<>() {});

        assertThat(memberResponses.size()).isEqualTo(2);
        assertThat(memberResponses.get(0).getId()).isNotNull();
    }
}
