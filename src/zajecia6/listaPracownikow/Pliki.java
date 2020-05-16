package zajecia6.listaPracownikow;

import javax.swing.text.html.HTML;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

class Pliki {

    private final String plik;
    private final Pracownik[] lista; // = new Pracownik[100];
    private final int liczbaPracownikow;
    private final int POLE_W_PLIKU_NAZWISKO = 0;
    private final int POLE_W_PLIKU_IMIE = 1;
    private final int POLE_W_PLIKU_PLEC = 2;
    private final int POLE_W_PLIKU_NR_DZIALU = 3;
    private final int POLE_W_PLIKU_PLACA = 4;
    private final int POLE_W_PLIKU_WIEK = 5;
    private final int POLE_W_PLIKU_LICZBA_DZIECI = 6;

    public Pliki(String plik) {
        this.plik = plik;
        this.lista = null;
        this.liczbaPracownikow = 0;
    }

    public Pliki(String plik, Pracownik[] lista, int liczbaPracownikow) {
        this.plik = plik;
        this.lista = lista;
        this.liczbaPracownikow = liczbaPracownikow;
    }

    public void exportAllToFile() throws Exception {
        if (lista != null) {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(plik));
            for (int i = 0; i < liczbaPracownikow; i++) {

                bufferedWriter.write(lista[i].getNazwisko() +
                        " " + lista[i].getImie() +
                        " " + lista[i].getPlec() +
                        " " + lista[i].getNrDzialu() +
                        " " + String.format(Locale.US, "%.2f", lista[i].getPlaca()) +
                        " " + lista[i].getWiek() +
                        " " + lista[i].getLiczbaDzieci() +
                        System.lineSeparator()
                );
            }
            bufferedWriter.close();
        }
    }

    void wyswietlDaneNajdluzszeNazwisko() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(plik));
        int dlugoscNajdluzszegoNazwiska = 0;
        String danePracownikaONajdluzszymNazwisku = "";
        String liniaDanych;
        String nazwisko;

        while ((liniaDanych = bufferedReader.readLine()) != null) {
            nazwisko = liniaDanych.split(" ")[0];
            if (nazwisko.length() > dlugoscNajdluzszegoNazwiska) {
                danePracownikaONajdluzszymNazwisku = liniaDanych;
                dlugoscNajdluzszegoNazwiska = nazwisko.length();
            }
        }

        if (dlugoscNajdluzszegoNazwiska > 0) {
            System.out.println(("Dane pracownika o najdłuższymm nazwisku:"));
            System.out.println(danePracownikaONajdluzszymNazwisku);
        } else {
            System.out.println("Brak danych w pliku");
        }
        Menu.nacisnijEnter();
    }

    void zakodujPlik() throws IOException {
            float sredniaPlaca = obliczSredniaPlaceZPliku();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(plik));
            StringBuilder stringBuilder = new StringBuilder();
            String liniaDanych;
            String[] rekord;
            float placa;
            while ((liniaDanych = bufferedReader.readLine()) != null) {
                rekord = liniaDanych.split(" ");
                placa = Float.parseFloat(rekord[POLE_W_PLIKU_PLACA]);
                if (placa < sredniaPlaca) {
                    rekord[POLE_W_PLIKU_NAZWISKO] = kodujNazwisko(rekord[POLE_W_PLIKU_NAZWISKO]);
                }
                liniaDanych = rekombinuj(rekord);
                stringBuilder.append(liniaDanych);
            }
            bufferedReader.close();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(plik));
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.close();

            System.out.println("Zakodowano.");
            System.out.println("Średnia płaca: " + sredniaPlaca);
            Menu.nacisnijEnter();

    }

    private String rekombinuj(String[] rekord) {
        StringBuffer rekombinowany = new StringBuffer();
        for (int i = 0; i < rekord.length; i++) {
            rekombinowany.append(rekord[i]);
            if (i < rekord.length - 1) {
                rekombinowany.append(" ");
            }
        }
        rekombinowany.append("\n");
        return rekombinowany.toString();
    }

    private String kodujNazwisko(String nazwisko) {
        return (nazwisko.charAt(0) + "*".repeat(nazwisko.length() - 2) + nazwisko.charAt(nazwisko.length() - 1));
    }

    float obliczSredniaPlaceZPliku() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(plik));
        int liczbaPracownikow = 0;
        float sumaPlac = 0.0f;
        String liniaDanych;
        String[] rekord;

        while ((liniaDanych = bufferedReader.readLine()) != null) {
            rekord = liniaDanych.split(" ");
            sumaPlac += Float.parseFloat(rekord[POLE_W_PLIKU_PLACA]);
            liczbaPracownikow++;
        }
        bufferedReader.close();

        if (liczbaPracownikow > 0) {
            return sumaPlac / (float) liczbaPracownikow;
        } else {
            return 0;
        }
    }

    void obliczSredniaWiekuOsobZDziecmi() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(plik));
        int sumaLat = 0;
        int liczbaPracownikowZDziecmi = 0;
        int liczbaDzieci;
        String liniaDanych;
        String[] rekord;

        while ((liniaDanych = bufferedReader.readLine()) != null) {
            rekord = liniaDanych.split(" ");
            liczbaDzieci = Integer.parseInt(rekord[POLE_W_PLIKU_LICZBA_DZIECI]);
            if (liczbaDzieci > 0) {
                sumaLat += Integer.parseInt(rekord[POLE_W_PLIKU_WIEK]);
                liczbaPracownikowZDziecmi++;
            }
        }

        if (liczbaPracownikowZDziecmi > 0) {
            System.out.println("Średni wiek pracowników z dziećmi wynosi: " +
                    (double) sumaLat / (double) liczbaPracownikowZDziecmi);
        } else {
            System.out.println("W pliku nie ma pracowników z dziećmi.");
        }
        Menu.nacisnijEnter();
    }

    void utworzHTML() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(plik));
        StringBuilder html = new StringBuilder();
        String liniaDanych;
        String[] rekord;

        html.append(preHTML());
        html.append(naglowkiTabeli());
        while ((liniaDanych = bufferedReader.readLine()) != null) {
            rekord = liniaDanych.split(" ");
            html.append("<tr>\n\t<td>");
            //html.append(liniaDanych.replace(" ", "</td>\n\t<td>"));
            html.append(
                    rekord[POLE_W_PLIKU_NAZWISKO]).append("</td>\n\t<td>")
                    .append(rekord[POLE_W_PLIKU_IMIE]).append("</td>\n\t<td>")
                    .append(rekord[POLE_W_PLIKU_PLEC]).append("</td>\n\t<td>")
                    .append(rekord[POLE_W_PLIKU_NR_DZIALU]).append("</td>\n\t<td>")
                    .append(rekord[POLE_W_PLIKU_PLACA]).append("</td>\n\t<td>")
                    .append(rekord[POLE_W_PLIKU_WIEK]).append("</td>\n\t<td>");
                    // bez liczby dzieci zgdodnie z założeniami zadania
            html.append("</td>\n</tr>\n");
        }
        bufferedReader.close();
        html.append(postHTML());

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ListaPracownikow.BASE_PATH +
                "pracownicy.html"));
        bufferedWriter.write(html.toString());
        bufferedWriter.close();
    }

    private String preHTML() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">" +
                "<body>\n" +
                "<table class=\"w3-table-all\">\n";
    }

    private String naglowkiTabeli() {
        // nie robimy kolumny dla liczby dzieci zgodnie z warunkami zadania
        return "<tr>\n\t" +
                "<th>Nazwisko</th>\n\t" +
                "<th>Imię</th>\n\t" +
                "<th>Płeć</th>\n\t" +
                "<th>Nr działu</th>\n\t" +
                "<th>Płaca</th>\n\t" +
                "<th>Wiek</th>\n\t" +
                "</tr>\n";
    }

    private String postHTML() {
        return "</table>\n" +
                "</body>\n" +
                "</html>";
    }
}
