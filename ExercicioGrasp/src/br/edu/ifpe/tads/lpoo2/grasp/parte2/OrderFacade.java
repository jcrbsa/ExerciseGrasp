package br.edu.ifpe.tads.lpoo2.grasp.parte2;

import java.util.List;


/*
 * @GRASP: Client Facade Controller
 */
public interface OrderFacade {

	public void realizeOrder(List<Product> product, Customer customer, Shipping shipping);
	public void editOrder();
	public void cancelOrder();
	public void checkoutOrder(Order order, Payment payment, Shipping shipping);
	public void visualizeOrders();

}
