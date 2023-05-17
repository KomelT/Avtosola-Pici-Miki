package com.avtosola.pici.miki;

public class Termini {
   private String datum;
   private String ura;
   private double cena;

   Termini(String datum, String ura, double cena) {
      this.datum = datum;
      this.ura = ura;
      this.cena = cena;
   }

   public String getDatum() { return this.datum; }

   public String getUra() { return this.ura; }

   public double getCena() { return this.cena; }
}