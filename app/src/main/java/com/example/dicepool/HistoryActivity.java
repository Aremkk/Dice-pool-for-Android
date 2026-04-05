package com.example.dicepool;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitsory);

        header = findViewById(R.id.header);
        userList = findViewById(R.id.list);

        databaseHelper = new DatabaseHelper(getApplicationContext());
    }
    @Override
    public void onResume() {
        super.onResume();
        db = databaseHelper.getReadableDatabase();
        userCursor =  db.rawQuery("select * from "+ DatabaseHelper.table, null);

        String[] headers = new String[] {DatabaseHelper.columnRoll, DatabaseHelper.columnResult};

        userAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
                userCursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);
        //header.setText("Найдено элементов: " +  userCursor.getCount());
        userList.setAdapter(userAdapter);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        db.close();
        userCursor.close();
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.xml.slide_in_right, R.xml.slide_out_left);
    }
    public void delHistory(View v){
        databaseHelper.clearTable();
        recreate();
    }
}
