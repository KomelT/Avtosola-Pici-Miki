package com.avtosola.pici.miki;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

@RequiresApi(api = Build.VERSION_CODES.Q)
public class UserProfile extends AppCompatActivity {
    Kandidat prijavljenUporabnik;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        prijavljenUporabnik = KPrijaviSeNaCPPIzpit.kandidat;

        ((TextView) findViewById(R.id.heading)).setText("Zdravo " + prijavljenUporabnik.getIme());

        ((TextView) findViewById(R.id.zp_text)).setTextColor(Color.rgb(73, 73, 73));
        ((TextView) findViewById(R.id.zp_bool)).setTextColor(Color.rgb(73, 73, 73));

        ((TextView) findViewById(R.id.pp_text)).setTextColor(Color.rgb(73, 73, 73));
        ((TextView) findViewById(R.id.pp_bool)).setTextColor(Color.rgb(73, 73, 73));

        ((TextView) findViewById(R.id.nalozi_zp)).setBackgroundColor(Color.rgb(103, 80, 164));
        ((TextView) findViewById(R.id.nalozi_pp)).setBackgroundColor(Color.rgb(103, 80, 164));


        ((TextView) findViewById(R.id.prijava_cpp_tecaj)).setEnabled(false);
        ((TextView) findViewById(R.id.prijava_cpp_izpit)).setEnabled(false);
        ((TextView) findViewById(R.id.prijava_voznje)).setEnabled(false);
        ((TextView) findViewById(R.id.prijava_g_voznja)).setEnabled(false);


        if (prijavljenUporabnik.getUstreznoZdravniskoPotrdilo()) {
            ((TextView) findViewById(R.id.zp_bool)).setText("Da");
            ((TextView) findViewById(R.id.nalozi_zp)).setBackgroundColor(Color.argb(36,103, 80, 164));
            ((TextView) findViewById(R.id.nalozi_zp)).setEnabled(false);
        }

        if (prijavljenUporabnik.getUstreznoPotrdiloOOpravljeniPp()) {
            ((TextView) findViewById(R.id.pp_bool)).setText("Da");
            ((TextView) findViewById(R.id.nalozi_pp)).setBackgroundColor(Color.argb(36,103, 80, 164));
            ((TextView) findViewById(R.id.nalozi_pp)).setEnabled(false);
        }

        if (prijavljenUporabnik.getUstreznoZdravniskoPotrdilo() && prijavljenUporabnik.getUstreznoPotrdiloOOpravljeniPp()) {
            ((TextView) findViewById(R.id.cpp_tecaj_text)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.cpp_tecaj_bool)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.prijava_cpp_tecaj)).setBackgroundColor(Color.rgb(103, 80, 164));
            ((TextView) findViewById(R.id.prijava_cpp_tecaj)).setEnabled(true);
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
            ((TextView) findViewById(R.id.prijava_cpp_tecaj)).setEnabled(false);
            ((TextView) findViewById(R.id.prijava_cpp_izpit)).setEnabled(true);
        }

        if (prijavljenUporabnik.getOpravljenCppIzpit()) {
            ((TextView) findViewById(R.id.cpp_izpit_bool)).setText("Da");
            ((TextView) findViewById(R.id.voznja_ure_st_text)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_ure_st_number)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_ure_st_number)).setText(prijavljenUporabnik.getOpravljeneUreVoznje() + "");
            ((TextView) findViewById(R.id.prijava_voznje)).setBackgroundColor(Color.rgb(103, 80, 164));
            ((TextView) findViewById(R.id.prijava_cpp_izpit)).setBackgroundColor(Color.argb(36,103, 80, 164));
            ((TextView) findViewById(R.id.prijava_voznje)).setEnabled(true);
            ((TextView) findViewById(R.id.prijava_cpp_izpit)).setEnabled(false);
        }

        if (prijavljenUporabnik.getPrijavljenNaCPPIzpit()) {
            ((TextView) findViewById(R.id.prijava_cpp_izpit)).setBackgroundColor(Color.argb(36,103, 80, 164));
            ((TextView) findViewById(R.id.prijava_cpp_izpit)).setEnabled(false);
            ((TextView) findViewById(R.id.prijava_cpp_izpit)).setText("Prijavi se na CPP izpit (prijavljen)");
        }

        if (prijavljenUporabnik.getOpravljeneUreVoznje() >= 20) {
            ((TextView) findViewById(R.id.voznja_tecaj_text)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_tecaj_bool)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_tecaj_st_text)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_tecaj_st_number)).setTextColor(Color.rgb(73, 73, 73));
            ((TextView) findViewById(R.id.voznja_ure_st_number)).setText(prijavljenUporabnik.getSteviloNeopravljenihGlavnihVozenj() + "");
            ((TextView) findViewById(R.id.prijava_g_voznja)).setBackgroundColor(Color.rgb(103, 80, 164));
            ((TextView) findViewById(R.id.prijava_voznje)).setBackgroundColor(Color.argb(36,103, 80, 164));
            ((TextView) findViewById(R.id.prijava_g_voznja)).setEnabled(true);
            ((TextView) findViewById(R.id.prijava_voznje)).setEnabled(false);
        }

        if (prijavljenUporabnik.getOpravljenaGlavnaVoznja()) {
            ((TextView) findViewById(R.id.voznja_tecaj_bool)).setText("Da");
            ((TextView) findViewById(R.id.prijava_g_voznja)).setBackgroundColor(Color.argb(36,103, 80, 164));
            ((TextView) findViewById(R.id.prijava_g_voznja)).setEnabled(false);
        }

        ((TextView) findViewById(R.id.nalozi_zp)).setTextColor(Color.WHITE);
        ((TextView) findViewById(R.id.nalozi_pp)).setTextColor(Color.WHITE);
        ((TextView) findViewById(R.id.prijava_cpp_tecaj)).setTextColor(Color.WHITE);
        ((TextView) findViewById(R.id.prijava_cpp_izpit)).setTextColor(Color.WHITE);
        ((TextView) findViewById(R.id.prijava_voznje)).setTextColor(Color.WHITE);
        ((TextView) findViewById(R.id.prijava_g_voznja)).setTextColor(Color.WHITE);

        Button bt_prijava = findViewById(R.id.prijava_cpp_izpit);
        bt_prijava.setOnClickListener(v -> {
            Intent intent = new Intent(UserProfile.this, ZmKandidatPrijaviSeNaCPPIzpit.class);
            startActivity(intent);
        });
    }
}
