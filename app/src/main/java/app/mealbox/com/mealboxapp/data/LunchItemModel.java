package app.mealbox.com.mealboxapp.data;

/**
 * Created by raviran on 10/14/2014.
 */
public class LunchItemModel {

    private String title;
    private String miniDescription;
    private String detailedDescription;
    private boolean veg;

    public LunchItemModel(String title, String miniDescription, String detailedDescription, boolean veg) {
        this.title = title;
        this.miniDescription = miniDescription;
        this.detailedDescription = detailedDescription;
        this.veg = veg;
    }

    public String getTitle(){
        return this.title;
    }

    public String getMiniDescription(){
        return this.miniDescription;
    }

    public String getDetailedDescription(){
        return this.detailedDescription;
    }

    public boolean isVeg(){
        return this.veg;
    }
}
