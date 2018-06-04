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
public class Customer{
    String mobile,name,area,password;
    ArrayList<Integer> order_numbers;
    public Customer(String name){
        this.name = name;
        order_numbers = new ArrayList<>();
    }
    public Customer(String name,String mobile,String area,String password){
        this.name = name;
        this.mobile = mobile;
        this.area = area;
        this.password = password;
        order_numbers = new ArrayList<>();
    }
    public Customer(){
        order_numbers = new ArrayList<>();
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
//    public void placeOrder(int id,String restaurant,HashMap<String,Double> food_items,int price){
//        
//    }

//    public Order orderFood(ArrayList<String> areas,HashMap<Integer,Restaurant> restaurants) {
//        Scanner sc = new Scanner(System.in);
//        String area="";
//        do{
//        if(area.equals(""))
//            System.out.println("Please Enter your area");
//        else
//            System.out.println("Sorry Our Service is not provide there\nPlease selct a valid area");
//        Swiggy.displayAreas(areas);
//        area = sc.next();
//        }while(areas.indexOf(area)==-1);
//        int restaurant_index;
//        ArrayList<Integer> restaurant_indeces = new ArrayList<>();
//        do{
//            System.out.println("Please Select Any Restaurant");
//            restaurant_indeces = Swiggy.getRestaurantIndeces(restaurants,area);
//            Swiggy.displayRestaurants(restaurants,area);
//            restaurant_index = sc.nextInt();
//        }while(!restaurant_indeces.contains(restaurant_index));
////        boolean order=false;
//        Restaurant SelectedRestaurant = restaurants.get(restaurant_index);
//        SelectedRestaurant.displayFoodItems();
//        String food_option="";
//        HashMap<String,Double> order_items = new HashMap<>();
//        do{
//            System.out.println("Input -1 to stop input:");
//            food_option=sc.next();
//            if(SelectedRestaurant.food_items.get(food_option)!=null){
//                order_items.put(food_option,SelectedRestaurant.food_items.get(food_option));
//            }
//            else{
//                System.out.println("Sorry we provide only the before mentioned food items");
//            }
//        }while(!food_option.equals("-1"));
//        double total_price = getTotalPrice(order_items);
//        Swiggy.getPayment(this,total_price);                            
//        ++(Swiggy.order_id);
//        this.orders.add(new Order(Swiggy.order_id,SelectedRestaurant.name,order_items,total_price,area));
//        System.out.println("your order has been placed");
//        return new Order(Swiggy.order_id,SelectedRestaurant.name,order_items,total_price,area);
//    }
//    static double getTotalPrice(HashMap<String,Double> order_items){
//        double total = 0;
//        System.out.println("Your Bill!");
//        for(Map.Entry<String,Double> me:order_items.entrySet()){
//            System.out.println(me.getKey()+"\t"+me.getValue());
//            total+=me.getValue();
//        }
//        System.out.println("Total="+total+"\nThankYou!!");
//        return total;
//    }
    void displayCurrentOrders(HashMap<Integer,Order> orders) {
        for(Map.Entry<Integer, Order> me: orders.entrySet()){
        	if(order_numbers.contains(me.getKey())) {
        		Order o = me.getValue();
	            if(!o.delivered){
	                System.out.println(me.getKey()+"."+o);
	            }
        	}
        }
    }

    void reviewDeliveredOrders(HashMap<Integer,Order> orders) {
        for(Map.Entry<Integer, Order> me: orders.entrySet()){
        	if(order_numbers.contains(me.getKey())) {
        		Order o = me.getValue();
	            if(o.delivered){
	                System.out.println(me.getKey()+"."+o);
	            }
        	}
        }
    }

}
