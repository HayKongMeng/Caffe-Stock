
package Main;

import java.util.ArrayList;

public class ListDrink_Stock {


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
    private int code;
    private String name,image;
    private double price;

    public ListDrink_Stock(int code, String name, double price, String image) {
        this.code = code;
        this.name = name;
         this.price = price;
        this.image = image;
       
    }
    static ArrayList<ListDrink_Stock> listDrink = new ArrayList<>();
}
