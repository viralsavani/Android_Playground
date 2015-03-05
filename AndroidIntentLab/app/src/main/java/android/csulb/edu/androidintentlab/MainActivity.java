package android.csulb.edu.androidintentlab;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void takeAction(View view){
        switch (view.getId()){
            case R.id.browserButton:
                String webPage = "http://www.amazon.com";
                Intent browserActivity = new Intent(Intent.ACTION_VIEW,Uri.parse(webPage));
                startActivity(browserActivity);
                break;

            case R.id.teleButton:
                String telNumber = "tel:562-288-2098";
                Intent telActivity = new Intent(Intent.ACTION_DIAL, Uri.parse(telNumber));
                startActivity(telActivity);
                break;
        }
    }
}
