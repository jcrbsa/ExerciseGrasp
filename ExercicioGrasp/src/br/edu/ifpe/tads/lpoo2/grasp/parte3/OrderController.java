package br.edu.ifpe.tads.lpoo2.grasp.parte3;

import java.util.List;


/*
 * @GRASP:Controller
 * 
 * */

public interface OrderController {

	public void realizeOrder(List<Product> product, Customer customer, Shipping shipping);
	public void editOrder(int id, Order order);
	public void deleteOrder(int id, Order order);
	public void checkoutOrder(Order order, Payment payment, Shipping shipping);
	public void visualizeOrders();

}
