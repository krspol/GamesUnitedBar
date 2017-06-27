package com.fabian.gamesunitedbar.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fabian Polkosnik on 27.06.2017.
 */

public class SqlLiteDb extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "GamesUnited.db";
    private static final String TABLE_NAME = "CART";

    private static final String _ID = "ID";
    private static final String COLUMN_NAME_PRODUCT = "PRODUCT";
    private static final String COLUMN_NAME_AMOUNT = "AMOUNT";

    private static final String SQL_CREATE_CART =
            "CREATE TABLE "+ TABLE_NAME +"(" +
                    _ID + " INTEGER AUTOINCREMENT PRIMARY KEY," +
                    COLUMN_NAME_PRODUCT + " TEXT," +
                    COLUMN_NAME_AMOUNT + " INTEGER" +
                    ");";
    private static final String SQL_DROP_CART =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public SqlLiteDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CART);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DROP_CART);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}