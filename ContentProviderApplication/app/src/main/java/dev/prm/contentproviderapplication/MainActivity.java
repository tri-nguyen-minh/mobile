package dev.prm.contentproviderapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtName;
    private EditText txtId;
    private EditText txtPhone;
    private TextView txtResult
            ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtId = findViewById(R.id.txtId);
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtResult = findViewById(R.id.txtResult);

    }

    public void onAdd(View view) {
        ContentValues values = new ContentValues();

//        value.put(Tên cột, giá trị) lấy đủ các cột trong bảng, trừ Id
        values.put(MyProvider.KEY_STUDENT_ID, txtId.getText().toString());
        values.put(MyProvider.KEY_NAME, txtName.getText().toString());
        values.put(MyProvider.KEY_PHONE, txtPhone.getText().toString());

        Uri uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);
    }

    public void onUpdate(View view) {
        ContentValues values = new ContentValues();

//        value.put(Tên cột, giá trị) lấy đủ các cột trong bảng, trừ Id
        values.put(MyProvider.KEY_STUDENT_ID, txtId.getText().toString());
        values.put(MyProvider.KEY_NAME, txtName.getText().toString());
        values.put(MyProvider.KEY_PHONE, txtPhone.getText().toString());

//        Update theo cái gì thì đưa vào Where, new String[] {giá trị}
//        đây Delete theo Student_id
        int i = getContentResolver().update(MyProvider.CONTENT_URI, values,
                MyProvider.KEY_STUDENT_ID + " = ?", new String[]{txtId.getText().toString()});
    }

    public void onDelete(View view) {
//        Delete theo cái gì thì đưa vào Where, new String[] {giá trị}
//        đây Delete theo Student_id
        int i = getContentResolver().delete(MyProvider.CONTENT_URI,
                MyProvider.KEY_STUDENT_ID + " = ?", new String[]{txtId.getText().toString()});
    }

//    hàm GET query, dùng trong 'View All' và 'Search'
//    muốn tìm theo cột thì đưa tên cột vào selection, selectionValue là new String[] {giá trị}
//    muốn sort theo cột thì đưa tên cột vào sortBy, sortOrder là "desc" hoặc "asc"
    private String getQuery(String selection, String[] selectionValue, String sortBy, String sortOrder) {

        CursorLoader loader = new CursorLoader(MainActivity.this,
                MyProvider.CONTENT_URI, null, (selection == null) ? null : (selection + " = ?"), selectionValue,
                (sortBy == null) ? null : sortBy + " " + sortOrder);
        Cursor cursor = loader.loadInBackground();
        String result = "";

        if (cursor.moveToFirst()) {
            do {

//                lấy vị trí cột trong Table
                int id = cursor.getColumnIndex(MyProvider.KEY_STUDENT_ID);
                int name = cursor.getColumnIndex(MyProvider.KEY_NAME);
                int phone = cursor.getColumnIndex(MyProvider.KEY_PHONE);


//                load data theo vị trí cột trong Table
                result += cursor.getString(id) + " - " +
                        cursor.getString(name) + " - " +
                        cursor.getString(phone) + "\n";
            } while (cursor.moveToNext());
        }

        return result;
    }

    public void onView(View view) {

//        gọi hàm tạo Cursor
        String output = getQuery(null, null, MyProvider.KEY_STUDENT_ID, "desc");
        txtResult.setText(output);
    }

    public void onSearch(View view) {

//        gọi hàm tạo Cursor
        String output = getQuery(MyProvider.KEY_STUDENT_ID, new String[] {txtId.getText().toString()}, MyProvider.KEY_STUDENT_ID, "desc");
        txtResult.setText(output);
    }

}