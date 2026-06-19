package org.scoula.ex03.dto;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Data
public class SampleDTOList {
    private List<SampleDTO> list;

    public SampleDTOList() {
        list = new ArrayList<>();
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos: " + list);
        return "ex02Bean";
        // 복합 객체 내부의 리스트도 자동 바인딩 처리


    }
}
