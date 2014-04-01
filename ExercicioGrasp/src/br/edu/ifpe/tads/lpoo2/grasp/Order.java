package br.edu.ifpe.tads.lpoo2.grasp;

import java.util.ArrayList;
import java.util.List;

class Order {
	private int number;
	private Customer customer;
	private Payment payment;
	private Shipping shipping; 

	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Order(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return this.number;
	}	

	public void setCustomer(Customer customer1) { 
		this.customer = customer1;
	}

	public void setShipping(Shipping shipping) {		
		this.shipping = shipping;
	}

	public void setPayment(Payment payment1) { 
		this.payment = payment1;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		this.items.add(orderItem);	
	}
	
	public List<OrderItem> getItems() {
		return this.items;
	}
//Modificar para public:
	public Customer getCustomer() {
		return this.customer;
	}
	
	public Shipping getShipping() {
		return this.shipping;
	}

	public Payment getPayment() {
		return this.payment;
	}
	
	public void printOrder() {
		
		String str = "Order#: " + this.getNumber() + "\n";
		
		str += "Customer: " + this.getCustomer().getName() + "\n";
		
		for (OrderItem item : this.items) {
			str += "Item: " + item.getProduct().getName() + "(" + item.getQuantity() + ")\n"; 
		}
		
		System.out.println(str);
	}

}