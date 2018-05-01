package testcollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class TestHashSet {
    public static void main(String[] args) {
        /*HashSet set = new HashSet();
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("hello");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/


        Set set = new HashSet();
        Student stu1 = new Student("aaa", 12);
        Student stu2 = new Student("aaa", 12);
        set.add(stu1);
        set.add(stu2);
        System.out.println(set.size());
    }
}


class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("比较student是否属性相同！");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age && name != student.name) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        System.out.println("Sudent的hashcode()方法");
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}