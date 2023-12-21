package com.example.despesaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.example.entity.Despesa;

public class DespesaDAO {
    
    //MÉTODO INSERIR DESPESA
    public static void inserirDespesa(Connection conn, Despesa despesa) {

        try (PreparedStatement sql = conn.prepareStatement("INSERT INTO DESPESAS (CATEGORIA, DESCRICAO, VALOR) VALUES (?, ?, ?)")) {

            sql.setString(1, despesa.getCategoria());
            sql.setString(2, despesa.getDescricao());
            sql.setDouble(3, despesa.getValor());

            int update = sql.executeUpdate();
            System.out.println("Linhas inseridas: "+update);

            sql.close();
            
        } catch (SQLException e) {
            System.out.println("Erro de inserção. "+e.getMessage());
        }
    }

    //MÉTODO CONSULTA TABELA
    public static void consultaDados(Connection conn) {

        try (PreparedStatement sql = conn.prepareStatement("SELECT * FROM DESPESAS")) {

            ResultSet result = sql.executeQuery();

            while(result.next()) {

                int id = result.getInt("ID");
                String catg = result.getString("CATEGORIA");
                String desc = result.getString("DESCRICAO");
                double valor = result.getDouble("VALOR");
                
                System.out.println("ID: "+id+" - CATEGORIA: "+catg+" - DESCRIÇÃO: "+desc+" - VALOR: R$"+valor);
            }

            sql.close();
            result.close();
            
        } catch (SQLException e) {
            System.out.println("Erro de consulta. "+e.getMessage());
        }
    }

    //MÉTODO EXCLUIR DESPESA
    public static void excluirDespesa(Connection conn, Scanner scanner) {

        String sql = "DELETE FROM DESPESAS WHERE ID = ?";

        try (PreparedStatement stm = conn.prepareStatement(sql)) {

            System.out.println("ID da Despesa a excluir: ");
            stm.setInt(1, scanner.nextInt());

            //scanner.nextLine();
            
            int update = stm.executeUpdate();
            System.out.println("Linhas excluidas: "+update);
            
        } catch (SQLException e) {
            System.out.println("Erro de exclusão. "+e.getMessage());
        }
        
    }
    
}
