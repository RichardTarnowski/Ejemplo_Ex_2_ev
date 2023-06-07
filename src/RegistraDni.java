import java.io.*;
import java.util.Scanner;

public class RegistraDni {
     Scanner scanner = new Scanner(System.in);
    String dni;

    public RegistraDni(){

        System.out.println("Por favor, introduce un dni para registrarlo:");
        dni = scanner.next();
        if (comprobadorDNI()){
            escribirFichero();
            System.out.println("El DNI introducido se ha registrado.");
            leerFichero();
        } else{
            System.out.println("El DNI no es correcto, por lo que NO se ha registrado.");
        }


    }
    private boolean comprobadorDNI(){
        String letter = dni.substring(dni.length()-1);
        String dniNumber = dni.substring( 0,dni.length()-1);

        int dniTrueNumber = Integer.parseInt(dniNumber);


        int valueToFindDniLetter;
        valueToFindDniLetter = dniTrueNumber % 23;

        String dniLetter = switch (valueToFindDniLetter) {
            case 0 -> "T";
            case 1 -> "R";
            case 2 -> "W";
            case 3 -> "A";
            case 4 -> "G";
            case 5 -> "M";
            case 6 -> "Y";
            case 7 -> "F";
            case 8 -> "P";
            case 9 -> "D";
            case 10 -> "X";
            case 11 -> "B";
            case 12 -> "N";
            case 13 -> "J";
            case 14 -> "Z";
            case 15 -> "S";
            case 16 -> "Q";
            case 17 -> "V";
            case 18 -> "H";
            case 19 -> "L";
            case 20 -> "C";
            case 21 -> "K";
            case 22 -> "E";
            default -> "no_match";
        };


        return dniLetter.equals(letter.toUpperCase());



    }

    private void escribirFichero(){

        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("dni.bin", true));
            out.writeUTF(dni);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void leerFichero(){
        System.out.println("Estos son los dni introducidos hasta ahora: ");
        try {
            DataInputStream in = new DataInputStream(new FileInputStream("dni.bin"));

            while(true){
                System.out.println(in.readUTF());

            }

        } catch (IOException ignored) {

        }
    }


}
