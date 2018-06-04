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
public class Owner extends Person{
    int id;
    public Owner(String name,String mobile,String area,String password){
        super(name,mobile,area,password);
        this.id=id;
    }
    public void addItem(String name,double price,HashMap<String,Double> food_items){
        food_items.put(name,price);
    }
}
