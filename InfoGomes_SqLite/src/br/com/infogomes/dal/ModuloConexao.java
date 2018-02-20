package br.com.infogomes.dal;

import java.io.File;
import java.sql.*;

public class ModuloConexao {
//pegar diretorio automaticamente do banco
    private static File banco = new File("db/bancobruna.db");
//variavel de conexao    
    private static Connection conexao = null;
//metodo responsavel por estabelecer a conexao com o banco
    public static Connection conector() {

     
//estabelecendo a conexão com o banco de dados
        try {
                        
            Class.forName("org.sqlite.JDBC");
            String URL = "jdbc:sqlite:"+banco.getAbsolutePath();

            conexao = DriverManager.getConnection(URL);
            return conexao;
        } catch (Exception e) {
//linha abaixo serve de apoio para esclarecer o erro de conexao            
//System.out.println(e);
            
            return null;
        }
    }

}
