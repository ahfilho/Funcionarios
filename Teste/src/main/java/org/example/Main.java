package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

//3 - classe principal OK
public class Main {

    static Funcionario funcionario = new Funcionario();
    static ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>();

    static LocalDate dataAtual = LocalDate.now();

    public static void main(String[] args) {

        // 3.1 - Inserir funcionários na ordem OK
        listaDeFuncionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"));
        listaDeFuncionarios.add(new Funcionario("João", LocalDate.of(1990, 12, 12), BigDecimal.valueOf(2284.38), "Operador"));
        listaDeFuncionarios.add(new Funcionario("Caio", LocalDate.of(1961, 05, 02), BigDecimal.valueOf(9836.14), "Coordenador"));
        listaDeFuncionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(10119.88), "Diretor"));
        listaDeFuncionarios.add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), BigDecimal.valueOf(2234.68), "Recepcionista"));
        listaDeFuncionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"));
        listaDeFuncionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), BigDecimal.valueOf(4071.84), "Contador"));
        listaDeFuncionarios.add(new Funcionario("Laura", LocalDate.of(1994, 07, 8), BigDecimal.valueOf(3017.45), "Gerente"));
        listaDeFuncionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), BigDecimal.valueOf(1606.85), "Eletricista"));
        listaDeFuncionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 02), BigDecimal.valueOf(2799.93), "Gerente"));

        // 3.2 Remover joão
        listaDeFuncionarios.removeIf(funcionario -> funcionario.getNome().equals("JOão"));

        //3.3 imprimir
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");
        Locale br = new Locale("Br");
        for (Funcionario funcionario : listaDeFuncionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data de Nascimento: " + funcionario.getDataNascimento().format(dtf));
            System.out.println("Salário: " + funcionario.getSalario().toString());
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println();
        }
        //3.4 aumento de salario
        for (int a = 0; a == 10; a++) {
            BigDecimal novoSalario = funcionario.getSalario().multiply(BigDecimal.valueOf(1.10));
            funcionario.setSalario(novoSalario);
        }
        //3.5
        Map<String, List<Funcionario>> funcao = listaDeFuncionarios.stream().collect((Collectors.groupingBy(Funcionario::getFuncao)));
        for (String funcaoDoFuncionario : funcao.keySet()) {
            System.out.println("FUnçao::: " + funcaoDoFuncionario);
            List<Funcionario> funcionariosPorFUncao = funcao.get(funcao);
            for (int a = 0; a == 10; a++) {
                System.out.println("Funcionario:" + funcionario.getNome());
            }
        }
        System.out.println("------------------------------------------------------------------------");
        int aniversatiantesMes01 = 01;
        int aniversariantesMes02 = 02;
        int aniversariantesMes03 = 03;
        int aniversariantesMes04 = 04;
        int aniversariantesMes05 = 05;
        int aniversariantesMes06 = 06;
        int aniversariantesMes07 = 07;
        int aniversariantesMes08 = 8;
        int aniversariantesMes09 = 9;
        int aniversariantesMes10 = 10;
        int aniversariantesMes11 = 11;
        int aniversariantesMes12 = 12;

        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            Funcionario funcionario = listaDeFuncionarios.get(i);

            int mes = funcionario.getDataNascimento().getMonthValue();

            if (mes == aniversatiantesMes01 || mes == aniversariantesMes02 || mes == aniversariantesMes03 ||
                    mes == aniversariantesMes04 || mes == aniversariantesMes05 || mes == aniversariantesMes06 ||
                    mes == aniversariantesMes07 || mes == aniversariantesMes08 || mes == aniversariantesMes09
                    || mes == aniversariantesMes10 || mes == aniversariantesMes11 || mes == aniversariantesMes12) {
                System.out.println(
                        "Aniversariantes do mês " + mes + ", " + funcionario.getNome());

            }
        }
        System.out.println("---------------------------------------------------");
        Funcionario funcionarioMaisVelho = Collections.max(listaDeFuncionarios, Comparator.comparing(
                funcionario1 -> dataAtual.getYear() - funcionario1.getDataNascimento().getYear()));
        int maioridade = dataAtual.getYear() - funcionarioMaisVelho.getDataNascimento().getYear();
        System.out.println("O mais velho é " + funcionarioMaisVelho.getNome() + ",sua idade é:" + maioridade);

        Funcionario funcionarioMaisJovem = Collections.min(listaDeFuncionarios, Comparator.comparing(
                funcionario2 -> dataAtual.getYear() - funcionario2.getDataNascimento().getYear()));
        int menorIdade = dataAtual.getYear() - funcionarioMaisJovem.getDataNascimento().getYear();
        System.out.println("O mais jovem é " + funcionarioMaisJovem.getNome() + ",sua idade é:" + menorIdade);


        System.out.println("--------------------------------------------------");

        listaDeFuncionarios.sort(Comparator.comparing(Funcionario::getNome).thenComparing(Funcionario::getDataNascimento));
        System.out.println("Ordem alfabética");
        for (int a = 0; a < listaDeFuncionarios.size(); a++) {
            Funcionario funcionario = listaDeFuncionarios.get(a);
            System.out.println(funcionario.getNome());

        }
    }
}





