package com.avtosola.pici.miki;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

@SuppressWarnings("FieldMayBeFinal")
public class Kandidat implements Parcelable {
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
    private boolean opravljenCppIzpit;
    private int opravljeneUreVoznje;
    private int steviloNeopravljenihGlavnihVozenj;
    private boolean opravljenaGlavnaVoznja;

    Kandidat (String ime, String priimek, String naslovPrebivalisca, int emso, int telefonskaStevilka, String ePostniNaslov, String md5Geslo, boolean ustreznoZdravniskoPotrdilo, boolean ustreznoPotrdiloOOpravljeniPp, boolean opravljenCppTecaj, int steviloNeopravljenihCppIzpitov, boolean opravljenCppIzpit, int opravljeneUreVoznje, int steviloNeopravljenihGlavnihVozenj, boolean opravljenaGlavnaVoznja) {
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
        this.opravljeneUreVoznje = opravljeneUreVoznje;
        this.steviloNeopravljenihGlavnihVozenj = steviloNeopravljenihGlavnihVozenj;
        this.opravljenaGlavnaVoznja = opravljenaGlavnaVoznja;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected Kandidat(Parcel in) {
        this.ime = in.readString();
        this.priimek = in.readString();
        this.naslovPrebivalisca = in.readString();
        this.emso = in.readInt();
        this.telefonskaStevilka = in.readInt();
        this.ePostniNaslov = in.readString();
        this.md5Geslo = in.readString();
        this.ustreznoZdravniskoPotrdilo = in.readBoolean();
        this.ustreznoPotrdiloOOpravljeniPp = in.readBoolean();
        this.opravljenCppTecaj = in.readBoolean();
        this.steviloNeopravljenihCppIzpitov = in.readInt();
        this.opravljenCppIzpit = in.readBoolean();
        this.opravljeneUreVoznje = in.readInt();
        this.steviloNeopravljenihGlavnihVozenj = in.readInt();
        this.opravljenaGlavnaVoznja = in.readBoolean();
    }

    public static final Creator<Kandidat> CREATOR = new Creator<Kandidat>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Kandidat createFromParcel(Parcel in) {
            return new Kandidat(in);
        }

        @Override
        public Kandidat[] newArray(int size) {
            return new Kandidat[size];
        }
    };

    public void prijaviSeNaIzpit() {
        // TODO: implement
    }

    public boolean preveriPrijavo(String ePostniNaslov, String vnesenoGeslo) {
        System.out.println(ePostniNaslov);
        System.out.println(this.ePostniNaslov);
        System.out.println(getMd5(vnesenoGeslo));
        System.out.println(this.md5Geslo);

        return md5Geslo.equals(getMd5(vnesenoGeslo)) && this.ePostniNaslov.equals(ePostniNaslov);
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

    public static String getMd5(String input) {
        try {
            MessageDigest msgDst = MessageDigest.getInstance("MD5");
            byte[] msgArr = msgDst.digest(input.getBytes());

            BigInteger bi = new BigInteger(1, msgArr);

            String hshtxt = bi.toString(16);

            while (hshtxt.length() < 32) {
                hshtxt = "0" + hshtxt;
            }
            return hshtxt;
        }
        catch (NoSuchAlgorithmException err) {
            return "";
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(this.ime);
        dest.writeString(this.priimek);
        dest.writeString(this.naslovPrebivalisca);
        dest.writeInt(this.emso);
        dest.writeInt(this.telefonskaStevilka);
        dest.writeString(this.ePostniNaslov);
        dest.writeString(this.md5Geslo);
        dest.writeBoolean(this.ustreznoZdravniskoPotrdilo);
        dest.writeBoolean(this.ustreznoPotrdiloOOpravljeniPp);
        dest.writeBoolean(this.opravljenCppTecaj);
        dest.writeInt( this.steviloNeopravljenihCppIzpitov);
        dest.writeBoolean(this.opravljenCppIzpit);
        dest.writeInt(this.opravljeneUreVoznje);
        dest.writeInt(this.steviloNeopravljenihGlavnihVozenj);
        dest.writeBoolean(this.opravljenaGlavnaVoznja);
    }
}
