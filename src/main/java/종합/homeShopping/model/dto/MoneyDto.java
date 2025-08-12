package 종합.homeShopping.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class MoneyDto {
    private int custNo;
    private int saleNol;
    private int pCost;
    private int aMount;
    private int price;
    private String pCode;
    private String sDate;
}
