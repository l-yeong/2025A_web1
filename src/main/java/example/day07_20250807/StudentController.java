package example.day07_20250807;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//@: 어노테이션 이란? 추가적인 정보를 제공하는 메타데이터 역할
@RestController //@Controller (+@Component) + @ResponseBody
//@Component: 스프링 컨테이너(메모리)에 빈(객체) 등록/생성, 싱글톤과 비슷한 역할
//@Controller: HTTP 요청 과 응답 매핑/연결 해주는 어노테이션
//@ResponseBody: HTTP 응답 자료의 *자동* (JSON)타입변환

@RequestMapping("/student")
//@RequestMapping("URL"):지정한 클래스내 모든 메소들의 공통 URL
public class StudentController {
    private  StudentDao studentDao = StudentDao.getInstance();

    //1. 저장
    @PostMapping("/save") //localhost:8080/student/save
    //@PostMapping: HTTP 요청 중에 method가 Post 인 요청 매핑
    //("/URL"): HTTP 주소 만들기/정의
    public boolean save(@RequestBody StudentDto studentDto){
        System.out.println("StudentController.save");
        System.out.println("studentDto = " + studentDto);

        boolean result = studentDao.save(studentDto);

        return result; //임시
    } // func end

    //2. 전체조회
    @GetMapping("/find") //localhost:8080/student/find
    //@GetMapping: HTTP 요청 중에 method가 Get 인 요청 매핑
    public List<StudentDto> find(){
        System.out.println("StudentController.find");

        List<StudentDto> result = studentDao.find();

        return result;//임시
    } //func end

} //class end
