// Alumno: Quetzalcoatl Yael Cruz Barron
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        NumerosParImpar npi = new NumerosParImpar();
        //npi.valida(19);
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un numero");
        int num = sc.nextInt();
        npi.validar(num);
    }
}

