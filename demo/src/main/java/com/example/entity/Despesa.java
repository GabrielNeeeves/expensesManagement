package com.example.entity;

import java.util.Scanner;

public class Despesa {
    
    private String categoria;
    private String descricao;
    private double valor;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    //MÉTODO CRIAR DESPESA
    public void criarDespesa(Scanner scanner) {

        System.out.println("CATEGORIA da Despesa (transporte, alimentação, contas etc: )");
        this.categoria = scanner.next();

        scanner.nextLine();
        
        System.out.println("DESCRIÇÃO da Despesa: ");
        this.descricao = scanner.nextLine();
        
        System.out.println("VALOR da Despesa: R$ ");
        this.valor = scanner.nextDouble();
    }
}
