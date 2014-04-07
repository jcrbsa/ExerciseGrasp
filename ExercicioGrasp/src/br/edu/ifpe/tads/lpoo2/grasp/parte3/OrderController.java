package br.edu.ifpe.tads.lpoo2.grasp.parte3;

import java.util.List;

public interface OrderController {

	public void realizeOrder(List<Product> product, Customer customer, Shipping shipping);
	public void editOrder();
	public void cancelOrder();
	public void checkoutOrder(Order order, Payment payment, Shipping shipping);
	public void visualizeOrders();

}
