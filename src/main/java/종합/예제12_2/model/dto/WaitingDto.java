package 종합.예제12_2.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


public class WaitingDto {
    private int wno;
    private String wphone;
    private int wcount;
    private String wdate;
}
