package udemy.mytodoapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    // launch that at the url "say-hello"
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }


    //JSP Java Server Pages
}
