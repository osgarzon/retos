package retos;

import java.util.Scanner;

/**
 *
 * @author Oscar Garzon
 */
public class Reto1 {

    public static void main(String[] args) {
        Reto1 reto1 = new Reto1();
        reto1.run();
    }
    private final Scanner scanner = new Scanner(System.in);

    public String read() {
        return this.scanner.nextLine();
    }

    public void run() {
        String num = read();
        float masa = Float.parseFloat(num.split(" ")[0]);
        float altura = Float.parseFloat(num.split(" ")[1]);
        float edad = Float.parseFloat(num.split(" ")[2]);
        double imc;

        if (masa < 0 || masa > 150 || altura < 0.1 || altura > 2.5 || edad < 0 || edad > 110) {
            System.out.println("ERROR");
        } else {
            imc=  Math.round(masa/Math.pow(altura, 2)*10);
            imc= imc/10;
            if(imc<22 && edad<45){
                System.out.println(imc +" Bajo");
            }else if(imc<22 && edad>=45||imc>=22 && edad<45){
                System.out.println(imc +" Medio");               
            }else if(imc>=22 && edad>=45){
                System.out.println(imc +" Alto");
            }
        }
    }
}
