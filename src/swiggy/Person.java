/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swiggy;
import java.util.*;
/**
 *
 * @author Administrator
 */
public class Person {
    String mobile,name,area,password;
    public Person(String name,String mobile,String area,String password){
        this.name = name;
        this.mobile = mobile;
        this.area = area;
        this.password = password;
    }
    public Person(){
        
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return mobile;
    }
    public void setArea(String area){
        this.area = area;
    }
    public String getArea(){
        return area;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    @Override
    public String toString(){
        return (name+"\t"+mobile+"\t"+area);
    }
}
