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
public class Order{
    int order_id;
    double price;
    boolean delivered;
    Customer c;
    HashMap<String,Double> food_items;
    HashMap<String,Integer> food_quantities;
    String restaurant;
    String area;
    public Order(String restaurant,HashMap<String,Double> food_items,HashMap<String,Integer> order_quants,double price,String area){
//        order_id = id;
        this.price = price;
        delivered = false;
        this.food_items = food_items;
        this.restaurant = restaurant;
        this.area = area;
        this.food_quantities = order_quants;
    }
    public void deliver(){
        delivered = true;
    }
    @Override
    public String toString(){
//        return (food_items+"\nTotal Price="+price);
        String res=restaurant+"\n";
        for(Map.Entry<String,Double> me:food_items.entrySet()){
            res+=me.getKey()+"\t"+me.getValue()+"\t"+food_quantities.get(me.getKey())+"\n";
        }
        return res;
    }
}
