package com.avtosola.pici.miki;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class KPrijaviSeNaCPPIzpit {
   
   public SvPrijaviSeNaCPPIzpitInformacijskiSistemUprave svPrijaviSeNaCPPIzpitInformacijskiSistemUprave;
   
   public SvPrijaviSeNaCPPIzpitBancniSistem svPrijaviSeNaCPPIzpitBancniSistem;
   
   public static Kandidat kandidat;
   
   public static Collection<Lokacija> lokacija = new HashSet<>();
   
   public static Collection<Termini> termini = new HashSet<>();
   
   public SvPrijaviSeNaCPPIzpitSistemZaEposto svPrijaviSeNaCPPIzpitSistemZaEposto;

   public static Lokacija izbranaLokacija;

   public static Termini izbranTermin;


   public static void vrniSeznamLokacij() {
      SvPrijaviSeNaCPPIzpitInformacijskiSistemUprave.pridobiSeznamLokacij();
   }


   public static void vrniSeznamProstihTerminov() {
      SvPrijaviSeNaCPPIzpitInformacijskiSistemUprave.pridobiSeznamProstihTerminov();
   }

   public static boolean izvediTransakcijo(String lastnik, String stKartice, String datumZapad, String ccv) {
      return SvPrijaviSeNaCPPIzpitBancniSistem.izvediPlacilo(lastnik, stKartice, datumZapad, ccv);
   }
   
   
   public static void posljiRacunNaEposto() {
      SvPrijaviSeNaCPPIzpitSistemZaEposto.posljiRacun();
   }
   
   
   
   public Collection getLokacija() {
      if (lokacija == null)
         lokacija = new HashSet();
      return lokacija;
   }
   
   
   public Iterator getIteratorLokacija() {
      if (lokacija == null)
         lokacija = new HashSet();
      return lokacija.iterator();
   }
   
   
   public void setLokacija(Collection newLokacija) {
      removeAllLokacija();
      for (Iterator iter = newLokacija.iterator(); iter.hasNext();)
         addLokacija((Lokacija)iter.next());
   }
   
   
   public void addLokacija(Lokacija newLokacija) {
      if (newLokacija == null)
         return;
      if (this.lokacija == null)
         this.lokacija = new HashSet();
      if (!this.lokacija.contains(newLokacija))
         this.lokacija.add(newLokacija);
   }
   
   
   public void removeLokacija(Lokacija oldLokacija) {
      if (oldLokacija == null)
         return;
      if (this.lokacija != null)
         if (this.lokacija.contains(oldLokacija))
            this.lokacija.remove(oldLokacija);
   }
   
   
   public void removeAllLokacija() {
      if (lokacija != null)
         lokacija.clear();
   }
   
   public Collection getTermini() {
      if (termini == null)
         termini = new HashSet();
      return termini;
   }
   
   
   public Iterator getIteratorTermini() {
      if (termini == null)
         termini = new HashSet();
      return termini.iterator();
   }
   
   
   public void setTermini(Collection newTermini) {
      removeAllTermini();
      for (Iterator iter = newTermini.iterator(); iter.hasNext();)
         addTermini((Termini)iter.next());
   }
   
   
   public void addTermini(Termini newTermini) {
      if (newTermini == null)
         return;
      if (this.termini == null)
         this.termini = new java.util.HashSet();
      if (!this.termini.contains(newTermini))
         this.termini.add(newTermini);
   }
   
   
   public void removeTermini(Termini oldTermini) {
      if (oldTermini == null)
         return;
      if (this.termini != null)
         if (this.termini.contains(oldTermini))
            this.termini.remove(oldTermini);
   }
   
   
   public void removeAllTermini() {
      if (termini != null)
         termini.clear();
   }

}