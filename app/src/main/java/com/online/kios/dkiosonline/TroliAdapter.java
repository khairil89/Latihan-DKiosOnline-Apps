package com.online.kios.dkiosonline;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TroliAdapter extends ArrayAdapter<Barang> {

    protected Cursor cursor;
    DataHelperBarang dbHelper;

    public TroliAdapter(Context context, ArrayList<Barang> Barang) {
        super(context, 0, Barang);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Barang barang = getItem(position); //posisi item Barang yang dipilih
        // Check if an existing view is being reused,
        // otherwise inflate the view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.activity_viewparttroli, parent, false);
        }
        else {
            Button hapusbarangBtn = convertView.findViewById(R.id.btn_hapus);;

//            if(barang.stats == 1) {
//                hapusbarangBtn.setText("Kensel");
//                hapusbarangBtn.setBackgroundColor(Color.parseColor("#202020"));
//                hapusbarangBtn.setTextColor(Color.parseColor("#808080"));
//            }
//            else {
//                hapusbarangBtn.setText("Kensel");
//                hapusbarangBtn.setBackgroundColor(Color.parseColor("#339434"));
//                hapusbarangBtn.setTextColor(Color.parseColor("#FEFEFE"));
//            }
        }

        final Button hapusbarangBtn = convertView.findViewById(R.id.btn_hapus);;
        dbHelper = new DataHelperBarang(convertView.getContext());
        hapusbarangBtn.setTag(position);
        hapusbarangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(barang);
                notifyDataSetChanged();
                int position = (Integer) v.getTag();
                barang.stats = 0;
                //update status_barang menjadi = 0
                dbHelper = new DataHelperBarang(v.getContext());
                SQLiteDatabase dbd = dbHelper.getReadableDatabase();

                ContentValues val = new ContentValues();
                val.put("status_barang",barang.stats);

                String[] id = { barang.idBarang + "" };
                dbd.update(
                        "tbl_barang",
                        val,
                        "id_barang = ?",
                        id
                );
                dbd.close();
                dbHelper.close();

                Toast.makeText(v.getContext(), "Hapus dari Troli", Toast.LENGTH_LONG).show();
//                    ListTroliActivity.lta.RefreshList();
            }
        });
        //activity_lihatbarang merupakan xml yang menjadi tempat dimana listview berada
        // Lookup view for data population
        TextView namabarang = convertView.findViewById(R.id.troliNama);
        TextView hargabarang = convertView.findViewById(R.id.troliHarga);
        ImageView gambarbarang = convertView.findViewById(R.id.troliGambar);

        TextView detailnamabarang = convertView.findViewById(R.id.detailNama);
        ImageView detailgambarbarang = convertView.findViewById(R.id.detailgambar);
        TextView deskripsibarang = convertView.findViewById(R.id.detailDeskripsi);
        TextView detailhargabarang = convertView.findViewById(R.id.detailHarga);
        TextView detailkategoribarang = convertView.findViewById(R.id.detailKategori);


        // Populate the data into the template view using the data object
        namabarang.setText(barang.namaBarang);
        hargabarang.setText(barang.hargaBarang + "");
        gambarbarang.setImageResource(barang.gambarBarang);

        // Return the completed view to render on screen
        return convertView;
    }

}
