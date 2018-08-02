package com.example.android.bookstoreapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookStoreDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bookstore.db";
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link BookStoreDbHelper}.
     *
     * @param context of the app
     */
    public BookStoreDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the books table
        String SQL_CREATE_BOOK_TABLE = "CREATE TABLE " + BookStoreContract.BookStoreEntry.TABLE_NAME + " ("
                + BookStoreContract.BookStoreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BookStoreContract.BookStoreEntry.COLUMN_BOOKSTORE_PRODUCTNAME + " TEXT NOT NULL, "
                + BookStoreContract.BookStoreEntry.COLUMN_BOOKSTORE_PRICE + " INTEGER NOT NULL, "
                + BookStoreContract.BookStoreEntry.COLUMN_BOOKSTORE_QUANTITY + " INTEGER NOT NULL    , "
                + BookStoreContract.BookStoreEntry.COLUMN_BOOKSTORE_SUPPLIERNAME + " TEXT NOT NULL, "
                + BookStoreContract.BookStoreEntry.COLUMN_BOOKSTORE_SUPPLIERPHONENUMBER + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_BOOK_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}