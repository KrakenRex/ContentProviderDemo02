package com.example.contentproviderdemo02;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contentproviderdemo02.adapter.ItemAdapter;
import com.example.contentproviderdemo02.entity.Person;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Person> list;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        itemAdapter = new ItemAdapter(MainActivity.this, R.layout.item_layout, list);
        listView.setAdapter(itemAdapter);
        readContacts();
    }



    @SuppressLint("Range")
    private void readContacts() {
        Uri uri = Uri.parse("content://dhj.gdpu.providertest.provider/Contacts");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor == null) {
            Log.e("readContacts","cursor is null");
            return;
        }
        if (cursor.moveToFirst()) {
            do {
                list.add(new Person(null, cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("phone")), null));
            } while (cursor.moveToNext());
        }
        itemAdapter.notifyDataSetChanged();
        cursor.close();
    }
}