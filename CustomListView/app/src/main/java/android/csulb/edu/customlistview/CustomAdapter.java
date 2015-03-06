package android.csulb.edu.customlistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by VIRAL on 2/16/2015.
 */
public class CustomAdapter extends ArrayAdapter<Person> {
    private final List<Person> personList;

    public CustomAdapter(Context context, int resource, List<Person> personList) {
        super(context, resource, personList);
        this.personList = personList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.custom_row, null);

        TextView textView = (TextView) row.findViewById(R.id.rowText);
        textView.setText(personList.get(position).getName());

        try {
            ImageView imageView = (ImageView) row.findViewById(R.id.rowImage);
            InputStream inputStream = getContext().getAssets().open(personList.get(position).getImgAddress());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
//            imageView.setImageURI(Uri.parse(personList.get(position).getImgAddress()));
//            imageView.setImageResource(R.id.);
        }catch (Exception e){
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<< "+e+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        return row;
    }
}
