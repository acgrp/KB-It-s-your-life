package org.scoula.security;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        RootConfig.class,
        SecurityConfig.class
})
@Log4j2
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder pwEncoder;

    @Test
    public void testEncode() {
        String str = "1234";

        // 같은 문자열을 두 번 암호화
        String enStr = pwEncoder.encode(str);  // $2a$10$ydUpuDxy9CK6DGDpOvCN4OFWhNfhAV/OjMn6TVfJinRL1ZkU2nVOW
        String enStr2 = pwEncoder.encode(str); // $2a$10$.uSZ5a/538Xp.PjucCyAHejfQ54sBtZtHRtTrNM9n1wkuuijLYr0i

        log.info("password: " + enStr);   // 매번 다른 결과
        log.info("password: " + enStr2);  // 매번 다른 결과

        // 하지만 matches(평문, 암호문)로 검증하면 모두 true
        log.info("match: " + pwEncoder.matches(str, enStr));   // true
        log.info("match: " + pwEncoder.matches(str, enStr2));  // true

        log.info("match: " + pwEncoder.matches(str, str));  // false
    }
}
