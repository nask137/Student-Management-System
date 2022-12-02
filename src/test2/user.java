package test2;

public class user extends Person{

   private     String password;

    private String  phonenumber;

    public user() {
    }

    public user(String username, String password, String id, String phonenumber) {
        this.name = username;
        this.password = password;
        this.id = id;
        this.phonenumber = phonenumber;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
