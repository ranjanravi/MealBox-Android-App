package app.mealbox.com.mealboxapp.data;

import android.view.MenuItem;

import org.json.JSONException;
import org.json.JSONObject;

import app.mealbox.com.mealboxapp.utils.Constants;

/**
 * Created by raviran on 10/14/2014.
 */
public class LunchItemModel {

    private String title;
    private String shortDescription;
    private String itemContent;
    private boolean veg;
    private float itemPrice;

//    private LunchItemExtra lunchItemExtra;

    public LunchItemModel(JSONObject jsonObject) throws JSONException  {

        this.title = jsonObject.getString(Constants.ITEM_TITLE);
        this.shortDescription = jsonObject.getString(Constants.ITEM_SHORT_DESC);
        this.itemContent = jsonObject.getString(Constants.ITEM_CONTENT);
        this.veg = jsonObject.getBoolean(Constants.VEG);
//        this.lunchItemExtra = new LunchItemExtra(jsonObject.getJSONObject("extras"));
    }

    public String getTitle() {
        return this.title;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public String getItemContent() {
        return this.itemContent;
    }

    public boolean isVeg() {
        return this.veg;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

//    public LunchItemExtra getLunchItemExtra() {
//        return lunchItemExtra;
//    }

//    public void setLunchItemExtra(LunchItemExtra lunchItemExtra) {
//        this.lunchItemExtra = lunchItemExtra;
//    }

}
