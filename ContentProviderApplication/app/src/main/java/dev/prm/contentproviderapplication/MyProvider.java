package dev.prm.contentproviderapplication;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class MyProvider extends ContentProvider {

    //    Đổi tên Database và table
    private static final String TableName = "Students";

    public static final String KEY_ID = "id";
    public static final String KEY_STUDENT_ID = "student_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone";

//    Tạo file ContentProvider : New -> Other -> Content Provider
//    PROVIDER_NAME là URI Authorities khi tạo ContentProvider
//    Copy URI Authorities hoặc vào AndroidManifest copy authorities, paste vô
    private static final String PROVIDER_NAME = "dev.prm.contentprovider";

    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/" + TableName);

    public static final int URI_ID = 1;
    private static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, TableName, URI_ID);
    }
    private SQLiteDatabase SQLiteDB;


    public MyProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        count = SQLiteDB.delete(TableName, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public String getType(Uri uri) {

        switch (uriMatcher.match(uri)) {
            case URI_ID:
                return "vnd.android.cursor.dir/" + TableName;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = SQLiteDB.insert(TableName, null, values);
        if(rowID > 0){
            Uri thisUri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(thisUri, null);
            return thisUri;
        }
        throw new SQLException("Fail to insert row into " + uri);
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DataDBAdapter adapter = new DataDBAdapter(context);
        adapter.open();
        SQLiteDB = adapter.openDB();
        if(SQLiteDB == null){
            return false;
        }
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder sqlBuilder = new SQLiteQueryBuilder();
        sqlBuilder.setTables(TableName);
        if(sortOrder == null || sortOrder == ""){
            sortOrder = KEY_ID;
        }
        Cursor c = sqlBuilder.query(SQLiteDB, projection, selection, selectionArgs, null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int count = 0;
        count = SQLiteDB.update(TableName, values,selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}