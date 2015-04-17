package android.csulb.edu.lab9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VIRAL on 4/16/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "spinnerDB";

    private static final String TABLE_NAME = "labels";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    // Create table query string
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT)";

    // Drop table query string
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    /**
     * Database insertion method for inserting new labels in
     * database.
     */
    public void insertLabel(String label){ SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, label);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    /**
     * Database retrieval method for retrieving all
     * the labels from database
     */
    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return labels;
    }
}
