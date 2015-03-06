package android.csulb.edu.zoodirectory;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
            "Bear",
            "King Cobra"
    };

    Integer[] imgid={
            R.mipmap.pic1,
            R.mipmap.pic2,
            R.mipmap.pic3,
            R.mipmap.pic4,
            R.mipmap.pic5,
            R.mipmap.pic6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_listing);
        ListView listView = (ListView) findViewById(R.id.listView);
        CustomListAdapter adapter=new CustomListAdapter(this, animalName, imgid);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view1, int position, long id) {
                final View view = view1;
                if(position == animalName.length-1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            TextView clickedView = (TextView) view.findViewById(R.id.animalText);
                            Intent animalDetailIntent = new Intent(AnimalListing.this, AnimalDetail.class);
                            animalDetailIntent.putExtra("AnimalName",clickedView.getText());
                            startActivity(animalDetailIntent);
                        }
                    });
                    builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(AnimalListing.this, "WISE CHOICE", Toast.LENGTH_SHORT).show();

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }else{
                    TextView clickedView = (TextView) view.findViewById(R.id.animalText);
                    Intent animalDetailIntent = new Intent(AnimalListing.this, AnimalDetail.class);
                    animalDetailIntent.putExtra("AnimalName",clickedView.getText());
                    startActivity(animalDetailIntent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_animal_listing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

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
