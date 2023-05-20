package com.avtosola.pici.miki;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.Q)
public class ZmKandidatPrijaviSeNaCPPIzpit extends AppCompatActivity {
   
   public KPrijaviSeNaCPPIzpit kPrijaviSeNaCPPIzpit;

   private ArrayList<Button> lokacijeButton = new ArrayList<Button>();

   private ArrayList<Button> terminiButton = new ArrayList<Button>();

   Lokacija izbranaLokacija;

   Termini izbranTermin;

   Kandidat prijavljenUporabnik;



   public void zacniPrijavo() {
      prijavljenUporabnik = KPrijaviSeNaCPPIzpit.kandidat;
      KPrijaviSeNaCPPIzpit.vrniSeznamLokacij();
      prikaziSeznamLokacij();
   }
   
   
   public void prikaziSeznamLokacij() {
      LinearLayout layout = findViewById(R.id.llayout);

      for (Lokacija lokacija : KPrijaviSeNaCPPIzpit.lokacija) {
         Button btnTag = new Button(this);
         btnTag.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
         btnTag.setText(lokacija.getNaziv());
         btnTag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               izberiLokacijo(lokacija);
            }
         });
         lokacijeButton.add(btnTag);
         layout.addView(btnTag);
      }

   }
   
   
   public void izberiLokacijo(Lokacija lokacija) {
      for (Button button : lokacijeButton) {
         ((ViewManager) button.getParent()).removeView(button);
      }
      lokacijeButton.clear();
      izbranaLokacija = lokacija;
      KPrijaviSeNaCPPIzpit.vrniSeznamProstihTerminov();
      prikaziProsteTermineZaIzbranoLokacijo();
   }
   
   
   public void prikaziProsteTermineZaIzbranoLokacijo() {
      LinearLayout layout = findViewById(R.id.llayout);
      ((TextView) findViewById(R.id.heading2)).setText("Izberi termin za opravljanje izpita:");

      for (Termini termin : KPrijaviSeNaCPPIzpit.termini) {
         Button btnTag = new Button(this);
         btnTag.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
         btnTag.setText(termin.getDatum() + ", " + termin.getUra());
         btnTag.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
               izberiTermin(termin);
            }
         });
         terminiButton.add(btnTag);
         layout.addView(btnTag);
      }
   }
   
   
   public void izberiTermin(Termini termin) {
      for (Button button : terminiButton) {
         ((ViewManager) button.getParent()).removeView(button);
      }
      terminiButton.clear();
      izbranTermin = termin;
      prikaziPovzetekPrijave();
   }
   
   
   public void prikaziPovzetekPrijave() {
      LinearLayout layout = findViewById(R.id.llayout);
      ((TextView) findViewById(R.id.heading2)).setText("Povzetek prijave:");

      TextView tv1 = new TextView(this);
      tv1.setText(izbranaLokacija.getNaziv());
      layout.addView(tv1);

      TextView tv2 = new TextView(this);
      tv2.setText(izbranaLokacija.getNaslovUe());
      layout.addView(tv2);

      TextView tv3 = new TextView(this);
      tv3.setText(izbranTermin.getDatum() + ", ob " +izbranTermin.getUra());
      tv3.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
      ((ViewGroup.MarginLayoutParams) tv3.getLayoutParams()).setMargins(0, 20, 0, 0);
      layout.addView(tv3);

      TextView tv4 = new TextView(this);
      tv4.setText("Cena: " + izbranTermin.getCena() + "€");
      tv4.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
      ((ViewGroup.MarginLayoutParams) tv4.getLayoutParams()).setMargins(0, 30, 0, 0);
      layout.addView(tv4);

      Button btnTag = new Button(this);
      btnTag.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
      btnTag.setText("Nadaljuj");
      ((ViewGroup.MarginLayoutParams) btnTag.getLayoutParams()).setMargins(0, 50, 0, 0);
      btnTag.setOnClickListener(new View.OnClickListener(){
         public void onClick(View v) {
            ((ViewManager) tv1.getParent()).removeView(tv1);
            ((ViewManager) tv2.getParent()).removeView(tv2);
            ((ViewManager) tv3.getParent()).removeView(tv3);
            ((ViewManager) tv4.getParent()).removeView(tv4);
            ((ViewManager) btnTag.getParent()).removeView(btnTag);
            izberiNacinPlacila();
         }
      });
      layout.addView(btnTag);
   }
   
   
   public void izberiNacinPlacila() {
      LinearLayout layout = findViewById(R.id.llayout);
      ((TextView) findViewById(R.id.heading2)).setText("Izberite način plačila:");

      Button btnKartica = new Button(this);
      btnKartica.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
      btnKartica.setText("Kartica");
      btnKartica.setOnClickListener(new View.OnClickListener(){
         public void onClick(View v) {
            ((ViewManager) btnKartica.getParent()).removeView(btnKartica);
            zahtevajPodatkeKreditneKartice();
         }
      });
      layout.addView(btnKartica);
   }
   
   
   public void zahtevajPodatkeKreditneKartice() {

      LinearLayout layout = findViewById(R.id.llayout);
      ((TextView) findViewById(R.id.heading2)).setText("Vpišite podatke o kartici:");

      TextInputEditText ti = new TextInputEditText(this);
      ti.setWidth(600);
      ti.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
      ti.setHint("Lastnik kartice");
      ti.setText("Tilen Komel");
      layout.addView(ti);

      TextInputEditText ti1 = new TextInputEditText(this);
      ti1.setWidth(600);
      ti1.setHint("Številka kartice");
      ti1.setText("4716311137641971");
      layout.addView(ti1);

      TextInputEditText ti2 = new TextInputEditText(this);
      ti2.setMaxWidth(200);
      ti2.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
      ti2.setHint("mm/yy");
      ti2.setText("07/28");
      layout.addView(ti2);

      TextInputEditText ti3 = new TextInputEditText(this);
      ti3.setWidth(150);
      ti3.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
      ti3.setHint("ccv");
      ti3.setText("345");
      layout.addView(ti3);

      TextView tv = new TextView(this);
      tv.setMaxWidth(200);
      tv.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
      tv.setTextColor(Color.rgb(250, 0, 0));
      layout.addView(tv);

      Button btnPlacaj = new Button(this);
      btnPlacaj.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
      btnPlacaj.setText("Plačaj");
      btnPlacaj.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
            if (ti.getText().length() == 0) {
               tv.setText("Ime ne sme biti prazno!");
               return;
            } else if (!ti1.getText().toString().matches("\\d{16}")) {
               tv.setText("Številka kartice ni v pravem formatu!");
               return;
            } else if (!ti2.getText().toString().matches("(?:0[1-9]|1[0-2])/[0-9]{2}")) {
               tv.setText("Datum preteka ni v pravem formatu!");
               return;
            } else if (!ti3.getText().toString().matches("\\d{3}")) {
               tv.setText("Varnostna koda ni v pravem formatu!");
               return;
            }
            ((ViewManager) ti.getParent()).removeView(ti);
            ((ViewManager) ti1.getParent()).removeView(ti1);
            ((ViewManager) ti2.getParent()).removeView(ti2);
            ((ViewManager) ti3.getParent()).removeView(ti3);
            ((ViewManager) btnPlacaj.getParent()).removeView(btnPlacaj);
            ((ViewManager) tv.getParent()).removeView(tv);
            vnesiPodatkeKreditneKartice(ti.getText().toString(), ti1.getText().toString(), ti2.getText().toString(), ti3.getText().toString());
         }
      });
      layout.addView(btnPlacaj);

   }
   
   
   public void vnesiPodatkeKreditneKartice(String lastnik, String stKartice, String datumZapad, String ccv) {
      if (KPrijaviSeNaCPPIzpit.izvediTransakcijo(lastnik, stKartice, datumZapad, ccv)) {
         KPrijaviSeNaCPPIzpit.posljiRacunNaEposto();
         prikaziSporociloOUspesnemPlacilu();
      } else {
         prikaziSporociloONapaki();
      }
   }
   
   
   public void prikaziSporociloOUspesnemPlacilu() {
      prijavljenUporabnik.setPrijavljenNaCPPIzpit(true);
      ((TextView) findViewById(R.id.heading2)).setText("Uspeh! Prijava je bila uspešno zabeležena.");

      LinearLayout layout = findViewById(R.id.llayout);

      Button gumbNazaj = new Button(this);
      gumbNazaj.setText("Nazaj");
      gumbNazaj.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

      gumbNazaj.setOnClickListener(new View.OnClickListener(){
         public void onClick(View v) {
            ((ViewManager) gumbNazaj.getParent()).removeView(gumbNazaj);
            Intent intent = new Intent(ZmKandidatPrijaviSeNaCPPIzpit.this, UserProfile.class);
            startActivity(intent);
         }
      });

      layout.addView(gumbNazaj);
   }
   
   
   public void prikaziSporociloONapaki() {
      ((TextView) findViewById(R.id.heading2)).setText("Opps! Prišlo je do napake pri plačilu. Prosim poskusite ponovno.");

      LinearLayout layout = findViewById(R.id.llayout);

      Button gumbNazaj = new Button(this);
      gumbNazaj.setText("Nazaj");
      gumbNazaj.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

      gumbNazaj.setOnClickListener(new View.OnClickListener(){
         public void onClick(View v) {
            ((ViewManager) gumbNazaj.getParent()).removeView(gumbNazaj);
            Intent intent = new Intent(ZmKandidatPrijaviSeNaCPPIzpit.this, UserProfile.class);
            startActivity(intent);
         }
      });

      layout.addView(gumbNazaj);
   }

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.zm_kandidat_prijavi_se_na_cpp_izpit);

      zacniPrijavo();
   }

}