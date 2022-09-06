package retos;

import java.util.Scanner;

/**
 * para los retos despues del main se debe compiar de la linea 10 a la 31 de la pagina 
 * desarrollar todo en la clase run y al final instanciar la misma clase para ejecutar run
 * @author Oscar Garzon
 */
public class Reto0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Reto0 reto0 =new Reto0();
        reto0.run();
    }

    private final Scanner scanner = new Scanner(System.in);

    public String read() {
        return this.scanner.nextLine();
    }

    public void run() {
        String num = read();
        float x = Float.parseFloat(num.split(" ")[0]);
        float y = Float.parseFloat(num.split(" ")[1]);

        System.out.println(sumar(x, y) + " " + multiplicar(x, y));
    }

    public float sumar(float x, float y) {
        return x + y;
    }

    public float multiplicar(float x, float y) {
        return x * y;
    }
}
