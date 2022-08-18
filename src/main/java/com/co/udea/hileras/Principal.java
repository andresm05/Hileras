/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.udea.hileras;

/**
 *
 * @author HOME
 */
public class Principal {

    public static void main(String[] args) {
        /*compareTo retorna un entero negativo si el objeto que invoca el método
        antecede al argumento; de lo contrario, retorna un entero positivo
        El resultado es 0 si la comparación es igual*/
        //System.out.println(ensayo.compareTo("dia"));
        String ensayo = "arroz";
        /*Conocer la longitud de la lista*/
        //System.out.println(ensayo.length());
        /*Concatenar Strings*/
        //System.out.println(ensayo.concat("buenos"));
        /* Método posición */
        System.out.println(ensayo.indexOf("o"));

        /*Método Subhilera*/
        System.out.println(ensayo.substring(2, 3));

        String texto = "la liebre libre ebria brava, brava la liebre libre sobria.";
        String texto2 = "quien es cualquier miau, dice guau miau miau pero quiere guau.";
        String texto3 = "El suelo esta entarabicuadriculado, ¿quien lo desentarabicuadriculara? El buen desentarabicuadriculador que lo desentarabicuadricule, buen desentarabicuadriculador sera.";
        String br = "brabrebribrobru";
        Hilera palabra;
        String c1 = "arroz";

        Hilera m = new Hilera(ensayo);
        //System.out.println(m.empiezaConTresSilabas(br));
        //System.out.println(m.cantidadLetras(consonantes, m.getCadena()));
        //System.out.println(m.esTriptongo(m.getCadena()));
        //System.out.println(m.frecuenciaLetra("c", m.getCadena()));
        //System.out.println(m.tieneMasDeTresConsonantesRep(m.getCadena()));
        //System.out.println(m.ordenarLetras(m.getCadena()));
        //System.out.println(m.sonAnagramas(c1));

        palabra = new Hilera(texto3);

        //Algoritmo para contar las veces que aparece una palabra con más de 5 consonantes diferentes
        //palabra.contarPablabrasConMasDeCincoConsonantesDf();
        //Algoritmo para contar las veces que aparece una palabra que contenga br en un texto
        //palabra.contarPablabrasConTresSilabas(br);
        //Algoritmo para contar las palabras que tengan triptongo
        //palabra.contarPablabrasConTriptongo();
    }
}
