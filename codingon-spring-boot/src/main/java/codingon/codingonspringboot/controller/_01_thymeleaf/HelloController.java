package codingon.codingonspringboot.controller._01_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/hi")
    public String getHi(Model model) {
        // Model model: Controller 클래스 안의 메소드가 파라미터로 받을 수 있는 객체
        // - 정보를 담아 view 에게 넘겨줄 때 사용
        // - 간단할 경우 개발자가 직접 model을 생성할 필요 없이, 파라미터로 선언만 해주면 Spring이 알아서 만듦
        model.addAttribute("msg", "Hi!devtool!!!"); // ejs에서 보내는 것처럼

        // Thymeleaf 표현식과 문법
        model.addAttribute("uText", "<strong>I am String!</strong>");
        model.addAttribute("putName", "이름을 입력하세요");
        model.addAttribute("withValue", "hello");
        model.addAttribute("link", "hi");
        model.addAttribute("imgSrc", "sf.jpg");
        model.addAttribute("userRole", "sf");
        model.addAttribute("isAdmin", false);
        List<String> names = Arrays.asList("kim", "lee", "kwak");
        model.addAttribute("names", names);
        Hello hello = new Hello(25);

        model.addAttribute("classHello", hello);
        return "_01_thymeleaf/hi";
    }
}

class Hello{
    private int age;

    public Hello(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}