package app.mealbox.com.mealboxapp.data;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.mealbox.com.mealboxapp.R;

/**
 * Created by raviran on 10/14/2014.
 */
public class LunchItemListAdapter extends ArrayAdapter<LunchItemModel>{

    private final Context mContext;
    private final List<LunchItemModel> lunchItemModelList;
    private final int layoutResId;

    private static HashMap<String, Integer> backgrounds = new HashMap<String, Integer>() ;
    {
        backgrounds.put("Veg Meal", R.drawable.veg_thali);
        backgrounds.put("Special Veg Meal", R.drawable.veg_thali);
        backgrounds.put("Egg Meal", R.drawable.chicken_biryani);
        backgrounds.put("Chicken Meal", R.drawable.non_veg_thali);
    }


    public LunchItemListAdapter(Context context, int layoutResId, List<LunchItemModel> lunchItemModelList) {
        super(context, layoutResId, lunchItemModelList);
        this.mContext = context;
        this.layoutResId = layoutResId;
        this.lunchItemModelList = lunchItemModelList;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = ((Activity) mContext).getLayoutInflater();
            convertView = layoutInflater.inflate(layoutResId,parent,false);
        }
        LunchItemModel lunchItemModel = lunchItemModelList.get(position);

        ((LinearLayout)convertView.findViewById(R.id.list_item)).setBackground(
                mContext.getResources().getDrawable(backgrounds.get(lunchItemModel.getTitle())));

        ((TextView)convertView.findViewById(R.id.item_sub_description)).setText(lunchItemModel.getShortDescription());
        int price = (int) lunchItemModel.getItemPrice();
        ((TextView)convertView.findViewById(R.id.price)).setText(new Integer(price).toString());

        return convertView;
    }
}
