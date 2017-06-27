package com.fabian.gamesunitedbar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fabian.gamesunitedbar.data.SqlLiteDb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CheckoutActivity extends AppCompatActivity {

    private TextView checkoutText;
    private SqlLiteDb sqlLiteDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        sqlLiteDb = new SqlLiteDb(getApplicationContext());
        SQLiteDatabase _db = sqlLiteDb.getReadableDatabase();

        String[] projection = {
                SqlLiteDb._ID,
                SqlLiteDb.COLUMN_NAME_PRODUCT,
                SqlLiteDb.COLUMN_NAME_AMOUNT
        };

        Cursor cursor = _db.query(
                SqlLiteDb.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(SqlLiteDb._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(SqlLiteDb.COLUMN_NAME_PRODUCT));
            int amount = cursor.getInt(cursor.getColumnIndexOrThrow(SqlLiteDb.COLUMN_NAME_AMOUNT));
            itemIds.add(itemId + " " + name + " " + amount);
        }
        cursor.close();


        checkoutText = (TextView) findViewById(R.id.checkout_list);
        checkoutText.setText(itemIds.toString());
    }

    private String getProducts(){
        // TODO get cart from SQLLite

        return null;
    }
}
