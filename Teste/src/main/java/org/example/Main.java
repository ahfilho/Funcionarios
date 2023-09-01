package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

//3 - classe principal OK
public class Main {

    static Funcionario funcionario = new Funcionario();

    static LocalDate dataAtual = LocalDate.now();

    public static void main(String[] args) {

        ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>() {
            {

                // 3.1 - Inserir funcionários na ordem OK
                add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"));
                add(new Funcionario("João", LocalDate.of(1990, 12, 12), BigDecimal.valueOf(2284.38), "Operador"));
                add(new Funcionario("Caio", LocalDate.of(1961, 05, 02), BigDecimal.valueOf(9836.14), "Coordenador"));
                add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(10119.88), "Diretor"));
                add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), BigDecimal.valueOf(2234.68), "Recepcionista"));
                add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"));
                add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), BigDecimal.valueOf(4071.84), "Contador"));
                add(new Funcionario("Laura", LocalDate.of(1994, 07, 8), BigDecimal.valueOf(3017.45), "Gerente"));
                add(new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), BigDecimal.valueOf(1606.85), "Eletricista"));
                add(new Funcionario("Helena", LocalDate.of(1996, 9, 02), BigDecimal.valueOf(2799.93), "Gerente"));
            }
        };
        System.out.println("--------------------------------------------------------------------------------------------");
        // 3.2 Remover joão

//
        listaDeFuncionarios.removeIf(funcionario -> "João".equals(funcionario.getNome()));
        System.out.println("João foi removido.");
        System.out.println("--------------------------------------------------------------------------------------------");

        //3.3 imprimir
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");
        for (Funcionario funcionario : listaDeFuncionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data de Nascimento: " + funcionario.getDataNascimento().format(dtf).formatted());
            System.out.println("Salário: " + funcionario.getSalario().toString());
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------------------");


        //3.4 aumento de salario
        for (int a = 0; a < listaDeFuncionarios.size(); a++) {
            Funcionario funcionario = listaDeFuncionarios.get(a);
            BigDecimal novoSalario = funcionario.getSalario().multiply(BigDecimal.valueOf(1.10));
            funcionario.setSalario(novoSalario);

            System.out.println(funcionario.getSalario());
        }


        System.out.println("--------------------------------------------------------------------------------------------");

        //3.5 3.6
        Map<String, List<Funcionario>> funcao = listaDeFuncionarios.stream().collect((Collectors.groupingBy(Funcionario::getFuncao)));
        for (String funcaoDoFuncionario : funcao.keySet()) {
            System.out.println("FUnçao::: " + funcaoDoFuncionario);
            List<Funcionario> funcionariosPorFUncao = funcao.get(funcao);
            for (int a = 0; a == 10; a++) {
                System.out.println("Funcionario:" + funcionario.getNome());
            }
        }


        //3.8
        System.out.println("--------------------------------------------------------------------------------------------");
        List<Integer> meses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        for (int a = 0; a < listaDeFuncionarios.size(); a++) {
            Funcionario funcionario = listaDeFuncionarios.get(a);

            int mes = funcionario.getDataNascimento().getMonthValue();

            if (mes == 1 || mes == 2 || mes == 3 ||
                    mes == 4 || mes == 5 || mes == 6 ||
                    mes == 7 || mes == 8 || mes == 9
                    || mes == 10 || mes == 11 || mes == 12) {
                System.out.println(
                        "Aniversariantes do mês " + mes + ", " + funcionario.getNome());

            }
        }


        //3.9
        System.out.println("--------------------------------------------------------------------------------------------");
        Funcionario funcionarioMaisVelho = Collections.max(listaDeFuncionarios, Comparator.comparing(
                funcionario1 -> dataAtual.getYear() - funcionario1.getDataNascimento().getYear()));
        int maioridade = dataAtual.getYear() - funcionarioMaisVelho.getDataNascimento().getYear();
        System.out.println("O mais velho é " + funcionarioMaisVelho.getNome() + ",sua idade é:" + maioridade);

        Funcionario funcionarioMaisJovem = Collections.min(listaDeFuncionarios, Comparator.comparing(
                funcionario2 -> dataAtual.getYear() - funcionario2.getDataNascimento().getYear()));
        int menorIdade = dataAtual.getYear() - funcionarioMaisJovem.getDataNascimento().getYear();
        System.out.println("O mais jovem é " + funcionarioMaisJovem.getNome() + ",sua idade é:" + menorIdade);


        //3.10
        System.out.println("--------------------------------------------------------------------------------------------");

        listaDeFuncionarios.sort(Comparator.comparing(Funcionario::getNome).thenComparing(Funcionario::getDataNascimento));
        System.out.println("Ordem alfabética");
        for (int a = 0; a < listaDeFuncionarios.size(); a++) {
            Funcionario funcionario = listaDeFuncionarios.get(a);
            System.out.println(funcionario.getNome());

        }

        System.out.println("--------------------------------------------------------------------------------------------");

        //3.11

        BigDecimal totalDosSalarios = listaDeFuncionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO.stripTrailingZeros(), BigDecimal::add);
        System.out.println("A soma de todos os salários:" + totalDosSalarios);

        System.out.println("--------------------------------------------------------------------------------------------");

        //3.12

        BigDecimal salarioMinimo = BigDecimal.valueOf(1212.00);
        for (int a = 0; a < listaDeFuncionarios.size(); a++) {
            Funcionario funcionario = listaDeFuncionarios.get(a);
            BigDecimal minimo = funcionario.getSalario().divide(salarioMinimo, RoundingMode.DOWN);
            System.out.println(funcionario.getNome() + " recebe: " + minimo + " salários mínimos");
        }
    }

}





