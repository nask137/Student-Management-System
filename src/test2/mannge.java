package test2;
import java.util.ArrayList;
import java.util.Scanner;

public class mannge {
    public static void main(String[] args) {
        System.out.println("-------欢迎来到成都大学学生信息管理系统-------");
      int flag=  load.Signin();
        if (flag==1) {
            ArrayList<Student2> students = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                menu();
                System.out.println("请输入你的选择:");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        add(students);
                        continue;
                    case 2:
                        shanchu(students);
                        continue;
                    case 3:
                        Chazhao(students);
                        continue;
                    case 4:
                        xiugai(students);
                        continue;
                    case 5:
                        show(students);
                        continue;
                    case 0:
                        System.out.println("退出！");
                        break;
                    default:
                        System.out.println("输入错误，请重新输入！");
                }

            } while (choice != 0);
        }
    }


    public static void menu(){

        System.out.println("1. 增添  2. 删除");
        System.out.println("3. 查找  4. 修改");
        System.out.println("5. 展示  0. 退出");
    }
    public static void add(ArrayList<Student2> list){
        Student2 s=new Student2();
                Scanner sc=new Scanner(System.in);
            System.out.println("请输入要添加学生的姓名");
            String name=sc.next();
            if (chazhao(list,name)==-1) {
                s.setName(name);
                System.out.println("请输入要添加学生的年龄");
                int age = sc.nextInt();
                s.setAge(age);
                System.out.println("请输入要添加学生的id");
                String id = sc.next();
                s.setId(id);
                System.out.println("请输入要添加学生的住址");
                String address = sc.next();
                s.setAddress(address);
                list.add(s);
                System.out.println("添加成功！");

            }
            else System.out.println("此学生已经存在！");

    }

    public static void shanchu(ArrayList<Student2> list){
        System.out.println("请输入要删除学生的名字！");
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        int index=chazhao( list, name);
        if (index==-1)
            System.out.println("所删除人不存在！");
        else {list.remove(index);
            System.out.println("删除成功！");
        }
    }
    public static int chazhao(ArrayList<Student2> list,String name){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }
    public static void  Chazhao(ArrayList<Student2> list){
        System.out.println("请输入要查找学生的名字！");
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        int index=chazhao(list,name);
        if (index==-1) System.out.println("找不到！");
       else System.out.println( "找到了：姓名 "+list.get(index).getName()+"  ,年龄  "+list.get(index).getAge()+" , 学号  "+list.get(index).getId()+",  住址  "+list.get(index).getAddress());
    }
    public static  void xiugai(ArrayList<Student2> list){
        System.out.println("请输入要修改学生的名字！");
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        int index=chazhao(list ,name);
        if (index==-1) System.out.println("要修改的学生不存在！");
        else {
            System.out.println("请输入要修改学生的年龄");
            int age = sc.nextInt();
            list.get(index).setAge(age);
            System.out.println("请输入要修改学生的id");
            String id = sc.next();
            list.get(index).setId(id);
            System.out.println("请输入要修改学生的住址");
            String address = sc.next();
            list.get(index).setName(address);
            System.out.println("修改成功！");
        }
    }
    public static void show(ArrayList<Student2> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println("姓名  "+list.get(i).getName()+",  年龄  "+list.get(i).getAge()+",  学号  "+list.get(i).getId()+"  ,住址  "+list.get(i).getAddress());
        }
    }
}
