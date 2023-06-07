import java.io.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        BufferedReader in;
        {
            try {
                in = new BufferedReader( new FileReader("Ejercicio1.txt"));

                int reads = in.read();

                while(reads !=-1){
                    System.out.print((char) reads);
                    reads = in.read();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
