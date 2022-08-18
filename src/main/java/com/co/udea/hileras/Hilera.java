/*
 */
package com.co.udea.hileras;

import javax.print.attribute.standard.JobStateReason;

/**
 *
 * @author HOME
 */
public class Hilera {

    private String cadena;
    public static final String ABCDARIO = "abcdefghijklmnñopqrstuvwxyz";
    public static final String CONSONANTES = "bcdfghjklmnñpqrstvwxyz";

    public Hilera(String cadena) {
        this.cadena = cadena;
    }

    public boolean empiezaConTresSilabas(String letras) {
        int j = 0;
        String silaba = letras.substring(j, j + 3);
        int k = cadena.indexOf(silaba);
        while (k != 0 && j < letras.length() - 3) {
            j = j + 3;
            silaba = letras.substring(j, j + 3);
            k = cadena.indexOf(silaba);
        }
        return k == 0;

    }

    /*La cadena que recibe el método es por ejemplo: "brabrebribrobru"*/
    public boolean contieneTresSilabas(String cadena, String palabra) {
        int m = 0;
        int t = 0;
        String silaba;
        while (m <= cadena.length() - 2) {
            silaba = cadena.substring(m, m + 3);
            if (palabra.contains(silaba)) {
                t = 1;
            }
            m = m + 3;
        }
        return t == 1;
    }

    public boolean esTriptongo(String palabra) {
        String vocales = "aeiou";
        int i, t, n, k;
        String m;
        i = 0;
        n = palabra.length();
        while (i <= n - 1) {
            m = palabra.substring(i, i + 1);
            t = 0;
            k = 0;
            while (vocales.contains(m) && k == 0) {
                t++;
                i++;
                if (i <= n - 1) {
                    m = palabra.substring(i, i + 1);
                } else {
                    k = 1;
                }
            }
            if (t == 3) {
                return true;
            }
            i++;
        }
        return false;
    }

    /*El método cuenta la cantidad de letras diferentes que tiene una palabra dada según la cadena
    es decir, cadena puede ser: consonantes, vocales, etc.*/
    public int cantidadLetrasDf(String cadena, String palabra) {
        String letra;
        int m, n;
        m = 0;
        n = cadena.length();
        for (int i = 0; i < n; i++) {
            letra = cadena.substring(i, i + 1);
            if (palabra.contains(letra)) {
                m++;
            }
        }
        return m;
    }
    
    /*Ordena las letras de una palabra dada ascendentemente*/
    public String ordenarLetras(String palabra) {
        String result = "";
        String car;
        int frec;
        int n = ABCDARIO.length();
        for (int i = 0; i < n; i++) {
            car = ABCDARIO.substring(i, i + 1);
            if (palabra.contains(car)) {
                frec = frecuenciaLetra(car, palabra);
                for (int j = 0; j < frec; j++) {
                    result = result.concat(car);
                }
            }
        }
        return result;
    }

    /*El método cuenta el total de recurrencias que tiene una letra dada en una palabra*/
    public int frecuenciaLetra(String letra, String palabra) {
        int cont = 0;
        String car;
        int n = palabra.length();
        for (int i = 0; i < n; i++) {
            car = palabra.substring(i, i + 1);
            if (car.equalsIgnoreCase(letra)) {
                cont++;
            }
        }
        return cont;
    }

    public boolean tieneCincoOMasConsonantesDf(String palabra) {
        int cantidad = cantidadLetrasDf(CONSONANTES, palabra);
        return cantidad >= 5;
    }

    /*Determina si una palabra tiene al menos una consonante repetida 3 o más veces*/
    public boolean tieneMasDeTresConsonantesRep(String palabra) {
        String car;
        int cont = 0;
        for (int i = 1; i < ABCDARIO.length(); i++) {
            car = ABCDARIO.substring(i, i + 1);
            if (palabra.contains(car)) {
                cont = frecuenciaLetra(car, palabra);
                if (cont >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean sonAnagramas(String palabra) {
        String m = ordenarLetras(palabra);
        String n = ordenarLetras(cadena);
        return m.equalsIgnoreCase(n);
    }

    public String siguientePalabra(int i) {
        String abcdario = "abcdefghijklmnñopqrstuvwxyz";
        int j, k;
        String car = getCadena().substring(i, i + 1);
        k = abcdario.indexOf(car);
        while (k == -1 && i + 1 < getCadena().length()) {
            i++;
            car = getCadena().substring(i, i + 1);
            k = abcdario.indexOf(car);
        }
        j = i;
        while (k != -1 && i < getCadena().length()) {
            i++;
            car = getCadena().substring(i, i + 1);
            k = abcdario.indexOf(car);
        }
        String palabra = getCadena().substring(j, i);
        return palabra;
    }

    public void contarPablabrasConMasDeCincoConsonantesDf() {
        String palabra;
        String palabras[] = new String[100];
        int frec[] = new int[100];
        int i, k, j;
        i = 0;
        k = 0;
        int n = getCadena().length();
        while (i < n) {
            palabra = this.siguientePalabra(i);
            if (tieneCincoOMasConsonantesDf(palabra)) {
                palabras[k] = palabra;
                j = 0;
                while (!palabras[j].equals(palabra)) {
                    j++;
                }
                if (j == k) {
                    frec[k] = 1;
                    k++;
                } else {
                    frec[j] = frec[j] + 1;
                }
            }
            i = i + palabra.length() + 1;
        }
        palabras[k] = null;
        ordena(palabras, frec);
    }

    public void contarPablabrasConTresSilabas(String cadena) {
        String palabra;
        String palabras[] = new String[100];
        int frec[] = new int[100];
        int i, k, j;
        i = 0;
        k = 0;
        int n = getCadena().length();
        while (i < n) {
            palabra = this.siguientePalabra(i);
            if (contieneTresSilabas(cadena, palabra)) {
                palabras[k] = palabra;
                j = 0;
                while (!palabras[j].equals(palabra)) {
                    j++;
                }
                if (j == k) {
                    frec[k] = 1;
                    k++;
                } else {
                    frec[j] = frec[j] + 1;
                }
            }
            i = i + palabra.length() + 1;
        }
        palabras[k] = null;
        ordena(palabras, frec);
    }

    public void contarPablabrasConTriptongo() {
        String palabra;
        String palabras[] = new String[100];
        int frec[] = new int[100];
        int i, k, j;
        i = 0;
        k = 0;
        int n = getCadena().length();
        while (i < n) {
            palabra = this.siguientePalabra(i);
            if (esTriptongo(palabra)) {
                palabras[k] = palabra;
                j = 0;
                while (!palabras[j].equals(palabra)) {
                    j++;
                }
                if (j == k) {
                    frec[k] = 1;
                    k++;
                } else {
                    frec[j] = frec[j] + 1;
                }
            }
            i = i + palabra.length() + 1;
        }
        palabras[k] = null;
        ordena(palabras, frec);
    }

    public void ordena(String[] palabras, int[] frec) {
        int n = palabras.length;
        String aux;
        int aux2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (j < n - 1) {
                    if (palabras[j + 1] == null) {
                    } else {
                        if (palabras[j].compareTo(palabras[j + 1]) > 0) {
                            aux = palabras[j + 1];
                            palabras[j + 1] = palabras[j];
                            palabras[j] = aux;
                            aux2 = frec[j + 1];
                            frec[j + 1] = frec[j];
                            frec[j] = aux2;
                        }
                    }
                }

            }
        }

        for (int h = 0; h < palabras.length; h++) {
            if (palabras[h] != null) {
                System.out.println(palabras[h] + ": " + frec[h]);
            }
        }
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

}
