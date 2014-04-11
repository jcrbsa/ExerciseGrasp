package br.edu.ifpe.tads.lpoo2.grasp.parte3;

import java.util.List;

/*
 * 
 * @GRASP : Pure Fabrication - Criar uma nova classe para salvar objetos de algum 
 * tipo de meio de armazenamento  persistente
 * 
 */

public interface PersistentStorage {

	boolean insertOrder(Order order);
	boolean updateOrder(int id, Order order);
	boolean deleteOrder(int id);
    Order selectOrder(int id);
    List<Order> selectOrders();
    
    
}
