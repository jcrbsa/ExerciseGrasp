package br.edu.ifpe.tads.lpoo2.grasp.parte3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	
	private Connection con = null;
    private String status ="";
   
    public Connection getConexao() throws ClassNotFoundException{
           
        Class.forName("com.mysql.jdbc.Driver");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/company", "root", "");
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
       
        if(con!=null){
            status="STATUS = conectado";
        }else{
            status="STATUS = Não conectado";
        }
       
        return con;
    }
   
    public String getStatus(){
        return status;
    }


}
