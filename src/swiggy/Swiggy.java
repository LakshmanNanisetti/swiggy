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
public class Swiggy {
    /**
     * @param args the command line arguments
     */
    //I will be adding database support here
    public static int order_id=0;
    public static int next_res_id=11;
    public static void addCustomers(HashMap<String,Customer> customers){
        customers.put("9444761040",new Customer("Lakshman","9444761040","AshokNagar","password"));
        customers.put("7010123377",new Customer("Sumanth","7010123377","MadhuraNagar","password"));
        customers.put("7123456890",new Customer("Tharun","7123456890","GandhiNagar","password"));
        customers.put("9944581804",new Customer("Pavan","9944581804","AshokNagar","password"));
        customers.put("7123456789",new Customer("Kishore","7123456789","GandhiNagar","password"));
        customers.put("1234567890",new Customer("Santhosh","1234567890","Guduvanchery","password"));
        customers.put("1234554321",new Customer("Shushmanth","1234554321","Adyar","password"));
        customers.put("6789012345",new Customer("Harithash","6789012345","Guduvanchery","password"));
        customers.put("1236745890",new Customer("Shanmukh","1236745890","Adyar","password"));
        customers.put("5676123654",new Customer("Rohith","5676123654","MadhuraNagar","password"));
    }
    public static void registerCustomer(HashMap<String,Customer> customers) {
    	Scanner sc = new Scanner(System.in);
    	Customer c = new Customer();
    	System.out.println("enter name:");
    	c.name=sc.next();
    	System.out.println("enter mobile:");
    	c.mobile = sc.next();
    	System.out.println("enter area:");
    	c.area = sc.next();
    	System.out.println("enter password:");
    	c.password = sc.next();
    	customers.put(c.mobile, c);
    }
    public static HashMap<Integer,Restaurant> registerRestaurant(HashMap<Integer,Restaurant> restaurants,ArrayList<String> areas){
        Scanner sc = new Scanner(System.in);
    	Restaurant r = new Restaurant();
    	System.out.println("enter name:");
    	r.name=sc.next();
    	System.out.println("enter area:");
    	r.area = sc.next();
    	System.out.println("enter password:");
    	r.password = sc.next();
    	restaurants.put(next_res_id,r);
        next_res_id++;
//        for(Map.Entry<Integer,Restaurant> me:restaurants.entrySet()){
//            System.out.println(me.getKey()+"."+me.getValue());
//        }
        System.out.println(next_res_id-1+"."+restaurants.get(next_res_id-1));
        System.out.println("Login using you id-"+(next_res_id-1)+" and password");
        if(!areas.contains(r.area)){
            areas.add(r.area);
        }
        return restaurants;
    }
    public static void addRestaurants(HashMap<Integer,Restaurant> restaurants){
        restaurants.put(1,new Restaurant("KFC","AshokNagar" ));
        restaurants.put(2,new Restaurant("Paradise","GandhiNagar" ));
        restaurants.put(3,new Restaurant("Dominos","AshokNagar" ));
        restaurants.put(4,new Restaurant("KFC","Guduvanchery" ));
        restaurants.put(5,new Restaurant("PizzaHut", "AshokNagar" ));
        restaurants.put(6,new Restaurant("KFC", "MadhuraNagar" ));
        restaurants.put(7,new Restaurant("Paradise", "Guduvanchery" ));
        restaurants.put(8,new Restaurant("KFC", "Adyar" ));
        restaurants.put(9,new Restaurant("KFC", "GandhiNagar" ));
        restaurants.put(10,new Restaurant("Dominos", "Adyar" ));
        Restaurant.next=10;
    }
    public static void addOwners(HashMap<String,Owner> owners){
        owners.put("8332816091",new Owner("Shankar","8332816091","AshokNagar","password"));
        owners.put("9441754791",new Owner("Ranga","9441754791","MadhuraNagar","password"));
    }
    private static void displayCustomers(HashMap<String, Customer> customers) {
        for(Map.Entry<String,Customer> me:customers.entrySet()){
            System.out.println(me.getValue());
        }
    }
    public static void displayRestaurants(HashMap<Integer,Restaurant> restaurants,String area){
        for(int i=1;i<next_res_id;i++){
            if(restaurants.get(i).area.equals(area)){
                System.out.println(i+"."+restaurants.get(i));
            }
        }
    }
    public static void displayBoys(HashMap<String,DeliveryBoy> boys){
        for(Map.Entry<String,DeliveryBoy> me: boys.entrySet()){
            System.out.println(me.getValue());
        }
    }
    public static void displayAreas(ArrayList<String> areas,ArrayList<String> boy_areas){
        for(String area:areas){
            if(boy_areas.contains(area))
                System.out.println(area);
        }
    }
    private static Customer login(HashMap<String,Customer> customers) {
        Scanner sc = new Scanner(System.in);
        String stored_password="";
        String password="";
        Customer c;
        boolean correct_mobile=true;
        do{
            if(!correct_mobile)
                System.out.println("Mobile number or password is wrong!");
            System.out.println("Please enter your mobile number:");
            String mobile = sc.next();
            System.out.println("Please enter your Password");
            password = sc.next();
            c = customers.get(mobile);
            if(c!=null){
                stored_password = c.getPassword();
            }
            correct_mobile=false;
        }while(c==null||!password.equals(stored_password));
        System.out.println("Loggin you in..");
        return c;
    }
    public static void initializeBoyAreas(HashMap<String,DeliveryBoy> boys,ArrayList<String> boy_areas){
        for(Map.Entry<String,DeliveryBoy> me:boys.entrySet()){
            if(!boy_areas.contains(me.getValue().area)){
                boy_areas.add(me.getValue().area);
            }
        }
    }
    public static void initializeAreas(HashMap<Integer,Restaurant> restaurants,ArrayList<String> areas){
//        System.out.println("adding areas");
        for(int i=1;i<=Restaurant.next;i++){
            if(areas.indexOf(restaurants.get(i).area)==-1){
//                System.out.println(restaurants.get(i).area);
                areas.add(restaurants.get(i).area);
            }
        }
    }
    public static ArrayList<Integer> getRestaurantIndeces(HashMap<Integer,Restaurant> restaurants,String area){
        ArrayList<Integer> indeces = new ArrayList<>();
        for(int i=1;i<next_res_id;i++){
            if(restaurants.get(i).area.equals(area)){
                indeces.add(i);
            }
        }
        return indeces;
    }
    public static boolean getPayment(Customer user,double price){
        Scanner sc = new Scanner(System.in);
//        System.out.println("order total is:"+price);
        System.out.println("enter your wallet id and pin");
        sc.next();
        return true;
    }
    public static void addBoys(HashMap<String,DeliveryBoy> boys){
        boys.put("9798454501",new DeliveryBoy("Tharun","9798454501","AshokNagar","password"));
        boys.put("9988776655", new DeliveryBoy("Raj","9988776655","GandhiNagar","password"));
        boys.put("8985727103",new DeliveryBoy("Harithash","8985727103","Adyar","password"));
        boys.put("1234567890",new DeliveryBoy("Veerendra","1234567890","Guduvanchery","password"));
        boys.put("0987654321",new DeliveryBoy("Pavan","0987654321","MadhuraNagar","password"));
    }
    public static void registerBoy(HashMap<String,DeliveryBoy> boys) {
    	Scanner sc = new Scanner(System.in);
    	DeliveryBoy b = new DeliveryBoy();
    	System.out.println("enter name:");
    	b.name=sc.next();
    	System.out.println("enter mobile:");
    	b.mobile = sc.next();
    	System.out.println("enter area:");
    	b.area = sc.next();
    	System.out.println("enter password:");
    	b.password = sc.next();
        boys.put(b.mobile, b);
    }
    public static void deliveryBoyOption(HashMap<String,DeliveryBoy> boys,HashMap<Integer,Order> orders){
    	String option;
    	Scanner sc = new Scanner(System.in);
        DeliveryBoy boy = boyLogin(boys);
    	do {
    		System.out.println("Select your option:\n1.Show Deliveries\n2.Logout\n3.change password");
    		option = sc.next();
    		switch(option) {
    		case "1":
                    ArrayList<Integer> order_indeces = showOrders(boy,orders);
                    int ordno;
                    boolean loop=true;
                    do {
                    System.out.println("select an order or -1 to exit");
                    ordno = sc.nextInt();
                    if(ordno==-1){
                        loop=false;
                    }
                    if(boy.order_numbers.contains(ordno)){
                        loop=false;
                    }
                    }while(loop);
                    if(ordno!=-1)
                    {orders.get(ordno).delivered=true;
                    /*codddddddddddddddeeeeeeeeeeeeeee*/
                        boys.get(boy.mobile).order_numbers.remove(new Integer(ordno));}
                    break;
                case "2":
                    System.out.println("Logging out!");
                    break;
                case "3":
                    System.out.println("enter your new password:");
                    String new_password = sc.next();
                    boys.get(boy.mobile).setPassword(new_password);
                    break;
                default:
                    System.out.println("Please enter a valid input!");
    		}
    	}while(!option.equals("2"));
    }
    public static int ownerLogin(HashMap<Integer,Restaurant> restaurants){
        Scanner sc = new Scanner(System.in);
        String stored_password="";
        String password="";
        boolean correct_mobile=true;
        int id;
        do{
            if(!correct_mobile)
                System.out.println("ID number or password is wrong!");
            System.out.println("Please enter your Restaurant ID:");
            id = sc.nextInt();
            System.out.println("Please enter your Password");
            password = sc.next();
            if(id<=restaurants.size()){
                stored_password = restaurants.get(id).getPassword();
            }
            correct_mobile=false;
        }while(id>restaurants.size()||!password.equals(stored_password));
        System.out.println("Loggin you in..");
        return id;
    }
    public static void ownerOption(HashMap<Integer,Restaurant> restaurants){
        Scanner sc = new Scanner(System.in);
        int res_id = ownerLogin(restaurants);
        String owner_option="-1";
        System.out.println(restaurants.get(res_id).name);
        int category;
        do{
            System.out.println("1.addItem\n2.removeItem\n3.showitems\n4.Logout");
            owner_option=sc.next();
            switch(owner_option){
                case "1":
                    System.out.println("enter name of the item");
                    String item_name=sc.next();
                    System.out.println("select the category:\n1.Non-Veg\n2.Veg");
                    category = sc.nextInt();
                    Double item_price = sc.nextDouble();
                    restaurants.get(res_id).addItem(item_name,item_price,category);
                    break;
                case "2":
                    String rm_name;
                    do{
                    System.out.println("enter name of the item");
                    rm_name=sc.next();
                    System.out.println("select the category:\n1.Non-Veg\n2.Veg");
                    category = sc.nextInt();
                    }while(!restaurants.get(res_id).food_items.containsKey(rm_name));
                    restaurants.get(res_id).removeItem(rm_name,category);
                    break;
                case "3":
                    restaurants.get(res_id).displayFoodItems();
                    break;
                case "4":
                    System.out.println("Logging out!");
                    break;
                case "5":
                    System.out.println("Please enter the new password");
                    String new_password = sc.next();
                    restaurants.get(res_id).setPassword(new_password);
                default:
                    System.out.println("Please enter a valid input!");
            }
        }while(!owner_option.equals("4"));
    }
    public static ArrayList<Integer> showOrders(DeliveryBoy boy,HashMap<Integer,Order> orders) {
    	ArrayList<Integer> order_indeces = new ArrayList<>();
        System.out.println(boy.order_numbers.size()+" orders left.");
        for(int i:boy.order_numbers){
            if(!orders.get(i).delivered)
            System.out.println(i+"."+orders.get(i));
        }
//    	for(Map.Entry<Integer, Order> me: orders.entrySet()) {
//    		Order o= me.getValue();
//    		if(o.area.equals(area)&&!o.delivered&&) {
//    			System.out.println(me.getKey()+"."+o);
//    			order_indeces.add(me.getKey());
//    		}
//    	}
    	return order_indeces;
    }
    public static Order orderFood(Customer user,ArrayList<String> areas,HashMap<Integer,Restaurant> restaurants,ArrayList<String> boy_areas) {
        Scanner sc = new Scanner(System.in);
        String area="";
        do{
        if(area.equals(""))
            System.out.println("Please Enter your area");
        else
            System.out.println("Sorry Our Service is not provide there\nPlease selct a valid area");
        Swiggy.displayAreas(areas,boy_areas);
        area = sc.next();
        }while(areas.indexOf(area)==-1);
        int restaurant_index;
        ArrayList<Integer> restaurant_indeces = new ArrayList<>();
        do{
            System.out.println("Please Select Any Restaurant");
            restaurant_indeces = Swiggy.getRestaurantIndeces(restaurants,area);
            Swiggy.displayRestaurants(restaurants,area);
            restaurant_index = sc.nextInt();
        }while(!restaurant_indeces.contains(restaurant_index));
//        boolean order=false;
        Restaurant SelectedRestaurant = restaurants.get(restaurant_index);
        SelectedRestaurant.displayFoodItems();
        String food_option="";
        HashMap<String,Double> order_items = new HashMap<>();
        HashMap<String,Integer> order_quants = new HashMap<>();
        do{
            System.out.println("Input -1 to stop input:");
            food_option=sc.next();
            if(SelectedRestaurant.food_items.get(food_option)!=null){
                order_items.put(food_option,SelectedRestaurant.food_items.get(food_option));
                System.out.println("enter quantity:");
                int q = sc.nextInt();
                order_quants.put(food_option,q);
            }
            else{
                System.out.println("Sorry we provide only the before mentioned food items");
            }
        }while(!food_option.equals("-1"));
        double total_price = getTotalPrice(order_items,order_quants);
        Swiggy.getPayment(user,total_price);                            
        
//        user.orders.add(new Order(SelectedRestaurant.name,order_items,total_price,area));
//        ++(Swiggy.order_id);
        System.out.println("your order has been placed");
        return new Order(SelectedRestaurant.name,order_items,order_quants,total_price,area);
    }
    static double getTotalPrice(HashMap<String,Double> order_items,HashMap<String,Integer> order_quants){
        double total = 0;
        System.out.println("Your Bill!");
        for(Map.Entry<String,Double> me:order_items.entrySet()){
            System.out.println(me.getKey()+"\t"+me.getValue()+"\t"+order_quants.get(me.getKey()));
            total+=me.getValue()*order_quants.get(me.getKey());
        }
        System.out.println("Total="+total+"\nThankYou!!");
        return total;
    }
    public static DeliveryBoy boyLogin(HashMap<String,DeliveryBoy> boys) {
    	Scanner sc = new Scanner(System.in);
        String stored_password="";
        String password="";
        DeliveryBoy b;
        boolean correct_mobile=true;
        do{
            if(!correct_mobile)
                System.out.println("Mobile number or password is wrong!");
            System.out.println("Please enter your mobile number:");
            String mobile = sc.next();
            System.out.println("Please enter your Password");
            password = sc.next();
            b = boys.get(mobile);
            if(b!=null){
                stored_password = b.getPassword();
            }
            correct_mobile=false;
        }while(b==null||!password.equals(stored_password));
        System.out.println("Loggin you in..");
        return b;
    }
    public static void assignOrder(HashMap<String,DeliveryBoy> boys,HashMap<Integer,Order> orders,int order_id){
        String area = orders.get(order_id).area;
        ArrayList<String> boy_numbers = new ArrayList<>();
        for(Map.Entry<String,DeliveryBoy> boy:boys.entrySet()){
            if(boy.getValue().area.equals(area)){
                boy_numbers.add(boy.getKey());
            }
        }
        String our_guy ="";
        int min = 1000;
        for(String boy_no:boy_numbers){
                if(boys.get(boy_no).order_numbers.size()<=min){
                    min=boys.get(boy_no).order_numbers.size();
                    our_guy = boy_no;
                }

        }
        boys.get(our_guy).order_numbers.add(order_id);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        HashMap<String,Owner> owners = new HashMap<>();
        addOwners(owners);
        HashMap<String,Customer> customers = new HashMap<>();
        addCustomers(customers);
        HashMap<Integer,Restaurant> restaurants = new HashMap<>();
        addRestaurants(restaurants);
        HashMap<String,DeliveryBoy> boys = new HashMap<>();
        addBoys(boys);
        HashMap<Integer,Order> orders = new HashMap<>();
        String option="";
        String login_type;
        Customer user;
        boolean valid=true;
        ArrayList<String> areas = new ArrayList<>();
        ArrayList<String> boy_areas = new ArrayList<>();
        initializeAreas(restaurants,areas);
        initializeBoyAreas(boys,boy_areas);
        while(!option.equals("5")){
            System.out.println("Please select any of the following options:");
            System.out.println("1.Login\n2.Register\n3.Show Users\n4.Show Boys\n5.exit");
            valid=true;
            option=sc.next(); 
            switch(option){
                case "1":  
                    do{
                        System.out.println("1.Customer\n2.Delivery Boy\n3.Restaurant Manager\n4.exit");
                        login_type = sc.next();
                        switch(login_type){
                        case "1":
                            
                            user = login(customers);
                            String login_option="";
                            do{
                                System.out.println("1.Order Food\n2.Track Current Orders\n3.Review Delivered Orders\n4.Change Password\n5.Logout");
                                login_option=sc.next();
                                switch(login_option){
                                    case "1":
                                        orders.put(++order_id,orderFood(user,areas,restaurants,boy_areas));
                                        user.order_numbers.add(order_id);
                                        assignOrder(boys,orders,order_id);
                                        break;
                                    case "2":
                                        user.displayCurrentOrders(orders);
                                        break;
                                    case "3":
                                        user.reviewDeliveredOrders(orders);
                                        break;
                                    case "4":
                                        System.out.println("enter new Password:");
                                        String str = sc.next();
                                        user.setPassword(str);
                                        break;
                                    case "5":
                                        System.out.println("Logging out");
                                        break;
                                    default:
                                        System.out.println("Please enter a valid input");
                                }
                            }while(!login_option.equals("5"));
                            
                            break;
                        case "2":
                            
                            deliveryBoyOption(boys,orders);
//                            System.out.println("Not Yet!!!");
                            break;
                        case "3":
                            //RestaurantOwner
                            ownerOption(restaurants);
//                            System.out.println("Not Yet!!!");
                            break;
                        case "4":
                            System.out.println("Exiting!!!");
                            break;
                        default:
                            System.out.println("please enter a valid input!");
                        }
                        
                    }while(!login_type.equals("4"));
                    break;
                case "2":
                    //User Registration
                	System.out.println("Enter your option:\n1.Customer\n2.DeliveryBoy\n3.RestaurantOwner\n4.exit");
                	int register_option= sc.nextInt();
                	switch(register_option) {
                	case 1:
                            registerCustomer(customers);
                            break;
                	case 2:
                            registerBoy(boys);
                            initializeBoyAreas(boys,boy_areas);
                            break;
                        case 3:
                            restaurants = registerRestaurant(restaurants,areas);
                            initializeAreas(restaurants,areas);
                            break;
                        case 4:
                            System.out.println("exiting registration!");
                	}
//                    System.out.println("Registrations Not yet");
                    break;
                case "3":
                    displayCustomers(customers);
                    break;
                case "4":
                	displayBoys(boys);
                        break;
                case "5":
                    System.out.println("Thank you for using our application");
                    break;
                default:
                    System.out.println("Please Enter a valid input");
                    break;
            }    
        }
    }   
}
