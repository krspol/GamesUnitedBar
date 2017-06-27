package com.fabian.gamesunitedbar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fabian.gamesunitedbar.data.SqlLiteDb;

import java.util.ArrayList;
import java.util.List;


public class CheckoutActivity extends AppCompatActivity {

    private TextView checkoutText;
    private SqlLiteDb sqlLiteDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        sqlLiteDb = new SqlLiteDb(getApplicationContext());
        SQLiteDatabase _db = sqlLiteDb.getReadableDatabase();

        Cursor cursor = getAll(_db);

        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(SqlLiteDb._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(SqlLiteDb.COLUMN_NAME_PRODUCT));
            int amount = cursor.getInt(cursor.getColumnIndexOrThrow(SqlLiteDb.COLUMN_NAME_AMOUNT));
            double price = cursor.getDouble(cursor.getColumnIndexOrThrow(SqlLiteDb.COLUMN_NAME_PRICE));

            itemIds.add("id: " + itemId + "\t name: " + name + "\t amount: " + amount + "\t price: " + price);
        }
        cursor.close();


        checkoutText = (TextView) findViewById(R.id.checkout_list);
        checkoutText.setText(itemIds.toString());
    }

    private Cursor getAll(SQLiteDatabase _db){
        String[] projection = {
                SqlLiteDb._ID,
                SqlLiteDb.COLUMN_NAME_PRODUCT,
                SqlLiteDb.COLUMN_NAME_AMOUNT,
                SqlLiteDb.COLUMN_NAME_PRICE
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

        return cursor;
    }

    private void clearTable(SQLiteDatabase _db){
        _db.delete(SqlLiteDb.TABLE_NAME, null, null);
    }
}
