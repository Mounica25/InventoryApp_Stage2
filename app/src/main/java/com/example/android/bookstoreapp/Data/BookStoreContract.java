package com.example.android.bookstoreapp.Data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class BookStoreContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.bookstoreapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_BOOKS = "books";

    private BookStoreContract() {
    }

    public static abstract class BookStoreEntry implements BaseColumns {

        private BookStoreEntry() {

        }

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BOOKS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of books.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single book.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        public static final String TABLE_NAME = "BookStore";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_BOOKSTORE_PRODUCTNAME = "ProductName";
        public static final String COLUMN_BOOKSTORE_PRICE = "Price";
        public static final String COLUMN_BOOKSTORE_QUANTITY = "Quantity";
        public static final String COLUMN_BOOKSTORE_SUPPLIERNAME = "SupplierName";
        public static final String COLUMN_BOOKSTORE_SUPPLIERPHONENUMBER = "SupplierPhoneNumber";
    }
}