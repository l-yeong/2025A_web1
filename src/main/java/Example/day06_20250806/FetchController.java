package Example.day06_20250806;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FetchController {

    //(1)
    @GetMapping("/day06/exam1")
    public boolean method1(){
        return true;
    }
}//func end
