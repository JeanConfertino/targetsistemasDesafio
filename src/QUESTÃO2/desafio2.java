package QUESTÃO2;

import java.util.Scanner;

public class desafio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário o número a ser verificado
        System.out.print("Informe um número: ");
        int num = scanner.nextInt();

        // Chama o método para verificar se o número pertence à sequência de Fibonacci
        if (isFibonacci(num)) {
            System.out.println(num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(num + " não pertence à sequência de Fibonacci.");
        }
    }

    // Método que verifica se o número pertence à sequência de Fibonacci
    public static boolean isFibonacci(int n) {
        if (n == 0 || n == 1) {
            return true; // 0 e 1 pertencem à sequência de Fibonacci
        }

        int a = 0, b = 1;
        int fibonacci = a + b;

        // Gera a sequência de Fibonacci até o valor ser maior ou igual ao número informado
        while (fibonacci <= n) {
            if (fibonacci == n) {
                return true;
            }
            a = b;
            b = fibonacci;
            fibonacci = a + b;
        }
        return false;
    }
}
