package app.mealbox.com.mealboxapp.data;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.TextView;

import java.util.List;

import app.mealbox.com.mealboxapp.R;

/**
 * Created by raviran on 10/14/2014.
 */
public class LunchItemListAdapter extends ArrayAdapter<LunchItemModel>{

    private final Context mContext;
    private final List<LunchItemModel> lunchItemModelList;
    private final int layoutResId;

    public LunchItemListAdapter(Context context, int layoutResId, List<LunchItemModel> lunchItemModelList) {
        super(context, layoutResId, lunchItemModelList);
        this.mContext = context;
        this.layoutResId = layoutResId;
        this.lunchItemModelList = lunchItemModelList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = ((Activity) mContext).getLayoutInflater();
            convertView = layoutInflater.inflate(layoutResId,parent,false);
        }
        LunchItemModel lunchItemModel = lunchItemModelList.get(position);
        ((TextView)convertView.findViewById(R.id.item_description)).setText(lunchItemModel.getTitle());
        ((TextView)convertView.findViewById(R.id.item_sub_description)).setText(lunchItemModel.getShortDescription());

        return convertView;
    }
}
