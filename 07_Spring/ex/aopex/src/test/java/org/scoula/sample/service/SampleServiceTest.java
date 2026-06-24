package org.scoula.sample.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SampleServiceTest {

    @Autowired
    private SampleService sampleService;

    @Test
    public void doAdd() throws Exception {
        sampleService.doAdd("10", "20");
    }
}