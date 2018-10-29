package GUI;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ejemplo sobre recepción de datos desde Java hasta Arduino
 *
 * @author Antony García González
 */
public class JavaRX {

    //Se crea una instancia de la librería PanamaHitek_Arduino
    private static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private static final SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ino.isMessageAvailable()) {
                    //Se imprime el mensaje recibido en la consola
                    String info=ino.printMessage();
                    if(info.length()>24){
                        String x = info.substring(2,6);
                        x=x.replace("|","");
                        x=x.replaceAll("\\s","");
                        String Y = info.substring(11,15);
                        Y=Y.replace("|","");
                        Y=Y.replace("P","0");
                        Y=Y.replaceAll("\\s","");
                        String boton=info.substring(24);
                        boton=boton.replace(":","");
                        boton=boton.replace("r","");
                        boton=boton.replace("o","");
                        boton=boton.replace("d","");
                        boton=boton.replaceAll("\\s","");
                        int valorY = Integer.parseInt(x);
                        int valorX = Integer.parseInt(Y);
                        int valorBoton = Integer.parseInt(boton);

                        if(valorX<519) {
                            //valorX=valorX*-1;
                            valorX=5;


                        }
                        if(valorY<507) {
                            valorY=5;


                        }
                        if(valorX>520) {
                            valorX=-5;

                        }
                        if(valorY>508) {
                            //valorX=valorX*-1;
                            valorY=-5;
                        }
                        if (valorX==519||valorX==520){
                            valorX=0;
                            //System.out.println("el x esta en cero");
                        }
                        if(valorY==507||valorY==508){
                            valorY=0;
                            //System.out.println("el y esta en cero");
                        }
                        System.out.println(valorX+"ese fue x"+valorY+"ese fue Y");
                    }
                    else{
                        String x = info.substring(2,6);
                        x=x.replace("|","");
                        String Y = "0";
                        Y=Y.replace("|","");
                        String boton=info.substring(22);
                        boton=boton.replace(":","");
                        boton=boton.replace("r","");
                        boton=boton.replace("o","");
                        boton=boton.replace("d","");
                        x=x.replaceAll("\\s","");
                        Y=Y.replaceAll("\\s","");
                        boton=boton.replaceAll("\\s","");
                        //System.out.println("x es "+x+"el ye es"+Y+info);
                        int valorY = Integer.parseInt(x);
                        int valorX = Integer.parseInt(Y);
                        int valorBoton = Integer.parseInt(boton);
                        /*valorX=valorX-519;
                        valorX=valorX*-1;
                        valorY=valorY-507;
                        valorX=valorX*-1;*/
                        System.out.println(valorX+"ese fue x"+valorY+"ese fue Y");

                    }

                }
            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(JavaRX.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    };

    public static void main(String[] args) {
        try {
            ino.arduinoRX("/dev/ttyUSB1", 9600, listener);
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(JavaRX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}