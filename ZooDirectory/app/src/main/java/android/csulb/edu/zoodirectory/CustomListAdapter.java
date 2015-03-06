package android.csulb.edu.zoodirectory;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by VIRAL on 3/5/2015.
 */
public class CustomListAdapter  extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] animalName;
    private final Integer[] imgid;

    public CustomListAdapter(Activity context, String[] animalName, Integer[] imgid) {
        super(context, R.layout.mylist, animalName);
        this.context = context;
        this.animalName = animalName;
        this.imgid = imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.animalText);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.animalImage);


        txtTitle.setText(animalName[position]);
        imageView.setImageResource(imgid[position]);

        return rowView;

    };


}
