package com.avtosola.pici.miki;

public class SvPrijaviSeNaCPPIzpitBancniSistem {


   public static boolean izvediPlacilo(String lastnik, String stKartice, String datumZapad, String ccv) {
      return potrdiPlacilo(lastnik, stKartice, datumZapad, ccv);
   }

   public static boolean potrdiPlacilo(String lastnik, String stKartice, String datumZapad, String ccv) {
      if (!stKartice.equals("4716311137641971")) return false;
      return true;
   }

}