package app.mealbox.com.mealboxapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import app.mealbox.com.mealboxapp.R;
import app.mealbox.com.mealboxapp.data.LunchItemListAdapter;
import app.mealbox.com.mealboxapp.data.LunchItemModel;


public class LauncherActivity extends Activity {

    private List<LunchItemModel> lunchItemModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ListView itemList = (ListView)findViewById(R.id.item_list);
        lunchItemModelList = new ArrayList<LunchItemModel>();
        String data = loadJSONFromAsset();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(data);

        for (int i = 0; i <jsonArray.length() ; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            lunchItemModelList.add(i,new LunchItemModel(jsonObject.getString("itemTitle"),jsonObject.getString("itemShortDesc"),
                    jsonObject.getString("itemDescription"), jsonObject.getBoolean("veg")));
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        itemList.setAdapter(new LunchItemListAdapter(this, R.layout.list_item, lunchItemModelList));
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent  = new Intent();
                intent.setAction("com.mealboxapp.detail");
                intent.putExtra("item_desc", lunchItemModelList.get(i).getDetailedDescription());
                intent.putExtra("veg",lunchItemModelList.get(i).isVeg());
                intent.setClass(LauncherActivity.this.getApplicationContext(), DetailActivity.class);
                LauncherActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("data.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.launcher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
