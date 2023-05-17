package com.avtosola.pici.miki;

public class SvPrijaviSeNaCPPIzpitInformacijskiSistemUprave {

    public static Lokacija[] pridobiSeznamLokacij() {
        Lokacija NovaGorica = new Lokacija("Upravna enota Nova Gorica", "Gregoričieva ulica 12, 5000 Nova Gorica");
        Lokacija Ljubljana = new Lokacija("Upravna enota Tobačna Ljubljana", "Tobačna 69, 1000 Ljubljana");
        Lokacija Maribor = new Lokacija("Upravna enota Maribor", "Ulica Totega Štajrca, 2000 Maribor");

        Lokacija[] lokacije = {NovaGorica, Ljubljana, Maribor};

        return lokacije;
    }
    public static Termini[] pridobiSeznamProstihTerminov() {
        Termini dopoldne7 = new Termini("22.9.2023", "7:00", 45.0);
        Termini dopoldne9 = new Termini("22.9.2023", "9:00", 45.0);
        Termini popoldne13 = new Termini("22.9.2023", "13:00", 45.0);

        return new Termini[]{dopoldne7, dopoldne9, popoldne13};
    }
}
