package TestLambda;

/**
 * @Auther: zhaomo
 * @Date: 2020/07/16 20:24
 * @Description:
 */
public class Student {
    private String name;
    private Integer age;
    private double size;
    private double salary;

    public Student() {
    }

    public Student(String name, Integer age, double size, double salary) {
        this.name = name;
        this.age = age;
        this.size = size;
        this.salary = salary;
    }

    public Student(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", size=" + size +
                ", salary=" + salary +
                '}';
    }
}
