package 종합.shopping.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class MemberDto {
    private int custno;
    private String custname;
    private String phone;
    private String address;
    private String joindate;
    private String grade;
    private String city;
}
