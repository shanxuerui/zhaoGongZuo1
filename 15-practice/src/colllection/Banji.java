package colllection;

import java.util.Comparator;
import java.util.List;

/**
 * Author:单雪瑞
 * 2020/2/22 16:50
 */
public class Banji {

    List<Student> list;

    public Banji(List<Student> list) {
        this.list = list;
    }

    public Banji() {
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Banji{" +
                "list=" + list +
                '}';
    }


    public void sortByBitthdayAscNameDesc(){
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
               int i =  o1.getBiethday()-o2.getBiethday();

               if (i==0){
                   return o2.getName().compareTo(o1.getName());
               }
               return i;
            }
        });
    }

}
