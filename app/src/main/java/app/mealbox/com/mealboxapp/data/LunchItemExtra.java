package app.mealbox.com.mealboxapp.data;

import org.json.JSONException;
import org.json.JSONObject;

import app.mealbox.com.mealboxapp.utils.Constants;

/**
 * Created by prabhat on 19/10/14.
 */
public class LunchItemExtra {

    private double quantity;
    private double price;
    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public LunchItemExtra(JSONObject jsonObject) throws JSONException{
        this.itemName = jsonObject.getString(Constants.ITEM_NAME);
        this.quantity = jsonObject.getDouble(Constants.QUANTITY);
        this.price = jsonObject.getDouble(Constants.PRICE);
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
