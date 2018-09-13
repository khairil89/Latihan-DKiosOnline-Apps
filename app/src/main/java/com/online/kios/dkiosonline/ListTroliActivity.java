package com.online.kios.dkiosonline;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListTroliActivity extends AppCompatActivity {

    TroliAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlisttroli);

        // Construct the data source
        ArrayList<Barang> arrayOfBarang = new ArrayList<>();

        // Create the adapter to convert the array to views
        adapter = new TroliAdapter(this, arrayOfBarang);

        // Attach the adapter to a ListView
        ListView listView = findViewById(R.id.viewtroli);
        listView.setAdapter(adapter);

        clearItems();
        initItems();
    }

    public void clearItems() {
        this.adapter.clear();
    }

    public void initItems() {
        DataHelperBarang produkHelper = new DataHelperBarang(getApplicationContext());
        SQLiteDatabase dba = produkHelper.getReadableDatabase();

        Cursor cursor = dba.query(
                "tbl_barang",
                null,
                "status_barang = 1",
                null,
                null,
                null,
                null,
                null
        );

        while(cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id_barang"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("nama_barang"));
            String kategori = cursor.getString(cursor.getColumnIndexOrThrow("kategori_barang"));
            Integer gambar = cursor.getInt(cursor.getColumnIndexOrThrow("gambar_barang"));
            int harga = cursor.getInt(cursor.getColumnIndexOrThrow("harga_barang"));
            String deskripsi = cursor.getString(cursor.getColumnIndexOrThrow("deskripsi_barang"));
            int status = cursor.getInt(cursor.getColumnIndexOrThrow("status_barang"));

            adapter.add(new Barang(id, name, kategori, gambar, harga, deskripsi, status));
        }
    }

}
