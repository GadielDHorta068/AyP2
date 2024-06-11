/**
 * Capa con el modelo de clases que seran usadas en la logica
 */
package lab.modelo;

/**
 * Clase Computadora
 */
public class Computadora extends Nodo {
    /**
     * Constructor de Computadora
     *
     * @param id         Nombre del Nodo
     * @param ipAddress  Direccion IP a asignar
     * @param macAddress Direccion MAC a obtener
     * @param status     Nodo Activo o Inactivo
     * @param ubicacion  Ubicacion Fisica del dispositivo
     */
    public Computadora(String id, String ipAddress, String macAddress, boolean status, String ubicacion) {
        super(id, ipAddress, macAddress, status, ubicacion);
    }
}
