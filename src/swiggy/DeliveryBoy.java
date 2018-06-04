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
public class DeliveryBoy{
   String name;
   String area;
   String mobile;
   String password;
   ArrayList<Integer> order_numbers;
    public DeliveryBoy(String name,String mobile,String area,String password) {
        this.name = name;
        this.area = area;
        this.mobile = mobile;
        this.password = password;
        order_numbers = new ArrayList<>();
    }
    public DeliveryBoy() {
    	order_numbers = new ArrayList<>();
    }
   public void deliver(ArrayList<Order> orders,int order_id){
       orders.get(order_id-1).delivered = true;
   }
   public void showDeliveries(ArrayList<Order> orders){
       for(int i=1;i<=Swiggy.order_id;i++){
           if(orders.get(i-1).area.equals(area)){
               System.out.println(i+"."+orders.get(i-1));
           }
       }
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