package app.mealbox.com.mealboxapp.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import app.mealbox.com.mealboxapp.R;

/**
 * Created by prabhat on 29/1/15.
 */
public class Utilities {
    public  static void callMerchant(Context context) {
        String url = context.getString(R.string.phone_number);
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
        context.startActivity(intent);
    }
}
