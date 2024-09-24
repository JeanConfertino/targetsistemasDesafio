package QUESTÃO3;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class desafio3 {

    public static void main(String[] args) {
        String jsonData = lerArquivo("faturamento.json");
        if (jsonData != null) {
            calcularFaturamento(jsonData);
        }
    }

    private static String lerArquivo(String caminho) {
        try {
            return new String(Files.readAllBytes(Paths.get(caminho)));
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }

    private static void calcularFaturamento(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray faturamentoArray = jsonObject.getJSONArray("faturamento");

        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        double somaFaturamento = 0;
        int diasComFaturamento = 0;

        for (int i = 0; i < faturamentoArray.length(); i++) {
            JSONObject dia = faturamentoArray.getJSONObject(i);
            double valor = dia.getDouble("valor");

            if (valor > 0) {
                if (valor < menorFaturamento) {
                    menorFaturamento = valor;
                }
                if (valor > maiorFaturamento) {
                    maiorFaturamento = valor;
                }
                somaFaturamento += valor;
                diasComFaturamento++;
            }
        }

        if (diasComFaturamento == 0) {
            System.out.println("Não há dias com faturamento.");
            return;
        }

        double mediaFaturamento = somaFaturamento / diasComFaturamento;
        int diasAcimaDaMedia = 0;

        for (int i = 0; i < faturamentoArray.length(); i++) {
            JSONObject dia = faturamentoArray.getJSONObject(i);
            double valor = dia.getDouble("valor");
            if (valor > mediaFaturamento) {
                diasAcimaDaMedia++;
            }
        }

        System.out.printf("Menor faturamento: R$%.2f%n", menorFaturamento);
        System.out.printf("Maior faturamento: R$%.2f%n", maiorFaturamento);
        System.out.printf("Número de dias com faturamento acima da média: %d%n", diasAcimaDaMedia);
    }
}

