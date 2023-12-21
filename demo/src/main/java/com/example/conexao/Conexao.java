package com.example.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "rootadmin";

    public static Connection conn;

    //MÉTODO CONEXÃO COM BANCO
    public static Connection conectar() {
        try {
            if(conn == null) {

                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Banco conectado");
                return conn;

            } else {
                return conn;
            }
        } catch (SQLException e) {
            System.out.println("Driver não encontrado. "+e.getMessage());
            return conn;
        }    
    }

    //MÉTODO DESCONEXÃO COM BANCO
    public static void desconectar() {

        if(conn != null) {
            try {
                
                System.out.println("Banco Desconectado.");
                conn.close();

            } catch (SQLException e) {
                System.out.println("Erro ao desconectar. "+e.getMessage());
            }
        }
    }
}
