package br.edu.ifpe.tads.lpoo2.grasp.parte3;

import java.util.ArrayList;
import java.util.List;

class Order implements OrderController{
	private int number;
	private Customer customer;
	private Payment payment;
	private Shipping shipping; 
	private static int id=0;

	private List<OrderItem> items = new ArrayList<OrderItem>();
	private static List<Order> orders = new ArrayList<Order>();

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
	
	/*
	 * Expert
	 * Método para calcular Pedido é resposabildade de Order enão métod estático da classe principal do programa
	 * */
	/*
	 * @grasp Advanced > Protecte Variation
	 * levantar excecao se não houver  payment
	 * */
	
	
	public double calculateOrderPayment() {	

	
	if (this.getPayment() instanceof BankTransfer) {
		payment = new BankTransfer();
		
	}else if (this.getPayment() instanceof CreditCard) {
		payment = new CreditCard();
	}
	return payment.orderPayment(this);

}

	

	@Override
	public void editOrder() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void cancelOrder() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void realizeOrder(List<Product> products, Customer customer,
			Shipping shipping) {
		// TODO Auto-generated method stub

		Order order1 = new Order(id++);
		order1.setCustomer(customer);
		int cont =0;
		for (Product product: products) {
			
		order1.addOrderItem(new OrderItem(product,cont));
		cont++;
		}
		 
		
                
		//order1.printOrder();
                              
		order1.setShipping(shipping);
		orders.add(order1);
		
	}

	@Override
	public void checkoutOrder(Order order, Payment payment, Shipping shipping) {
		 
		order.setPayment(payment);
		order.setShipping(shipping);
		
		double total = order.calculateOrderPayment();
		orders.set(order.getNumber(), order);
		
	}

	@Override
	public void visualizeOrders() {
		for (Order order : orders) {
			order.printOrder();
		}
		
	}


}