package lab.clases;

import java.util.Random;

public class Utilidades {
    public static String generarMAC() {
        Random rand = new Random();
        byte[] macAddr = new byte[6];
        rand.nextBytes(macAddr);

        //volverlo humanamente legible segun stackoverflow
        StringBuilder mac = new StringBuilder(18);
        for (byte b : macAddr) {
            if (mac.length() == 0) {
                mac.append(":");
            }
            mac.append(String.format("%02x", b));
        }
        return mac.toString().toUpperCase();
    }

    public static void asignarDireccion(Nodo router, Nodo pc) {
        if (Router.class != pc.getClass()) {
            String[] segmentos = router.getIpAddress().split("\\.");
            if (segmentos.length != 4) {
                throw new IllegalArgumentException("Direccion IP invilida");
            }
            int ultimoSegmento = Integer.parseInt(segmentos[3]);
            ultimoSegmento = router.nuevaIP();
            segmentos[3] = String.valueOf(ultimoSegmento);
            pc.setIpAddress(String.join(".", segmentos));
        }
    }
}
