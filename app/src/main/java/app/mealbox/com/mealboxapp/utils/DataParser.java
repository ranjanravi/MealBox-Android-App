package app.mealbox.com.mealboxapp.utils;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import app.mealbox.com.mealboxapp.R;

/**
 * Created by prabhat on 19/10/14.
 */
public class DataParser {
    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try {

            InputStream is = context.getAssets().open(context.getString(R.string.input_data_json));

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, context.getString(R.string.formatting));


        } catch (IOException ex) {
            return null;
        }
        return json;

    }
}
