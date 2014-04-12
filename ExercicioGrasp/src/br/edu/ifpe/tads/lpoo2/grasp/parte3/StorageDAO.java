package br.edu.ifpe.tads.lpoo2.grasp.parte3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


/*
 * 
 * @GRASP : Pure Fabrication - Criar uma nova classe para salvar objetos de algum 
 * tipo de meio de armazenamento persistente
 * 
 */


public class StorageDAO implements PersistentStorage{

    private Connection con;
    private String sql;
    private Order order;
    private List<Order> listaCandidato;
	
	
	@Override
	public boolean insertOrder(Order order) {


		sql = "INSERT INTO ORDER(orderItemname,shippingPrice, TIPO)VALUES(?,?,?)";
        try {
            con = new ConnectDB().getConexao();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            int count=1;
            
            for(OrderItem order :=order.getItems()){
            	
            }
            /*
             * 
             * stmt.setString(count++, order.getEmail());
             */
            stmt.setString(count++, login.getSenha());
            stmt.setString(count++, login.getTipo());
            stmt.executeUpdate();
            
            stmt.close();
            
            
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
            }
        }
		
		return false;
	}

	@Override
	public boolean updateOrder(int id, Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrder(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order selectOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> selectOrders() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
