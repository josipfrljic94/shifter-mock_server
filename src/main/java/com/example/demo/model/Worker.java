package com.example.demo.model;

import java.util.List;

public class Worker {
    private String ime;
    private String prezime;
    private List<String> pozicije;
    private int brojSati;

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getPrezime() { return prezime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }


    public int getBrojSati() { return brojSati; }
    public void setBrojSati(int brojSati) { this.brojSati = brojSati; }

    @Override
    public String toString() {
        return "Worker{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", pozicija='" + pozicije.size() + '\'' +
                ", brojSati=" + brojSati +
                '}';
    }

    public List<String> getPozicije() {
        return pozicije;
    }

    public void setPozicije(List<String> pozicije) {
        this.pozicije = pozicije;
    }
}
