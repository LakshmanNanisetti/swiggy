/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swiggy;

/**
 *
 * @author Administrator
 */
public class FoodItem{
    String name;
    double price;
    int quantity;
    public FoodItem(String name,double price){
        this.name = name;
        this.price = price;
        quantity=1;
    }
    @Override
    public String toString(){
        return (name+"\t"+price);
    }
}
