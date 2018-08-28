package com.lance.learn.springbootmybatis.bean;

import java.util.Date;

/**
 * @Auther: Lance(ZYH)
 * @Date: 2018/8/28 10:37
 * @Description:
 */
public class User {
    private String name;
    private Integer age;
    private String adress;
    private String phone;
    private Date registerDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
