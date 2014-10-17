package app.mealbox.com.mealboxapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import app.mealbox.com.mealboxapp.R;

/**
 * Created by raviran on 10/14/2014.
 */
public class DetailActivity extends Activity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.detail_page);
            TextView textView = (TextView)findViewById(R.id.lunch_detail);
            textView.setText(getIntent().getStringExtra("item_desc"));
        }

        public void onCallButtonClick(View v){
            String url = getString(R.string.phone_number);
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
            startActivity(intent);
        }
//        @Override
//        public void onBackPressed(){
//            this.finish();
//            overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);
//        }
}
