package colllection;

import java.util.*;

/**
 * Author:单雪瑞
 * 2020/2/22 16:31
 */
public class Test {



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(3);

        list.sort(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {

//               return o1-o2;//升
                 return o2-o1;//降
           }
       });

        System.out.println(list);


//
//
//
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//
//              return   o2.compareTo(o1);
//            }
//        });

//        List<Student> list = new ArrayList<>();
//        list.add(new Student("zhangsan1", 23, 19970923));
//        list.add(new Student("zhangsan2", 24, 19970922));
//        list.add(new Student("zhangsan3", 23, 19970822));
//        list.add(new Student("zhangsan6", 23, 19970822));
//        list.add(new Student("zhangsan7", 23, 19970822));
//        list.add(new Student("zhangsan3", 23, 19970822));
//        list.add(new Student("zhangsan4", 25, 19960822));
//        list.add(new Student("zhangsan5", 22, 19990923));
//            list.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                int i =   o1.getBiethday()-o2.getBiethday();  //升
//                if (i==0){
//                    return  o2.getName().compareTo(o1.getName()); //降
//              }
//
//              return i;
//            }
//        });
//            for (Student student : list) {
//            System.out.println(student.toString());
//        }


//        Collections.sort(list);
//        Banji banji = new Banji();
//        List<Student> list = new ArrayList<>();
//        list.add(new Student("zhangsan1", 23, 19970923));
//        list.add(new Student("zhangsan2", 24, 19970922));
//        list.add(new Student("zhangsan3", 23, 19970822));
//        list.add(new Student("zhangsan6", 23, 19970822));
//        list.add(new Student("zhangsan7", 23, 19970822));
//        list.add(new Student("zhangsan3", 23, 19970822));
//        list.add(new Student("zhangsan4", 25, 19960822));
//        list.add(new Student("zhangsan5", 22, 19990923));
//        banji.setList(list);
//        banji.sortByBitthdayAscNameDesc();
//
//        for (int i = 0;i<banji.getList().size();i++){
//
//            System.out.println(banji.getList().get(i));
//        }





    }
}
