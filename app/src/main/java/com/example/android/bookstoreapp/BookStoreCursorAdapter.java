package com.example.android.bookstoreapp;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.example.android.bookstoreapp.Data.BookStoreContract.BookStoreEntry;

public class BookStoreCursorAdapter extends CursorAdapter {

    public BookStoreCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.productName);
        TextView priceTextView = (TextView) view.findViewById(R.id.price);
        TextView quantityTextView = (TextView) view.findViewById(R.id.quantity);

        // Find the columns of book attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(BookStoreEntry.COLUMN_BOOKSTORE_PRODUCTNAME);
        int priceColumnIndex = cursor.getColumnIndex(BookStoreEntry.COLUMN_BOOKSTORE_PRICE);
        int quantityColumnIndex = cursor.getColumnIndex(BookStoreEntry.COLUMN_BOOKSTORE_QUANTITY);

        // Read the book attributes from the Cursor for the current book
        String bookName = cursor.getString(nameColumnIndex);
        int price = cursor.getInt(priceColumnIndex);
        String productPrice = "Price : " + String.valueOf(price) + " USD ";
        int quantity = cursor.getInt(quantityColumnIndex);
        String quantityProduct = "Available : " + String.valueOf(quantity);

        // Update the TextViews with the attributes for the current book
        nameTextView.setText(bookName);
        priceTextView.setText(productPrice);
        quantityTextView.setText(quantityProduct);

        int productIdColumnIndex = cursor.getColumnIndex(BookStoreEntry._ID);
        final int id = Integer.parseInt(cursor.getString(productIdColumnIndex));
        final int quantityValue = cursor.getInt(quantityColumnIndex);

        Button soldButton = view.findViewById(R.id.soldButton);
        soldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri currentBookUri = ContentUris.withAppendedId(BookStoreEntry.CONTENT_URI, id);
                String updatedQuantity = String.valueOf(quantityValue - 1);
                if (Integer.parseInt(updatedQuantity) >= 0) {
                    ContentValues values = new ContentValues();
                    values.put(BookStoreEntry.COLUMN_BOOKSTORE_QUANTITY, updatedQuantity);
                    context.getContentResolver().update(currentBookUri, values, null, null);
                }
            }
        });
    }
}