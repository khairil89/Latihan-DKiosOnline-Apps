package com.online.kios.dkiosonline;

public class Barang {

    public int idBarang;
    public String namaBarang;
    public String kategoriBarang;
    public Integer gambarBarang;
    public int hargaBarang;
    public String deskripsiBarang;
    public int stats;

    public Barang(int idBarang ,String namaBarang, String kategoriBarang,
                  Integer gambarBarang,
                  int hargaBarang, String deskripsiBarang, int stats
                  ) {
        this.idBarang        = idBarang;
        this.namaBarang      = namaBarang;
        this.kategoriBarang  = kategoriBarang;
        this.gambarBarang    = gambarBarang;
        this.hargaBarang     = hargaBarang;
        this.deskripsiBarang = deskripsiBarang;
        this.stats           = stats;
    }
}