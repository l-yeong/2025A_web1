package Example.day03_20250801;

public class TaskDto {
    //멤버변수
    private String name;
    private int age;

    //생성자
    public TaskDto() {}

    public TaskDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Get,Set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //toString

    @Override
    public String toString() {
        return "TaskDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}//class end
