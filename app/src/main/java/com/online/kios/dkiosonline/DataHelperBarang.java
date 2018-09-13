package com.online.kios.dkiosonline;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelperBarang extends SQLiteOpenHelper {

    private static final String DB_NAME = "barang.db";
    private static final int DB_VERSION = 1;
    public DataHelperBarang(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        // TODO Auto-generated constructor sub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated constructor sub
        String sql = "CREATE TABLE tbl_barang (" +
                " id_barang integer primary key autoincrement," +
                " nama_barang text, " +
                " kategori_barang text, " +
                " gambar_barang integer, " +
                " harga_barang integer, " +
                " deskripsi_barang text, " +
                " status_barang integer)";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
//        String sql = "DROP TABLE IF EXISTS tbl_barang";
        //TODO
    }
}
