package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "org.scoula.config",
        "org.scoula.controller",
        "org.scoula.ex03.controller"
})
public class RootConfig {
    //프로젝트 전체에서 사용할 중요한 싱글톤 빈 생성 정의



}
