package android.csulb.edu.zoodirectory;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class AnimalListing extends ActionBarActivity {


    String[] animalName ={
            "Lion",
            "Tiger",
            "Panda",
            "Deer",
            "Bear"
    };

    Integer[] imgid={
            R.mipmap.pic1,
            R.mipmap.pic2,
            R.mipmap.pic3,
            R.mipmap.pic4,
            R.mipmap.pic5,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_listing);

        ListView listView = (ListView) findViewById(R.id.listView);
//        listView.setAdapter(new ArrayAdapter<String>(
//                this, R.layout.mylist,
//                R.id.animalName,animalName));

        CustomListAdapter adapter=new CustomListAdapter(this, animalName, imgid);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView clickedView = (TextView) view.findViewById(R.id.animalText);
                Intent animalDetailIntent = new Intent(AnimalListing.this, AnimalDetail.class);
                animalDetailIntent.putExtra("AnimalName",clickedView.getText());
                startActivity(animalDetailIntent);

            }
        });
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
            Intent informationIntent = new Intent(AnimalListing.this, ZooInformation.class);
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
