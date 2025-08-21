package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PointDto {
    private int mno;
    private int plno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mphone;
    private String mdate;
}//class end
