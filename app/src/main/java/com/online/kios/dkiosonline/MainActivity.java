package com.online.kios.dkiosonline;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBarang();
    }

    public void initBarang() {


        DataHelperBarang dbhelper = new DataHelperBarang(getApplicationContext());
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        Cursor cursor = db.query(
                "tbl_barang",
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        if(!cursor.moveToNext()) {

            Barang[] produk = new Barang[] {
                    new Barang(1,"Chicken Cheese Roll","Penganan Ringan" , R.drawable.chicken_cheese_roll, 12500, "Makanan bergizi dibalut keju parmesan, mozarella dan nikmatnya tak tertahankan",0),
                    new Barang(2,"Blue Burger", "Penganan Ringan", R.drawable.blue_burger, 14000, "Sensasi Produk burger dengan warna yang sangat asing oleh beberapa kalangan pencinta kuliner",0),
                    new Barang(3,"Croissant Sandwich", "Roti Patisserie", R.drawable.croissant_sandwich, 21000, "Cita rasa perancis dengan saus khas serta roti penuh aroma butter yang menggoda selera",0),
                    new Barang(4,"Factory Cheese Cake", "Tart", R.drawable.factory_cheese_cake, 205000, "Rasakan keju yang lumer dimulut dengan kue yang penuh dengan variasi keju seperti yang satu ini",0),
                    new Barang(5,"Black Forest", "Tart", R.drawable.kue_black_forest, 121000, "Temani buah hati anda dengan kue black forest yang penuh dengan coklat menggoda selera dan rasakan sesnasi coklat",0),
                    new Barang(6,"Kue Lapis", "Penganan Ringan", R.drawable.kue_lapis, 102400, "Temani hari santai anda dengan kue lapis berlapis vanilla dan coklat dalam satu gigitan",0),
                    new Barang(7,"Red Velvet", "Tart", R.drawable.kue_red_velvet, 153400, "Manjakan diri anda dengan kue yang penuh dengan warna merah dilapisi cream cheese yang menggugah selera",0),
                    new Barang(8,"Religieuse", "Roti Patisserie", R.drawable.kue_religieuse, 35000, "Bagi anda pencinta kuliner perancis rasakan sensasi kue berbentuk topi berikut",0),
                    new Barang(9,"Kue Semangka", "Tart", R.drawable.kue_semangka, 108000, "Unik dan asik melihat tampilan kue seperti buah semangka yang lezat dan nikmat",0),
                    new Barang(10,"Kue Tart Biru", "Tart", R.drawable.kue_tart_biru, 145000, "Bagi anda pencinta warna biru kue ini sangat cocok untuk anda dalam rangka ulang tahun bahkan acara lainnya",0),
                    new Barang(11,"Kue Tart WhiteSnow", "Tart", R.drawable.kue_tart_whitesnow, 139000, "Putri salju yang cantik kini tampilan dalam bentuk kue tart yang nikmat",0),
                    new Barang(12,"Macaron", "Penganan Ringan", R.drawable.macaron, 24500, "Manjakan diri anda dengan mencoba macaron dengan sensasi putih telur dan cream vanilla yang lezat",0),
                    new Barang(13,"Macha Cake", "Tart", R.drawable.macha_cake, 85000, "Citarasa khas jepang yang memanjakan hari anda dengan bahan dasar macha",0),
                    new Barang(14,"Pie Susu", "Penganan Ringan", R.drawable.pie_susu, 50000, "Cita rasa khas pulau dewata memanjakan diri anda untuk merasakan pie susu yang nikmat",0),
                    new Barang(15,"Rainbow Cake", "Tart", R.drawable.rainbow_cake, 189000, "Merah, Jingga, Kuning, Biru, Ungu serta warna lainnya yang memukau kue yang satu ini",0),
                    new Barang(16,"Vanilla Cupcake", "Penganan Ringan", R.drawable.vanilla_cupcake, 21000, "Senang dengan modal kecil untuk membeli kue ? Coba lah yang satu ini penuh dengan cream vanilla yang manis",0),
                    new Barang(17,"Watermelon Cake", "Tart", R.drawable.watermelon_cake, 204000, "Rasa yang manis namun dengan sentuhan dekorasi semangka yang lezat",0),
                    new Barang(18,"Roti Unyil", "Roti Patisserie", R.drawable.roti_unyil, 76000, "Bentuk kecil dan mungil sekali rasanya tidak kalah dengan kue bentuk besar lainnya",0),
                    new Barang(19,"Kue Tart Keju", "Tart", R.drawable.kue_tart_keju, 242000, "Bagi anda yang senang dengan kue tart penuh dengan keju pilihan inilah saatnya anda mencoba",0),
                    new Barang(20,"Pizza Galau", "Roti Patisserie", R.drawable.pizza_galau, 185000, "Pizza dengan topping banyak dan meriah silahkan coba terus dan rasakan",0),
            };

            for (Barang items: produk) {
                ContentValues val = insertData(items.idBarang, items.namaBarang, items.kategoriBarang, items.gambarBarang, items.hargaBarang, items.deskripsiBarang, items.stats);
                db.insert("tbl_barang", null, val);
            }
            db.close(); //tutup koneksi agar tidak menyampah history koneksi
            dbhelper.close(); //tutup koneksi helper
        }
    }

    public ContentValues insertData(int idBarang, String namaBarang, String kategoriBarang, Integer gambarBarang, int hargaBarang, String deskripsiBarang, int stats) {
        ContentValues values = new ContentValues();
        values.put("id_barang", idBarang);
        values.put("nama_barang", namaBarang);
        values.put("kategori_barang", kategoriBarang);
        values.put("gambar_barang", gambarBarang);
        values.put("harga_barang", hargaBarang);
        values.put("deskripsi_barang", deskripsiBarang);
        values.put("status_barang", stats);

        return values;
    }

    public void gotolistbarang(View v) {
        Intent intent = new Intent(this, ViewListBarangActivity.class);
        startActivity(intent);
    }

    public void gotolisttroli(View v) {
        Intent intent = new Intent(this, ListTroliActivity.class);
        startActivity(intent);
    }
}