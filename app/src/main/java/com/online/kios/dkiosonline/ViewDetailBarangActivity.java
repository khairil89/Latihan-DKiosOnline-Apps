package com.online.kios.dkiosonline;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewDetailBarangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlistdetailbarang);

        initActivity();
    }

    public void initActivity() {
        String parseDetailNamaBarang = "";
        Integer parseDetailGambarBarang = 0;
        String parseDetailDeskripsiBarang = "";
        int parseDetailHargaBarang = 0;
        String parseDetailKategoriBarang = "";
        String keyNama = "parse_detailnamabarang";
        String keyGambar = "parse_detailgambarbarang";
        String keyDeskripsi = "parse_detaildeskripsibarang";
        String keyHarga = "parse_detailhargabarang";
        String keyKategori = "parse_detailkategoribarang";

        TextView detailNama = findViewById(R.id.detailNama);
        ImageView detailGambar = findViewById(R.id.detailgambar);
        TextView detailDeskripsi = findViewById(R.id.detailDeskripsi);
        TextView detailHarga = findViewById(R.id.detailHarga);
        TextView detailKategori = findViewById(R.id.detailKategori);

        parseDetailNamaBarang = getIntent().getExtras().getString(keyNama);
        parseDetailGambarBarang = getIntent().getIntExtra(keyGambar, 0);
        parseDetailDeskripsiBarang = getIntent().getExtras().getString(keyDeskripsi);
        parseDetailHargaBarang = getIntent().getExtras().getInt(keyHarga);
        parseDetailKategoriBarang = getIntent().getExtras().getString(keyKategori);

        detailNama.setText(parseDetailNamaBarang);
        detailDeskripsi.setText(parseDetailDeskripsiBarang);
        detailGambar.setImageResource(parseDetailGambarBarang);
        detailHarga.setText(parseDetailHargaBarang + "");
        detailKategori.setText(parseDetailKategoriBarang);
    }

    public void backtoListBarang() {
        Intent intent = new Intent(this, ViewListBarangActivity.class);
        startActivity(intent);
    }
}