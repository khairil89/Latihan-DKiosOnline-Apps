package com.online.kios.dkiosonline;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewListBarangActivity extends AppCompatActivity {

    BarangAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlistbarang);

        // Construct the data source
        ArrayList<Barang> arrayOfBarang = new ArrayList<>();

        // Create the adapter to convert the array to views
        adapter = new BarangAdapter(this, arrayOfBarang);

        // Attach the adapter to a ListView
        ListView listView = findViewById(R.id.viewbarang);
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
                null,
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

//        Barang produk1  = new Barang(1,"Chicken Cheese Roll","Penganan Ringan" , R.drawable.chicken_cheese_roll, 12500, "Makanan bergizi dibalut keju parmesan, mozarella dan nikmatnya tak tertahankan",1);
//        Barang produk2  = new Barang(2,"Blue Burger", "Penganan Ringan", R.drawable.blue_burger, 14000, "Sensasi Produk burger dengan warna yang sangat asing oleh beberapa kalangan pencinta kuliner",1);
//        Barang produk3  = new Barang(3,"Croissant Sandwich", "Roti Patisserie", R.drawable.croissant_sandwich, 21000, "Cita rasa perancis dengan saus khas serta roti penuh aroma butter yang menggoda selera",1);
//        Barang produk4  = new Barang(4,"Factory Cheese Cake", "Tart", R.drawable.factory_cheese_cake, 205000, "Rasakan keju yang lumer dimulut dengan kue yang penuh dengan variasi keju seperti yang satu ini",1);
//        Barang produk5  = new Barang(5,"Black Forest", "Tart", R.drawable.kue_black_forest, 121000, "Temani buah hati anda dengan kue black forest yang penuh dengan coklat menggoda selera dan rasakan sesnasi coklat",1);
//        Barang produk6  = new Barang(6,"Kue Lapis", "Penganan Ringan", R.drawable.kue_lapis, 102400, "Temani hari santai anda dengan kue lapis berlapis vanilla dan coklat dalam satu gigitan",1);
//        Barang produk7  = new Barang(7,"Red Velvet", "Tart", R.drawable.kue_red_velvet, 153400, "Manjakan diri anda dengan kue yang penuh dengan warna merah dilapisi cream cheese yang menggugah selera",1);
//        Barang produk8  = new Barang(8,"Religieuse", "Roti Patisserie", R.drawable.kue_religieuse, 35000, "Bagi anda pencinta kuliner perancis rasakan sensasi kue berbentuk topi berikut",1);
//        Barang produk9  = new Barang(9,"Kue Semangka", "Tart", R.drawable.kue_semangka, 108000, "Unik dan asik melihat tampilan kue seperti buah semangka yang lezat dan nikmat",1);
//        Barang produk10 = new Barang(10,"Kue Tart Biru", "Tart", R.drawable.kue_tart_biru, 145000, "Bagi anda pencinta warna biru kue ini sangat cocok untuk anda dalam rangka ulang tahun bahkan acara lainnya",1);
//        Barang produk11 = new Barang(11,"Kue Tart WhiteSnow", "Tart", R.drawable.kue_tart_whitesnow, 139000, "Putri salju yang cantik kini tampilan dalam bentuk kue tart yang nikmat",1);
//        Barang produk12 = new Barang(12,"Macaron", "Penganan Ringan", R.drawable.macaron, 24500, "Manjakan diri anda dengan mencoba macaron dengan sensasi putih telur dan cream vanilla yang lezat",1);
//        Barang produk13 = new Barang(13,"Macha Cake", "Tart", R.drawable.macha_cake, 85000, "Citarasa khas jepang yang memanjakan hari anda dengan bahan dasar macha",1);
//        Barang produk14 = new Barang(14,"Pie Susu", "Penganan Ringan", R.drawable.pie_susu, 50000, "Cita rasa khas pulau dewata memanjakan diri anda untuk merasakan pie susu yang nikmat",1);
//        Barang produk15 = new Barang(15,"Rainbow Cake", "Tart", R.drawable.rainbow_cake, 189000, "Merah, Jingga, Kuning, Biru, Ungu serta warna lainnya yang memukau kue yang satu ini",1);
//        Barang produk16 = new Barang(16,"Vanilla Cupcake", "Penganan Ringan", R.drawable.vanilla_cupcake, 21000, "Senang dengan modal kecil untuk membeli kue ? Coba lah yang satu ini penuh dengan cream vanilla yang manis",1);
//        Barang produk17 = new Barang(17,"Watermelon Cake", "Tart", R.drawable.watermelon_cake, 204000, "Rasa yang manis namun dengan sentuhan dekorasi semangka yang lezat",1);
//        Barang produk18 = new Barang(18,"Roti Unyil", "Roti Patisserie", R.drawable.roti_unyil, 76000, "Bentuk kecil dan mungil sekali rasanya tidak kalah dengan kue bentuk besar lainnya",1);
//        Barang produk19 = new Barang(19,"Kue Tart Keju", "Tart", R.drawable.kue_tart_keju, 242000, "Bagi anda yang senang dengan kue tart penuh dengan keju pilihan inilah saatnya anda mencoba",1);
//        Barang produk20 = new Barang(20,"Pizza Galau", "Roti Patisserie", R.drawable.pizza_galau, 185000, "Pizza dengan topping banyak dan meriah silahkan coba terus dan rasakan",1);
//
//        adapter.add(produk1);
//        adapter.add(produk2);
//        adapter.add(produk3);
//        adapter.add(produk4);
//        adapter.add(produk5);
//        adapter.add(produk6);
//        adapter.add(produk7);
//        adapter.add(produk8);
//        adapter.add(produk9);
//        adapter.add(produk10);
//        adapter.add(produk11);
//        adapter.add(produk12);
//        adapter.add(produk13);
//        adapter.add(produk14);
//        adapter.add(produk15);
//        adapter.add(produk16);
//        adapter.add(produk17);
//        adapter.add(produk18);
//        adapter.add(produk19);
//        adapter.add(produk20);
    }

}
