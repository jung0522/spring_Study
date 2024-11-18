package Controller_Study.Controller_Spring.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";  // hello.jsp (또는 Thymeleaf의 hello.html) 렌더링
    }

    @GetMapping("/api/data")
    @ResponseBody
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "John");
        data.put("age", 30);
        return data;  // JSON 응답
    }

}

@RestController
class MyRestController {

    @GetMapping("/api/hello")
    public String helloRest() {
        return "Hello, World!";  // JSON 응답
    }
}
