package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller를 사용하면 문자 반환시 뷰 이름이 반환된어 View Resolver 과정 진행. RestController 사용하면 String 자체 반환
@RestController
// private final Logger log = LoggerFactory.getLogger(LogTestController.class); 코드 필요 없음
@Slf4j
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);
//    private final Logger log = LoggerFactory.getLogger(getClass()); 이것도 사용 가능

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        log.trace("trace my log = " + name);

        return "ok";
    }
}
