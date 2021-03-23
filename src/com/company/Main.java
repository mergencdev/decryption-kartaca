package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        writeList();
        //fileCounter();
    }

    static void writeList() throws FileNotFoundException {
        String binary;
        int counter = 0;
        File directoryPath = new File("C:\\Users\\merge\\Desktop\\=\\O");

        char[] letters;

        for (File file : directoryPath.listFiles()) {
            //System.out.println(file.getName() + ":");
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String fileName = file.getName();
                String line = read.nextLine();
                binary = line;
                //System.out.println(line + " ");

                letters = fileName.toCharArray();
                /*if (Character.isUpperCase(letters[0]) && Character.isUpperCase(letters[1]) && Character.isUpperCase(letters[2])) {
                    System.out.println(fileName);
                    System.out.println(binaryToText(binary));
                    System.out.println("---------------------------------------------");
                }*/
                System.out.println(fileName);
                System.out.println(binaryToText(binary));
                System.out.println("---------------------------------------------");
                //S.out.println("---------------------------------------------------------------------------------");
            }
            read.close();
        }
    }

    static void fileCounter() throws FileNotFoundException {
        String binary;
        int counter = 0;
        File directoryPath = new File("C:\\Users\\merge\\Desktop\\kartaca");

        char[] letters;

        for (File file : directoryPath.listFiles()) {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String fileName = file.getName();
                String line = read.nextLine();
                binary = line;
                letters = fileName.toCharArray();

                if (letters[2] != '=' && letters[3] != '=') {
                    counter++;
                }
            }
            read.close();
        }

        System.out.println(counter);
    }

    public static String binaryToText(String binaryText) {
        String[] binaryNumbers = binaryText.split(" ");
        String text = "";

        for (String currentBinary : binaryNumbers) {
            int decimal = binaryToDecimal(currentBinary);
            char letter = (char) decimal;
            text += letter;
        }
        return text;
    }

    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int position = 0;
        for (int x = binary.length() - 1; x >= 0; x--) {

            short digit = 1;
            if (binary.charAt(x) == '0') {
                digit = 0;
            }
            double multiplier = Math.pow(2, position);
            decimal += digit * multiplier;
            position++;
        }
        return decimal;
    }
}