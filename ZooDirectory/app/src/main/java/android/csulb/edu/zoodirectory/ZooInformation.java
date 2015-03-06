package android.csulb.edu.zoodirectory;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ZooInformation extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_information);
    }

    public void dialerActivity(View view){
        String telNumber = "tel:888-8888";
        Intent telActivity = new Intent(Intent.ACTION_DIAL, Uri.parse(telNumber));
        startActivity(telActivity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animal_listing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.information) {
            Intent informationIntent = new Intent(ZooInformation.this, ZooInformation.class);
            startActivity(informationIntent);
        }

        if(id == R.id.uninstall){
            Uri packageURI = Uri.parse("package:android.csulb.edu.zoodirectory");
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
