package primary.courseone.selfcode;

import java.util.Arrays;
// 我的命名 Comparator 和一个接口名重名了，下次要注意
// 比较器的使用,使用系统提供的Arrays.sort方法，如何排序自定义的数据类型
public class Comparator {
    public static class Student{
        int id;
        String name;
        int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void printArray(Student[] stu){
        for (Student student : stu) {
            System.out.println("学号："+student.id+" 姓名:"+student.name+" 年龄："+student.age);
        }
        System.out.println("===========================================");
    }

    //  按 id 升序排列； 同理可改成按 age 排序等
    public static class IdAscendComparator implements java.util.Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }
    public static void main(String[] args) {

        Student[] stu = new Student[3];
        stu[0] = new Student(1,"梅婕",25);
        stu[1] = new Student(3,"梅志成",21);
        stu[2] = new Student(2,"小青子",19);
        printArray(stu);

        Arrays.sort(stu, new IdAscendComparator());  // 一定注意，这里需要加上
        printArray(stu);
    }

}
