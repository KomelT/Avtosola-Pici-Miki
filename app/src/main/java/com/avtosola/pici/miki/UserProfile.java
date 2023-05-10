package com.avtosola.pici.miki;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {
    Kandidat prijavljenUporabnik;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        Intent intent = getIntent();
        prijavljenUporabnik = intent.getParcelableExtra("prijavljen_uporabnik");

        ((TextView) findViewById(R.id.heading)).setText("Zdravo " + prijavljenUporabnik.getIme());

        ((TextView) findViewById(R.id.zp_text)).setTextColor(Color.rgb(73, 73, 73));
        ((TextView) findViewById(R.id.zp_bool)).setTextColor(Color.rgb(73, 73, 73));

        ((TextView) findViewById(R.id.pp_text)).setTextColor(Color.rgb(73, 73, 73));
        ((TextView) findViewById(R.id.pp_bool)).setTextColor(Color.rgb(73, 73, 73));

        ((TextView) findViewById(R.id.nalozi_zp)).setBackgroundColor(Color.rgb(103, 80, 164));
        ((TextView) findViewById(R.id.nalozi_pp)).setBackgroundColor(Color.rgb(103, 80, 164));


        if (prijavljenUporabnik.getUstreznoZdravniskoPotrdilo()) {
            ((TextView) findViewById(R.id.zp_bool)).setText("Da");
            ((TextView) findViewById(R.id.nalozi_zp)).setBackgroundColor(Color.argb(36,103, 80, 164));
        }

        if (prijavljenUporabnik.getUstreznoPotrdiloOOpravljeniPp()) {
            ((TextView) findViewById(R.id.pp_bool)).setText("Da");
            ((TextView) findViewById(R.id.nalozi_pp)).setBackgroundColor(Color.argb(36,103, 80, 164));
        }

        if (prijavljenUporabnik.getUstreznoZdravniskoPotrdilo() && prijavljenUporabnik.getUstreznoPotrdiloOOpravljeniPp()) {
            ((TextView) findViewById(R.id.cpp_tecaj_text)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.cpp_tecaj_bool)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.prijava_cpp_tecaj)).setBackgroundColor(Color.rgb(103, 80, 164));
        }

        if (prijavljenUporabnik.getOpravljenCppTecaj()) {
            ((TextView) findViewById(R.id.cpp_tecaj_bool)).setText("Da");
            ((TextView) findViewById(R.id.cpp_izpit_text)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.cpp_izpit_bool)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.cpp_izpit_st_text)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.cpp_izpit_st_number)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.cpp_izpit_st_number)).setText(prijavljenUporabnik.getSteviloNeopravljenihCppIzpitov() + "");
            ((TextView) findViewById(R.id.prijava_cpp_izpit)).setBackgroundColor(Color.rgb(103, 80, 164));
            ((TextView) findViewById(R.id.prijava_cpp_tecaj)).setBackgroundColor(Color.argb(36,103, 80, 164));
        }

        if (prijavljenUporabnik.getOpravljenCppIzpit()) {
            ((TextView) findViewById(R.id.cpp_izpit_bool)).setText("Da");
            ((TextView) findViewById(R.id.voznja_ure_st_text)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_ure_st_number)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_ure_st_number)).setText(prijavljenUporabnik.getOpravljeneUreVoznje() + "");
            ((TextView) findViewById(R.id.prijava_voznje)).setBackgroundColor(Color.rgb(103, 80, 164));
            ((TextView) findViewById(R.id.prijava_cpp_izpit)).setBackgroundColor(Color.argb(36,103, 80, 164));
        }

        if (prijavljenUporabnik.getOpravljeneUreVoznje() >= 20) {
            ((TextView) findViewById(R.id.voznja_tecaj_text)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_tecaj_bool)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_tecaj_st_text)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_tecaj_st_number)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_ure_st_number)).setText(prijavljenUporabnik.getSteviloNeopravljenihGlavnihVozenj() + "");
            ((TextView) findViewById(R.id.prijava_g_voznja)).setBackgroundColor(Color.rgb(103, 80, 164));
            ((TextView) findViewById(R.id.prijava_voznje)).setBackgroundColor(Color.argb(36,103, 80, 164));
        }

        if (prijavljenUporabnik.getOpravljenaGlavnaVoznja()) {
            ((TextView) findViewById(R.id.voznja_tecaj_bool)).setText("Da");
            ((TextView) findViewById(R.id.prijava_g_voznja)).setBackgroundColor(Color.argb(36,103, 80, 164));
        }
    }
}
