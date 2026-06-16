package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex01")
    public String ex01(SampleDTO sampleDTO) {

        log.info(sampleDTO);

        return "sample/ex01";

    }

    @GetMapping("/ex02List")
    public String ex02List(SampleDTO sampleDTO) {

        log.info(id);

        return "sample/ex02List";

    }
}
