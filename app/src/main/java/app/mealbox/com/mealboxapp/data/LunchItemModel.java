package app.mealbox.com.mealboxapp.data;

/**
 * Created by raviran on 10/14/2014.
 */
public class LunchItemModel {

    private String title;
    private String shortDescription;
    private String itemContent;
    private boolean veg;
    private float itemPrice;

    private LunchItemExtra lunchItemExtra;

    public LunchItemModel(String title, String shortDescription, String itemContent, boolean veg, LunchItemExtra lunchItemExtra) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.itemContent = itemContent;
        this.veg = veg;
        this.lunchItemExtra = lunchItemExtra;
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

    public LunchItemExtra getLunchItemExtra() {
        return lunchItemExtra;
    }

    public void setLunchItemExtra(LunchItemExtra lunchItemExtra) {
        this.lunchItemExtra = lunchItemExtra;
    }

}
