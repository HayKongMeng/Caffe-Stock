package Main;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class ListDrink_Order {

    private DecimalFormat df = new DecimalFormat("###0.00");
    public double getAmount() {
        return amount;
    }

    public int getQty() {
        return qty;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }
    private int code,qty;
    private String name,image;
    private double price;
    private double amount;

    public ListDrink_Order(int code, String name, double price, String image,int qty,double amount) {
        this.code = code;
        this.name = name;
        this.image = image;
        this.price = price;
        this.qty=qty;
        this.amount=amount;
    }
    
    static ArrayList<ListDrink_Order> listOrder = new ArrayList<>();
}
