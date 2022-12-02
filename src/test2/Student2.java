package test2;

public class Student2 extends Person{

    private int age;

    private String address;

    public Student2() {
    }

    public Student2(String name, int age, String id, String address) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.address = address;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
