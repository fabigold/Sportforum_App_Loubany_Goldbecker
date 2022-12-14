package com.test.sqliteuebung;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ShoppingMemoDbHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = ShoppingMemoDbHelper.class.getSimpleName(); // LOG_TAG is a constant, so it should be written in capital letters

    public static final String DB_NAME = "shopping_list.db"; // Name of the database
    public static final int DB_VERSION = 1; // Version of the database (should be incremented if the database structure changes)

    public static final String TABLE_SHOPPING_LIST = "shopping_list";  // Name of the table

    public static final String COLUMN_ID = "_id"; // Name of the column, _id is the default name for the primary key
    public static final String COLUMN_PRODUCT = "product";
    public static final String COLUMN_QUANTITY = "quantity";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_SHOPPING_LIST +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + // AUTOINCREMENT is a keyword that tells the database to automatically increment the value of the column
                    COLUMN_PRODUCT + " TEXT NOT NULL, " +
                    COLUMN_QUANTITY + " INTEGER NOT NULL);"; // SQL statement to create the table



    public ShoppingMemoDbHelper(Context context) {
       // super(context, "DATABASE_NAME", null, 1);
        super(context, DB_NAME, null, DB_VERSION); // Call the constructor of the parent class, CursorFactory is null
        Log.d(LOG_TAG, "DbHelper has created the database: " + getDatabaseName() + ".");
        // by calling the super constructor, the database is created and data is stored in the file "shopping_list.db"
    }

    // This method is called when the database is created for the first time (when the database file does not exist yet)
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {  // The database is passed as a parameter
        try {
            Log.d(LOG_TAG, "The table is being created with the following SQL statement: " + SQL_CREATE); // Log the SQL statement
            sqLiteDatabase.execSQL(SQL_CREATE); // Execute the SQL statement with execSQL()
        }
        catch (Exception ex) {
            Log.e(LOG_TAG, "Error creating table: " + ex.getMessage()); // Log the error message
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
