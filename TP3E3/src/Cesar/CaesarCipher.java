package Cesar;

public class CaesarCipher {
	
	// M�todo para cifrar un mensaje utilizando el cifrado C�sar
	public static String encrypt(String message, int shift) {
		
        StringBuilder encryptedMessage = new StringBuilder();
        
        //Encriptar cada caracter del mensaje
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            //Es una letra?
            if (Character.isLetter(currentChar)) {
            	
                // Obtener el c�digo Unicode del car�cter actual
                int unicodeCode = (int) currentChar;
                
                // Aplicar el desplazamiento
                int shiftedUnicode = unicodeCode + shift;

                // Ajustar el desplazamiento para respetar las mayusculas
                if (Character.isUpperCase(currentChar)) {
                    if (shiftedUnicode > 'Z') {
                        shiftedUnicode -= 27;
                    } else if (shiftedUnicode < 'A') {
                        shiftedUnicode += 27;
                    }
                } else {
                    if (shiftedUnicode > 'z') {
                        shiftedUnicode -= 27;
                    } else if (shiftedUnicode < 'a') {
                        shiftedUnicode += 27;
                    }
                }

                // Obtener el car�cter cifrado y agregarlo al mensaje cifrado
                encryptedMessage.append((char) shiftedUnicode);
            } else {
                // Si el car�cter no es una letra, agregar tal cual al mensaje cifrado
                encryptedMessage.append(currentChar);
            }
        }

        return encryptedMessage.toString();
    }
	
}
