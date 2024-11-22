package com.miempresa.clienteiot;

import main.java.com.miempresa.clienteiot.DispositiuIot;

public class clientIoT {
    public static void main(String[] args) {
        DispositiuIot dispositiu = new DispositiuIot();
        System.out.println("");
        try{
            dispositiu.conecta();
            dispositiu.subscriu();
        } catch (Exception e){
            System.err.println("Error IoT: "+e.getLocalizedMessage());
        }
    }
}