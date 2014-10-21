package app.mealbox.com.mealboxapp.data;

/**
 * Created by prabhat on 19/10/14.
 */
public class LunchItemExtra {

    private String itemName;
    private float quantity;
    private float price;

    public LunchItemExtra(String itemName, Float quantity, Float price){
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
