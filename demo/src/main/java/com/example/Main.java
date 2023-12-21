package com.example;

import java.sql.Connection;
import java.util.Scanner;

import com.example.conexao.Conexao;
import com.example.despesaDAO.DespesaDAO;
import com.example.entity.Despesa;

public class Main {
    public static void main(String[] args) {
        
        Connection conn = Conexao.conectar();

        Scanner scanner = new Scanner(System.in);

        while(true) {

            Conexao.conectar();
            
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Criar Despesa");
            System.out.println("2. Mostrar Despesas");
            System.out.println("3. Excluir Despesa");
            System.out.println("4. Sair");
            int option = scanner.nextInt();

            switch(option) {

                case 1:
                    Despesa d = new Despesa();
                    d.criarDespesa(scanner);
                    DespesaDAO.inserirDespesa(conn, d);
                    //Conexao.desconectar();
                    break;
                case 2:   
                    DespesaDAO.consultaDados(conn);
                    //Conexao.desconectar();
                    break;
                case 3:
                    DespesaDAO.excluirDespesa(conn, scanner);
                    break;
                case 4:
                    System.out.println("Saiu.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}