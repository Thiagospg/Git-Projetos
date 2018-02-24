package br.com.infogomes.dal;

import java.sql.*;
import java.io.File;

public class ModuloConexao {

   private static File banco = new File ("db/bdDespesas.db");
   private static Connection conexao = null;
   
   public static Connection conector(){
       
       try {
           
           Class.forName("org.sqlite.JDBC");
           String URL = "jdbc:sqlite:"+banco.getAbsolutePath();
       
           conexao = DriverManager.getConnection(URL);
           return conexao;
       } catch (Exception e){
           return null;
       }
       
       
   }
   
}
