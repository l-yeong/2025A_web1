package example.day04_20250804;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // @Controller(+Component) + @ResponseBody
// HTTP(클라이언트)의 요청 과 응답 처리 담당
public class FetchController {
    // ====================================== 1~4: 요청에 따른 매개변수 [()안에] 없고, 반환값 [VOID]도 없다 ====================================== //
    //1. HTTP 정의, METHOD : GET, URL : /day04/exam1
    @GetMapping("/day04/exam1") // Talend API: Get, http://localhost:8080/day04/exam1 // Response: 200(성공)
    public void method1(){
        System.out.println("FetchController.method1"); // soutm 메소드명 출력
    }//method1 end

    //2. HTTP 정의, METHOD : POST, URL : /day04/exam2
    @PostMapping("/day04/exam2") // Talend API: POST, http://localhost:8080/day04/exam2 // Response: 200(성공)
    public void method2(){
        System.out.println("FetchController.method2");
    }//method2 end

    //3. HTTP 정의, METHOD : PUT, URL : /day04/exam3
    @PutMapping("/day04/exam3") // Talend API: Put, http://localhost:8080/day04/exam3 // Response: 200(성공)
    public void method3(){
        System.out.println("FetchController.method3");
    }//method3 end
    //4. HTTP 정의, METHOD : DELETE, URL : /day04/exam4
    @DeleteMapping("/day04/exam4") // Talend API: DELETE, http://localhost:8080/day04/exam4 // Response: 200(성공)
    public void method4(){
        System.out.println("FetchController.method4");
    }//method4 end

    // ====================================== ====================================== //
    // 5. 매개변수(쿼리스트링) 반환타입(JSON)
    @GetMapping("/day04/exam5") // http://localhost:8080/day04/exam5?name=유재석&age=40
    public boolean method5(@RequestParam String name, @RequestParam int age){
        System.out.println("FetchController.method5");
        System.out.println("name = " + name + ", age = " + age);
        boolean result = true;
        System.out.println("result = " + result);
        return result;
    }//method5 end

    //6. 매개변수(HTTP본문) 변환타입(JSON)
    @PostMapping("/day04/exam6")
    public int method6(@RequestBody Map<String, String>map){
        System.out.println("FetchController.method6");
        System.out.println("map = " + map);
        int result=20;
        return result;
    }//method6 end

    //7.
    // request : localhost:8080/day04/exam7, body:{"name":"유재석","age":"10"}
    // response:
    @PutMapping("/day04/exam7")
    public TaskDto method7(@RequestBody TaskDto taskDto){
        System.out.println("FetchController.method7");
        System.out.println("taskDto = " + taskDto);
        TaskDto result = new TaskDto("강호동",40);
        return result;
    }//method7 end

    @DeleteMapping("/day04/exam8")
    public List<TaskDto> method8 (@RequestParam String name, int age){
        System.out.println("FetchController.method8");
        System.out.println("name = " + name + ", age = " + age);
        System.out.println("name = " + name);
        List<TaskDto> result = new ArrayList<>();
        result.add(new TaskDto("유재석",1));
        result.add(new TaskDto("강호동",2));
        return result;
    }//method8
}//class end
