package test2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class load {
    private load() {}
    public static int Signin() {
        ArrayList<user> users = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flag=false;
        do {
            menu();
            System.out.println("请输入你的选择:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    flag= signin(users);
                   if(flag) break;
                   else continue;
                case 2:
                    zhuce(users);
                    continue;
                case 3:
                    wangji(users);
                    continue;
                case 0:
                    System.out.println("退出！");
                    return 0;
                default:
                    System.out.println("输入错误，请重新输入！");
            }

        } while (!flag);
return 1;
    }

    public static void menu() {
        System.out.println("1.   登录    2. 注册 ");
        System.out.println("3. 忘记密码  0. 退出 ");
    }

    public static void zhuce(ArrayList<user> s) {
        user u = new user();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要注册用户的姓名");
        String name = sc.next();
        if (chazhao(s, name) == -1) {
            u.setUsername(name);
            System.out.println("请输入要注册用户的密码");
            System.out.println("密码由字母(大小写均可)和数字组成且长度不能小于5");
             checkp(u);
            System.out.println("请输入要注册用户的身份证号码");
            checki(u);
            System.out.println("请输入要注册用户的手机号");
            checkn(u);
            s.add(u);
            System.out.println("注册成功！");
        }
        else System.out.println("此用户已存在  请登录！");
    }

    public static int chazhao(ArrayList<user> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(name))
                return i;
        }
        return -1;
    }
    public static  boolean signin(ArrayList<user> u){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        int dex =chazhao(u,username);
        if (dex==-1) {
            System.out.println("此用户不存在 请注册");
            return false;
        }
        else{ boolean m=true;
            do {

                System.out.println("请输入密码");
                String password = sc.next();
                String str = getRandomString(5);
                System.out.println("验证码：" + str);
                System.out.println("请输入验证码(不区分大小写)");
                String s = sc.next();
                if (password.equals(u.get(dex).getPassword()) && s.equalsIgnoreCase(str))
                {m=false;
                    System.out.println("登陆成功！");


                }
                else{ System.out.println("密码或验证码错误！");
                    int flag ;
                   do {
                       System.out.println("若重新登录请按1，若返回菜单请按0");
                       flag=sc.nextInt();
                       if (flag == 0) return false;
                       else if (flag==1) {

                       }
                       else System.out.println("请输入0或1哦亲！");
                   }while(flag!=1);
                }
            }while(m);
        }
        return true;
    }
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789123456789012345678901234567890";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();

    }
   public  static void wangji(ArrayList<user> u){
       System.out.println("请输入身份证号码");
       Scanner sc=new Scanner(System.in);
       String id=sc.next();
       int dex =chazhaobyid(u,id);
if (dex==-1) System.out.println("不存在此id");
else {
    System.out.println("请输入手机号！");
    String number=sc.next();
    if (u.get(dex).getPhonenumber().equals(number)) System.out.println("用户名："+u.get(dex).getUsername()+" 密码："+u.get(dex).getPassword() );
else System.out.println("手机号错误！");
}
   }


   public static int chazhaobyid(ArrayList<user> u,String id){
       for (int i = 0; i < u.size(); i++) {
           if (u.get(i).getId().equals(id))
               return i;
       }
       return -1;

   }
   public static void checkp(user u){
        Scanner sc=new Scanner(System.in);
String password;boolean flag=true;
do {
    int count1=0;int count2=0;
     password=sc.next();
     if (password.length()>=5){
         for (int i = 0; i <password.length() ; i++) {
             char n=password.charAt(i);
             if(n>='A'&&n<='Z'||n>='a'&&n<='z') count1++;
             if (n>='0'&&n<='9')count2++;
         }
         if (count1+count2<password.length()||count1==0||count2==0)
             System.out.println("密码格式错误,请重新输入");
         else {
             u.setPassword(password);
             flag=false;
         }
     }
     else System.out.println("密码太短！请重新输入");

}while(flag);


   }

   public static void checki(user u){
       Scanner sc=new Scanner(System.in);
       String id;boolean flag=true;
do {
    id=sc.next();
    if(id.length()==18&&id.charAt(6)<='2'){
        u.setId(id);
        flag=false;
    }
    else System.out.println("身份证格式错误，请重新输入");
}while(flag);
   }

   public static void checkn(user u){
       Scanner sc=new Scanner(System.in);
       String number;boolean flag=true;
do {
    number=sc.next();
    if (number.length()<=11){
        u.setPhonenumber(number);
        flag=false;
    }
}while(flag);
   }
}