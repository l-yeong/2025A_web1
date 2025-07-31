package Example.day02_20250731._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RestController2 {
    //싱글톤 대신에 @Component 이용한 인스턴스 자동 생성

    // [ 반환타입 있는 REST ]
        // @ResponseBody : 자바는 int 타입을 알지만 웹HTTP는 int 타입 누구세요?
            // 역할: 자바에서 사용하는 타입들을 자동으로 HTTP(웹)이 이해하는 타입으로 변환 해준다.

    // 1. 100 반환하는 메소드, http://localhost:8080/day02/task
    @GetMapping("/day02/task") //@XXXMapping("URL주소정의")
    @ResponseBody // 자바에서 반환하는 int 타입을 HTTP가 이해하는 타입으로 자동 변환
    public int method1(){
        System.out.println("RestController2.method1");
        return 100;
    }//method1 end

    //2. 문자열 반환하는 메소드
    @GetMapping("/day02/task2") // 주의할점: 서버내 동일한 주소는 불가능
    @ResponseBody
    public String method2(){
        System.out.println("RestController2.method2");
        return "자바에서 보는 메세지";
    }

    //3. MAP 타입 반환하는 메소드
    @PostMapping("day02/task") //주의할점: 서버내 동일한 주소가 불가능 하지만 REST 다르면 가능
    @ResponseBody // 자바에서 반환하는 Map 타입은 HTTP가 이해하는 타입으로 자동 변환
    public Map<String,Integer>method3(){
        System.out.println("RestController2.method3");
        Map<String,Integer> map = new HashMap<>();
        map.put("강호동",10);
        map.put("유재석",100);
        return map;
    }

    //4. BOOLEAN 타입 반환하는 메소드
    @PutMapping("/day02/task")
    @ResponseBody // 자바에서 반환하는 boolean 타입은 http가 이해하는 타입으로 자동 변환
    public boolean method4(){
        System.out.println("RestController2.method4");
        return false;
    }

    //5. DTO 타입 반환하는 메소드
    // DTO 반환할때  DTO 생성자,Setter Getter,toString 꾸리기
    @DeleteMapping("/day02/task")
    @ResponseBody
    public TaskDto method5(){
        System.out.println("RestController2.method5");
        TaskDto taskDto = new TaskDto(); //임의 데이터
        return taskDto;
    }

    //6. ArrayList 타입 반환하는 메소드
    @GetMapping("/day02/task3")
    @ResponseBody
    public List<TaskDto> method6(){
        System.out.println("RestController2.method6");
        ArrayList<TaskDto>list = new ArrayList<>();
        list.add(new TaskDto());
        list.add(new TaskDto());
        return list;
    }
}//class end
