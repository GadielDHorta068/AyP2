package Cesar;

public class TestCesar {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String message = "Jugemos un Age Of Empires con @madorni!сс";
        int shift = 1;
        String MensajeEncriptado = CaesarCipher.encrypt(message, shift);
        System.out.println("Mensaje original: " + message);
        System.out.println("Mensaje cifrado: " + MensajeEncriptado);
        String MensajeDecriptado = CaesarCipher.encrypt(MensajeEncriptado, shift*-1);
        System.out.println("Mensaje decifrado: " + MensajeDecriptado);
	}
}
