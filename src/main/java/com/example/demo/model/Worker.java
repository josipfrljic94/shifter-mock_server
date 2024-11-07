package com.example.demo.model;

public class Worker {
    private String ime;
    private String prezime;
    private String pozicija;
    private int brojSati;

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getPrezime() { return prezime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }

    public String getPozicija() { return pozicija; }
    public void setPozicija(String pozicija) { this.pozicija = pozicija; }

    public int getBrojSati() { return brojSati; }
    public void setBrojSati(int brojSati) { this.brojSati = brojSati; }

    @Override
    public String toString() {
        return "Worker{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", pozicija='" + pozicija + '\'' +
                ", brojSati=" + brojSati +
                '}';
    }
}
