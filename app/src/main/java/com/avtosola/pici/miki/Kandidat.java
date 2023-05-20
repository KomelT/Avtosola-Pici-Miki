package com.avtosola.pici.miki;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RequiresApi(api = Build.VERSION_CODES.Q)
public class Kandidat {
   
   private String ime;
   private String priimek;
   private String naslovPrebivalisca;
   private int emso;
   private int telefonskaStevilka;
   private String ePostniNaslov;
   private String md5Geslo;
   private boolean ustreznoZdravniskoPotrdilo;
   private boolean ustreznoPotrdiloOOpravljeniPp;
   private boolean opravljenCppTecaj;
   private int steviloNeopravljenihCppIzpitov;
   private boolean prijavljenNaCPPIzpit;
   private boolean opravljenCppIzpit;
   private int opravljeneUreVoznje;
   private int steviloNeopravljenihGlavnihVozenj;
   private boolean opravljenaGlavnaVoznja;


   Kandidat(String ime, String priimek, String naslovPrebivalisca, int emso, int telefonskaStevilka,
            String ePostniNaslov, String md5Geslo, boolean ustreznoZdravniskoPotrdilo,
            boolean ustreznoPotrdiloOOpravljeniPp, boolean opravljenCppTecaj, int steviloNeopravljenihCppIzpitov,
            boolean opravljenCppIzpit, int opravljeneUreVoznje, int steviloNeopravljenihGlavnihVozenj,
            boolean opravljenaGlavnaVoznja) {

      this.ime = ime;
      this.priimek = priimek;
      this.naslovPrebivalisca = naslovPrebivalisca;
      this.emso = emso;
      this.telefonskaStevilka = telefonskaStevilka;
      this.ePostniNaslov = ePostniNaslov;
      this.md5Geslo = md5Geslo;
      this.ustreznoZdravniskoPotrdilo = ustreznoZdravniskoPotrdilo;
      this.ustreznoPotrdiloOOpravljeniPp = ustreznoPotrdiloOOpravljeniPp;
      this.opravljenCppTecaj = opravljenCppTecaj;
      this.steviloNeopravljenihCppIzpitov = steviloNeopravljenihCppIzpitov;
      this.opravljenCppIzpit = opravljenCppIzpit;
      this.prijavljenNaCPPIzpit = false;
      this.opravljeneUreVoznje = opravljeneUreVoznje;
      this.steviloNeopravljenihGlavnihVozenj = steviloNeopravljenihGlavnihVozenj;
      this.opravljenaGlavnaVoznja = opravljenaGlavnaVoznja;
   }
   
   public void prijaviSeNaIzpit() {
      // TODO: implement
   }

   public boolean preveriPrijavo(String ePostniNaslov, String vnesenoGeslo) {
      return md5Geslo.equals(Helpers.getMd5(vnesenoGeslo)) && this.ePostniNaslov.equals(ePostniNaslov);
   }

   public String getIme() {
      return this.ime;
   }

   public String getPriimek() {
      return this.priimek;
   }

   public String getNaslovPrebivalisca() {
      return this.naslovPrebivalisca;
   }

   public int getEmso() {
      return this.emso;
   }

   public int getTelefonskaStevilka() {
      return this.telefonskaStevilka;
   }

   public String getePostniNaslov() {
      return this.ePostniNaslov;
   }

   public boolean getUstreznoZdravniskoPotrdilo() {
      return this.ustreznoZdravniskoPotrdilo;
   }

   public boolean getUstreznoPotrdiloOOpravljeniPp() {
      return this.ustreznoPotrdiloOOpravljeniPp;
   }

   public boolean getOpravljenCppTecaj() {
      return this.opravljenCppTecaj;
   }

   public boolean isPrijavljenNaCPPIzpit() { return prijavljenNaCPPIzpit; }

   public int getSteviloNeopravljenihCppIzpitov() {
      return steviloNeopravljenihCppIzpitov;
   }

   public boolean getOpravljenCppIzpit() {
      return this.opravljenCppIzpit;
   }

   public int getOpravljeneUreVoznje() {
      return this.opravljeneUreVoznje;
   }

   public int getSteviloNeopravljenihGlavnihVozenj() {
      return this.steviloNeopravljenihGlavnihVozenj;
   }

   public boolean getOpravljenaGlavnaVoznja() {
      return this.opravljenaGlavnaVoznja;
   }

}