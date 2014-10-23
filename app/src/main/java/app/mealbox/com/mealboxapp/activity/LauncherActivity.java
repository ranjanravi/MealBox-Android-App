package app.mealbox.com.mealboxapp.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.mealbox.com.mealboxapp.R;
import app.mealbox.com.mealboxapp.data.LunchItemListAdapter;
import app.mealbox.com.mealboxapp.data.LunchItemModel;
import app.mealbox.com.mealboxapp.utils.Constants;
import app.mealbox.com.mealboxapp.utils.DataParser;


public class LauncherActivity extends Activity {

    private List<LunchItemModel> lunchItemModelList;

    private AlertDialog errorDialog;



    @Override
    public AssetManager getAssets() {
        return super.getAssets();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        ListView itemList = (ListView) findViewById(R.id.item_list);
        lunchItemModelList = new ArrayList<LunchItemModel>();

        // Getting the JSON data
        String data = DataParser.loadJSONFromAsset(this.getApplicationContext());
        JSONArray menus = null;
        try {
            JSONObject jsonObject = new JSONObject(data);
            menus = jsonObject.getJSONArray(Constants.MEALS);
        } catch (JSONException e) {
            showClosingErrorDialog();
            return;
        }
        if (data == null) {
            //Loading assets failed.
            showClosingErrorDialog();
            return;
        }


        try {

            for (int i = 0; i < menus.length(); i++) {
                JSONObject jsonObject = menus.getJSONObject(i);

                lunchItemModelList.add(i, new LunchItemModel(jsonObject));
            }
        } catch (JSONException e) {
            showClosingErrorDialog();
            //No need to go any further.
            return;
        }


        itemList.setAdapter(new LunchItemListAdapter(this, R.layout.list_item, lunchItemModelList));
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setAction(getString(R.string.detail_page_intent));
                intent.putExtra("item_desc", lunchItemModelList.get(i).getItemContent());
                intent.putExtra("veg", lunchItemModelList.get(i).isVeg());
                intent.setClass(LauncherActivity.this.getApplicationContext(), DetailActivity.class);
                LauncherActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    public void prepareAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                LauncherActivity.this.finish();
            }
        });

        errorDialog = builder.create();
    }

    public void showClosingErrorDialog() {
        if (errorDialog == null) {
            prepareAlertDialog();
        }
        errorDialog.setTitle(getString(R.string.sorry));
        errorDialog.setMessage(getString(R.string.error_close));
        errorDialog.show();
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
