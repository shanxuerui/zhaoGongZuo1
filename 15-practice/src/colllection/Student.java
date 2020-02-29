package colllection;

/**
 * Author:单雪瑞
 * 2020/2/22 16:18
 */
public class Student implements Comparable<Student>{

    private String name;
    private int age;
    private int biethday;


    public Student(String name, int age, int biethday) {
        this.name = name;
        this.age = age;
        this.biethday = biethday;
    }

    public Student() {
    }

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

    public int getBiethday() {
        return biethday;
    }

    public void setBiethday(int biethday) {
        this.biethday = biethday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", biethday=" + biethday +
                '}';
    }


    @Override
    public int compareTo(Student o) {
       int i =  o.getBiethday()-this.getBiethday(); //降
       if (i==0){
           return  this.getName().compareTo(o.getName());//升
       }

       return i;
    }
}
