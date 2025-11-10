package com.campusdual.classroom;

import com.campusdual.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise {

    public static void main(String[] args) {
        String text = generateStringToSave(null);
        printToFile(text);
    }

    public static String generateStringToSave(String string) {
        if (string == null){
            return generateUserInputToSave();
        }else {
            return string;
        }
    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        String filePath = "src/main/resources/data.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write(string);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
