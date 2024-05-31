import datastructures.ChainHashMap;
import datastructures.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final Set<String> PALABRAS_RESERVADAS = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
            "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
            "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "null", "package", "private", "protected",
            "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
    ));

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Main.java <source-file>");
            return;
        }

        String fileName = args[0];
        Map<String, Integer> wordCountMap = new ChainHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\W+");
                for (String token : tokens) {
                    if (PALABRAS_RESERVADAS.contains(token)) {
                        Integer count = wordCountMap.get(token);
                        if (count == null) {
                            wordCountMap.put(token, 1);
                        } else {
                            wordCountMap.put(token, count + 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Problema al leer el archivo"+ e);
        }

        // Print the occurrences of each reserved word
        System.out.println("Cantidad de palabras reservadas:");
        for (String word : wordCountMap.keySet()) {
            System.out.println(word + ": " + wordCountMap.get(word));
        }
    }

}