package dev.prm.contentproviderapplication;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataDBAdapter {

//    Đổi tên Database và table
    private static final String DBName = "StudentDB.db";
    private static final String TableName = "Students";

//    Đổi tên các cột trong Table, tốt nhất đừng đổi KEY_ID
    private static final String KEY_ID = "id";
    private static final String KEY_STUDENT_ID = "student_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";

    private static final int DBVersion = 3;

//    Đỏi lại câu Create theo các cột trong Table
    private static final String CREATE_SQL_STATEMENT = "create table "+ TableName + "(" +
            KEY_ID + " integer primary key autoincrement, " +
            KEY_STUDENT_ID + " text not null, " +
            KEY_NAME + " text not null," +
            KEY_PHONE + " text not null" +
        ");";


    private static final String DROP_TABLE_STATEMENT = "Drop Table If Exists " + TableName;

    private final Context context;
    private SQLiteDatabase db;


    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context){
            super(context, DBName, null, DBVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_SQL_STATEMENT);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE_STATEMENT);
            onCreate(db);
        }
    }

    private DBHelper dbHelper;

    public DataDBAdapter(Context context){
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    public DataDBAdapter open () throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public SQLiteDatabase openDB() throws SQLException{
        db = dbHelper.getWritableDatabase();
        return db;
    }
}
