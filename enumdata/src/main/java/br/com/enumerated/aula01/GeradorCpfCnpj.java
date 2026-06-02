package br.com.enumerated.aula01;

import java.util.Random;

public class GeradorCpfCnpj {

    // metodo validador de cpf
    public static boolean ValidarCpf(String cpf) {
        //remove todos os caracteres não númericos
        cpf = cpf.replaceAll("\\D", "");

        //verifica quantidade minima de digitos
        if (cpf.length() != 11) {
            return (false);
        }

        // bloqueio de cpfs compostos de numeros iguais ex.: (11111111111)
        if(cpf.matches("(\\d)\\1{10}")) {
            return (false);
        }

        // ---calculo do primeiro digito verificador
        int soma = 0;
        int peso = 10; //o peso inicial é 10

        for(int i = 0; i < 9; i++) {
            // converter os char em int
            int num = Character.getNumericValue(cpf.charAt(i));
            soma += num * peso;
            peso--; // subtrai uma unidade para o proximo calculo
        }

        int resto = soma % 11;
        int dv1Calculado = (resto < 2) ? 0 : 11 - resto;

        // ---calculo do segundo digito verificador
        soma = 0;
        peso = 11; //o peso inicial é 10

        for(int i = 0; i < 10; i++) {
            // converter os char em int
            int num = Character.getNumericValue(cpf.charAt(i));
            soma += num * peso;
            peso--;
        }

        resto = soma % 11;
        int dv2Calculado = (resto < 2) ? 0 : 11 - resto;

        // Validacao final
        // Pega os digitos finais informados no cpf
        int dv1Original = Character.getNumericValue(cpf.charAt(9));
        int dv2Original = Character.getNumericValue(cpf.charAt(10));

        // Se os numeros informados forem iguais aos calculado entao o cpf e valido
        return (dv1Original == dv1Calculado && dv2Original == dv2Calculado);
    }

    // Metodo para gerar um cpf aleatório válido

    public static String gerarCPF() {
        Random random = new Random();
        int[] digitos = new int[11];

        // gera os 9 primeiros digitos
        for (int i = 0; i < 9; i++) {
            digitos[i] = random.nextInt();
        }

        // Calculo do primeiro dv
        int soma = 0;
        int peso = 10;

        for (int i = 0; i < 9; i++) {
            soma += digitos[i] * peso;
            peso--;
        }

        int resto = soma % 11;
        digitos[9] = (resto < 2) ? 0 : 11 - resto;

        // Calculo do segundo dv
        soma = 0;
        peso = 11;

        for (int i = 0; i < 10; i++) {
            soma += digitos[i] * peso;
            peso--;
        }

        resto = soma % 11;
        digitos[10] = (resto < 2) ? 0 : 11 - resto;

        //junta tudo em uma unica String
        StringBuilder cpfGerado = new StringBuilder();
        for (int digito : digitos) {
            cpfGerado.append(digito);
        }

        return cpfGerado.toString();
    }
}
