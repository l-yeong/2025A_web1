package 종합.예제8.model.dto;

public class WaitingDto {
    //멤버변수
    private int wno;
    private String wPhone;
    private int wCount;

    //기본생성자
    public WaitingDto() {}

    //풀생성자

    public WaitingDto(int wno, String wPhone, int wCount) {
        this.wno = wno;
        this.wPhone = wPhone;
        this.wCount = wCount;
    }

    //set get
    public int getWno() {
        return wno;
    }

    public void setWno(int wno) {
        this.wno = wno;
    }

    public String getwPhone() {
        return wPhone;
    }

    public void setwPhone(String wPhone) {
        this.wPhone = wPhone;
    }

    public int getwCount() {
        return wCount;
    }

    public void setwCount(int wCount) {
        this.wCount = wCount;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "wno=" + wno +
                ", wPhone='" + wPhone + '\'' +
                ", wCount=" + wCount +
                '}';
    }
}//class end
