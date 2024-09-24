package QUESTÃO5;

import java.util.Scanner;

public class desafio5 {
    public static void main(String[] args) {
        // Entrada de dados através do teclado
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma string: ");
        String input = scanner.nextLine();

        // String invertida
        String invertida = "";

        // Invertendo a string manualmente
        for (int i = input.length() - 1; i >= 0; i--) {
            invertida += input.charAt(i);
        }

        // Exibindo o resultado
        System.out.println("String invertida: " + invertida);

        scanner.close();
    }
}
