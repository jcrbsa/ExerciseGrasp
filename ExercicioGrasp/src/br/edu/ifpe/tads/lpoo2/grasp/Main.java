package br.edu.ifpe.tads.lpoo2.grasp;


public class Main {
	public static void main (String [] args) throws Exception {
		
		Customer csJohnSmith = new Customer("John Smith", "Rua da Aurora");
		Customer csTonyRamos = new Customer("Tony Ramos", "Rua do Projac");
		Customer csMariaGracas = new Customer("Maria das Graças","Av. do Sucesso");
		
		Product prTV = new Product("TV", 1500.00, 24.5);
		Product prLaptop = new Product("Laptop", 1200.00, 5.2);
		Product prLavadora = new Product("Lavadora", 1000.00, 50);
		Product prRelogio = new Product("Relógio", 300, 0.5);
		
		Shipping spStandard = new Shipping(1.50, 10);
		Shipping spExpress = new Shipping(3.00, 3);
		
		
				
		Order order1 = new Order(1);
		order1.setCustomer(csJohnSmith);
		order1.addOrderItem(new OrderItem(prTV, 1));
		order1.addOrderItem(new OrderItem(prLaptop, 2));
		
		order1.printOrder();
		
		System.out.println(csJohnSmith.checkout(order1, new BankTransfer(), spStandard));
		
		Order order2 = new Order(2);
		order2.setCustomer(csTonyRamos);
		order2.addOrderItem(new OrderItem(prLavadora, 1));
		order2.addOrderItem(new OrderItem(prRelogio, 2));
		
		order2.printOrder();
		
		System.out.println(csTonyRamos.checkout(order2, new CreditCard(), spExpress));
		
		Order order3 = new Order(3);
		order3.setCustomer(csMariaGracas);
		order3.addOrderItem(new OrderItem(prLaptop,2));
		
		order3.printOrder();
		
		System.out.println(csMariaGracas.checkout(order3, new CreditCard(), spStandard));
	}
	
	public static double calculate(Order order) {	
		
		double total = 0;
		
		for (OrderItem item : order.getItems()) {
			total += item.calculate(order.getShipping());		
		}
		
		if (order.getPayment() instanceof BankTransfer) {
			total *= 0.9; // 10% de desconto
		}
		
		if (order.getPayment() instanceof CreditCard) {
			total *= 0.5; // 10% de desconto
			
		}
		
		return total;
	}
}
