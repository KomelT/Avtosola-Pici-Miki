package com.avtosola.pici.miki;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

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

}
