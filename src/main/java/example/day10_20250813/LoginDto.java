package example.day10_20250813;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data//@Getter@Setter@ToString 포함되어있음
public class LoginDto {
    private int mno;
    private String mid;
    private String mpwd;
}
