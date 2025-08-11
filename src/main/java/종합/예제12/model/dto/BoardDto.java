package 종합.예제12.model.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class BoardDto {
    private int bno;
    private String bcontent;
    private String bwriter;
}//class end
