package dto;

public class StudentDTO {
    private String name;
    private int age;

    public StudentDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
