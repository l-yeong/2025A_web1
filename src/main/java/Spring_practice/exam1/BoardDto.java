package Spring_practice.exam1;

public class BoardDto {

    //멤버변수
    private int bno;
    private String btitle;

    //기본생성자
    public BoardDto(){}
    //풀생성자
    public BoardDto(int bno, String btitle) {
        this.bno = bno;
        this.btitle = btitle;
    }

    //Setter Getter

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    //toString

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", btitle='" + btitle + '\'' +
                '}';
    }
}
