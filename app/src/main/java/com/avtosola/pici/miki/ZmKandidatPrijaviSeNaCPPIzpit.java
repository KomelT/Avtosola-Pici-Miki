package com.avtosola.pici.miki;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

import java.util.ArrayList;

@SuppressWarnings("NonAsciiCharacters")
public class ZmKandidatPrijaviSeNaCPPIzpit  extends AppCompatActivity {

    private Lokacija[] lokacije;
    private Termini[] termini;
    private Lokacija izbranaLokacija;
    private Termini izbranTermin;
    private ArrayList<Button> lokacijeButton = new ArrayList<>();
    private ArrayList<Button> terminiButton = new ArrayList<>();

    public void začniPrijavo() {
        lokacije = KPrijaviSeNaCPPIzpit.vrniSeznamLokacij();
        prikažiSeznamLokacij();
    }
    public void prikažiSeznamLokacij() {
        LinearLayout layout = findViewById(R.id.llayout);

        for (Lokacija lokacija : lokacije) {
            Button btnTag = new Button(this);
            btnTag.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
            btnTag.setText(lokacija.getNaziv());
            btnTag.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    izberiLokacijo(lokacija);
                }
            });
            lokacijeButton.add(btnTag);
            layout.addView(btnTag);
        }
    }
    public void izberiLokacijo(Lokacija lokacija) {
        izbranaLokacija = lokacija;
        for (Button lokacijaB : lokacijeButton) {
            ((ViewManager) lokacijaB.getParent()).removeView(lokacijaB);
        }

        prikažiProsteTermineZaIzbranoLokacijo();
    }
    public void prikažiProsteTermineZaIzbranoLokacijo() {
        termini = KPrijaviSeNaCPPIzpit.vrniSeznamProstihTerminov();
        LinearLayout layout = findViewById(R.id.llayout);
        ((TextView) findViewById(R.id.heading2)).setText("Izberi termin za opravljanje izpita:");

        for (Termini termin : termini) {
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
        izbranTermin = termin;
        for (Button terminB : terminiButton) {
            ((ViewManager) terminB.getParent()).removeView(terminB);
        }
        prikažiPovzetekPrijave();
    }
    public void prikažiPovzetekPrijave() {
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
                izberiNačinPlačila();
            }
        });
        layout.addView(btnTag);

    }
    public void izberiNačinPlačila() {
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
        layout.addView(ti);

        TextInputEditText ti1 = new TextInputEditText(this);
        ti1.setWidth(600);
        ti1.setHint("Številka kartice");
        layout.addView(ti1);

        TextInputEditText ti2 = new TextInputEditText(this);
        ti2.setMaxWidth(200);
        ti2.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        ti2.setHint("mm/yy");
        layout.addView(ti2);

        TextInputEditText ti3 = new TextInputEditText(this);
        ti3.setWidth(150);
        ti3.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        ti3.setHint("ccv");
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
                vnesiPodatkeKreditneKartice();
            }
        });
        layout.addView(btnPlacaj);

    }
    public void vnesiPodatkeKreditneKartice() {
    }
    public void prikažiSporočiloOUspešnemPlačilu() {
        // TODO: implement
    }
    public void prikažiSporočiloONapaki() {
        // TODO: implement
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zm_kandidat_prijavi_se_na_cpp_izpit);

        začniPrijavo();
    }
}
