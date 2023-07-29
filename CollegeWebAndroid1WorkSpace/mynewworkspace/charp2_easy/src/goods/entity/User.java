package goods.entity;

import java.util.Date;

public class User {

    private int id;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String email;
    private Date birthday;
    private int role;


    public User() {

    }

    public User(int id, String username, String password, String sex, String phone, String email, Date birthday, int role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.role = role;
    }
    //
    // getter/setter
    // ------------------------------------------------------------------------------


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
