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
public class Restaurant{
    String name,area,password;
    static int next;
    HashMap<String,Double> food_items;
    ArrayList<String> non_veg;
    ArrayList<String> veg;
    public Restaurant(String name,String area) {
        this.name = name;
        this.area = area;
        this.password = "password";
        next=10;
        food_items = new HashMap<>();
        food_items.put("VegPizza",120.0);
        food_items.put("VegBurger",90.0);
        food_items.put("Chicken",150.0);
        food_items.put("Coke",15.0);
        food_items.put("DoughtNut",70.0);
        non_veg = new ArrayList<>();
        veg = new ArrayList<>();
        non_veg.add("Chicken");
        veg.add("VegPizza");
        veg.add("Coke");
        veg.add("DoughtNut");
        veg.add("VegBurger");
    }

    public Restaurant() {
        next=0;
        food_items = new HashMap<>();
        food_items.put("VegPizza",120.0);
        food_items.put("VegBurger",90.0);
        food_items.put("Chicken",150.0);
        food_items.put("Coke",15.0);
        food_items.put("DoughNut",70.0);
        non_veg = new ArrayList<>();
        veg = new ArrayList<>();
        non_veg.add("Chicken");
        veg.add("VegPizza");
        veg.add("Coke");
        veg.add("DoughNut");
        veg.add("VegBurger");
    }
    
//    public void addItem(String name,double price){
//        food_items.put(name,price);
//    }
    public void addItem(String name,double price,int type){
        food_items.put(name,price);
        if(type==1){
            non_veg.add(name);
        }
        else{
            veg.add(name);
        }
    }
    public void removeItem(String name,int type){
        food_items.remove(name);
        if(type==1){
            non_veg.remove(name);
        }
        else{
            veg.remove(name);
        }
    }
    void displayFoodItems() {
        Scanner sc = new Scanner(System.in);
        int i=0;
        System.out.println("Please select ant of the following category"
                + "\n1.Non-Veg\n2.Veg");
        String category;
        //new code to display food items from a selected category
        do{
            category = sc.next();
        switch(category){
            case "1":
                for(String f:non_veg){
                    System.out.println(f+"\t"+food_items.get(f));
                }
                break;
            case "2":
                for(String f:veg){
                    System.out.println(f+"\t"+food_items.get(f));
                }
                break;
            default:
                System.out.println("Please enter a valid option");
        }
        }while(!category.equals("1")&&!category.equals("2"));
        
        //older code to display all food items
//        for(Map.Entry<String,Double> me:food_items.entrySet()){
//            System.out.println(me.getKey()+"\t"+me.getValue());
//            i++;
//        }
    }
    @Override
    public String toString(){
        return (name+"\t"+area);
    } 
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
