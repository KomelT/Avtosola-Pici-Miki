package com.avtosola.pici.miki;

public class Lokacija {
   private String nazivUe;
   private String naslovUe;

   Lokacija(String nazivUe, String naslovUe) {
      this.nazivUe = nazivUe;
      this.naslovUe = naslovUe;
   }

   public String getNaziv() {
      return this.nazivUe;
   }

   public String getNaslovUe() {
      return this.naslovUe;
   }
}