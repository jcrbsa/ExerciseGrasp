package br.edu.ifpe.tads.lpoo2.grasp.parte3;

import java.util.ArrayList;
import java.util.List;


/*
 * 
 * @GRASP : Pure Fabrication - Criar uma nova classe para salvar objetos de algum 
 * tipo de meio de armazenamento  persistente
 * 
 */


public class StorageRepository implements PersistentStorage {

	
	private static int id=0;
	private static List<Order> orders = new ArrayList<Order>();
	
	@Override
	public boolean insertOrder(Order order) {
	
		try{
		orders.add(order);
		StorageRepository.id++;
		return true;
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
	
	}

	@Override
	public boolean updateOrder(int id, Order order) {
		
		try{
		orders.set(id, order);
		return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteOrder(int id) {
		try{
			orders.remove(id);
			StorageRepository.id--;
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Order selectOrder(int id) {
		try{
			
			return orders.get(id);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public List<Order> selectOrders() {
		
		return orders;
	}


	
	
	
	

}
