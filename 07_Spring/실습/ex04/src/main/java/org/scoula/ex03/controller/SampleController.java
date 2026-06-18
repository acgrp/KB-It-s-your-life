package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex01")
    public String ex01(SampleDTO sampleDTO) {

        log.info(sampleDTO);

        return "sample/ex01";

    }

    @GetMapping("/ex02")
    public String ex02(String name, int age) {

        log.info(name);
        log.info(age);

        return "sample/ex02";

    }

    /* @GetMapping("/ex02List")
     public String ex02List(String[] ids) {

         log.info("String[] ids: " + Arrays.toString(ids));

         return "sample/ex02List";

     }   */
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids) {// ArrayList 나 List는 RequestParam를 붙여야함
        log.info("ArrayList<String> ids : " + ids);

        return "sample/ex02List";

    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todoDTO) {

        log.info(todoDTO);

        return "sample/ex03List";

    }

    @GetMapping("/ex07")
    @ResponseBody
    public SampleDTO ex07() {

        SampleDTO sampleDTO = new SampleDTO();
        sampleDTO.setName("AAA");
        sampleDTO.setAge(14);

        return sampleDTO;

    }
}
