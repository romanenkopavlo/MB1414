package fr.btsciel;

import jssc.SerialPortException;

public class Ihm {
    public static void main(String[] args) {
        Mb1414 monMb1414 = new Mb1414();
        monMb1414.listerLesPorts().forEach(com -> System.out.println(com));
        String choix;
        try {
            System.out.println("Quel port?");
            choix = In.readString();
            monMb1414.initialisationCapteur(choix);
        } catch (SerialPortException e) {
            throw new RuntimeException(e);
        }
    }
}