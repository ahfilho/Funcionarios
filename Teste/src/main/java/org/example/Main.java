package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

//3 - classe principal OK
public class Main {
    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 - Inserir funcionários na ordem OK
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 05, 12), BigDecimal.valueOf(2284.38), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 05, 02), BigDecimal.valueOf(9836.14), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(10119.88), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), BigDecimal.valueOf(2234.68), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), BigDecimal.valueOf(4071.84), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 07, 8), BigDecimal.valueOf(3017.45), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), BigDecimal.valueOf(1606.85), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 02), BigDecimal.valueOf(2799.93), "Gerente"));

        // 3.2 Remover joão
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("JOão"));
    }
}
