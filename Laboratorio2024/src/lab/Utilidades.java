package lab;

import java.util.Random;

public class Utilidades {
    public static String generarMAC() {
        Random rand = new Random();
        byte[] macAddr = new byte[6];
        rand.nextBytes(macAddr);

        //volverlo humanamente legible segun stackoverflow
        StringBuilder mac = new StringBuilder(18);
        for (byte b : macAddr) {
            if (!mac.isEmpty()) {
                mac.append(":");
            }
            mac.append(String.format("%02x", b));
        }
        return mac.toString().toUpperCase();
    }
}
