package fr.btsciel;

import jssc.SerialPortEvent;
import jssc.SerialPortException;

import java.util.ArrayList;

public class Mb1414 extends LiaisonSerie {
    private double distance;

    public Mb1414() {
    }
    public void calcul (SerialPortEvent spe) {

    }
    public void deconnexionCapteur() {
        super.fermerPort();
    }
    public void initialisationCapteur(String port) throws SerialPortException {
        initCom(port);
        super.configurerParametres(57600, 8, 0, 1);
    }
    public double getDistance() {
        return distance;
    }
    public ArrayList<String> listerLesPorts() {
        return super.listerLesPorts();
    }
    public void serialEvent(SerialPortEvent spe) {
        byte [] laTrame;
        int longeur;
        longeur = spe.getEventValue();
        laTrame = lireTrame(longeur);
        distance = laTrame[0] & 0xff;
        System.out.println(distance);
    }
}
