package com.avtosola.pici.miki;

public class KPrijaviSeNaCPPIzpit {
    public SvPrijaviSeNaCPPIzpitInformacijskiSistemUprave svPrijaviSeNaCPPIzpitInformacijskiSistemUprave;
    public SvPrijaviSeNaCPPIzpitBancniSistem svPrijaviSeNaCPPIzpitBancniSistem;
    public Kandidat kandidat;
    public java.util.Collection lokacija;
    public java.util.Collection termini;
    public SvPrijaviSeNaCPPIzpitSistemZaEposto svPrijaviSeNaCPPIzpitSistemZaEposto;

    public void vrniSeznamLokacij() {
        // TODO: implement
    }

    public void vrniSeznamProstihTerminov() {
        // TODO: implement
    }

    public void vrniPovzetekPrijave() {
        // TODO: implement
    }

    public void izvediTransakcijo() {
        // TODO: implement
    }

    public int vrniSporčiloOUspešnemPlačilu() {
        // TODO: implement
        return 0;
    }

    public int vrniSporočiloONapaki() {
        // TODO: implement
        return 0;
    }

    public void pošljiRačunNaEpošto() {
        // TODO: implement
    }


    public java.util.Collection getLokacija() {
        if (lokacija == null)
            lokacija = new java.util.HashSet();
        return lokacija;
    }

    public java.util.Iterator getIteratorLokacija() {
        if (lokacija == null)
            lokacija = new java.util.HashSet();
        return lokacija.iterator();
    }

    public void setLokacija(java.util.Collection newLokacija) {
        removeAllLokacija();
        for (java.util.Iterator iter = newLokacija.iterator(); iter.hasNext();)
            addLokacija((Lokacija)iter.next());
    }

    public void addLokacija(Lokacija newLokacija) {
        if (newLokacija == null)
            return;
        if (this.lokacija == null)
            this.lokacija = new java.util.HashSet();
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
    public java.util.Collection getTermini() {
        if (termini == null)
            termini = new java.util.HashSet();
        return termini;
    }

    public java.util.Iterator getIteratorTermini() {
        if (termini == null)
            termini = new java.util.HashSet();
        return termini.iterator();
    }

    public void setTermini(java.util.Collection newTermini) {
        removeAllTermini();
        for (java.util.Iterator iter = newTermini.iterator(); iter.hasNext();)
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
