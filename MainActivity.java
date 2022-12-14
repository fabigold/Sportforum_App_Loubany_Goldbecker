package com.test.sqliteuebung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    private ShoppingMemoDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // The onCreate() method is called when the activity is created
        super.onCreate(savedInstanceState); // Call the onCreate() method of the superclass
        setContentView(R.layout.activity_main); // Set the content view to the layout file activity_main.xml

        ShoppingMemo testMemo = new ShoppingMemo("pears", 5, 102); // Create a new ShoppingMemo object with the constructor of the class ShoppingMemo
        Log.d(LOG_TAG, "Content of testMemo: " + testMemo.toString()); // Log the content of the ShoppingMemo object

        dataSource = new ShoppingMemoDataSource(this); // Create a new ShoppingMemoDataSource object with the constructor of the class ShoppingMemoDataSource
        Log.d(LOG_TAG, "DataSource is opened.");
        dataSource.open(); // Open the database connection with the open() method of the class ShoppingMemoDataSource

        Log.d(LOG_TAG, "DataSource is closed.");
        dataSource.close(); // Close the database connection with the close() method of the class ShoppingMemoDataSource
    }
}

// 6330-6330/com.test.sqliteuebung D/MainActivity: Content of testMemo: 5xpears
// 6330-6330/com.test.sqliteuebung D/ShoppingMemoDataSource: Our DataSource creates the dbHelper.
// 6330-6330/com.test.sqliteuebung D/ShoppingMemoDbHelper: DbHelper has created the database: shopping_list.db.
// 6330-6330/com.test.sqliteuebung D/MainActivity: DataSource is opened.
// 6330-6330/com.test.sqliteuebung D/ShoppingMemoDataSource: A writable database connection is being opened.
// 6330-6330/com.test.sqliteuebung D/ShoppingMemoDataSource: Database connection opened. Path to database: /data/user/0/com.test.sqliteuebung/databases/shopping_list.db
// 6330-6330/com.test.sqliteuebung D/MainActivity: DataSource is closed.
// 6330-6330/com.test.sqliteuebung D/ShoppingMemoDataSource: Database connection closed.
