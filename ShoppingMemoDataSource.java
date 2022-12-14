package com.test.sqliteuebung;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ShoppingMemoDataSource {

    private static final String LOG_TAG = ShoppingMemoDataSource.class.getSimpleName(); // class.getSimpleName() returns the name of the class without the package name (e.g. ShoppingMemoDataSource)

    private SQLiteDatabase database; // The database is stored in this variable (it is not a constant, so it should not be written in capital letters)
    private ShoppingMemoDbHelper dbHelper; // The database helper is stored in this variable (the database helper is used to create the database)

    public ShoppingMemoDataSource(Context context) { // The context is passed as a parameter to the constructor of the data source
        Log.d(LOG_TAG, "Our DataSource creates the dbHelper.");
        dbHelper = new ShoppingMemoDbHelper(context); // Create a new dbHelper object and pass the context as a parameter
    }

    public void open() {
        Log.d(LOG_TAG, "A writable database connection is being opened."); // Log the SQL statement
        database = dbHelper.getWritableDatabase();  // Open a writable database connection with getWritableDatabase()
        Log.d(LOG_TAG, "Database connection opened. Path to database: " + database.getPath()); // Log the path to the database
    }

    public void close() {
        dbHelper.close(); // Close the database connection with close()
        Log.d(LOG_TAG, "Database connection closed."); // Log the SQL statement
    }
}
