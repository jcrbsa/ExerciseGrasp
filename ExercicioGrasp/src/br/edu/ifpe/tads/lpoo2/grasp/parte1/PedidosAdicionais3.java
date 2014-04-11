package br.edu.ifpe.tads.lpoo2.grasp.parte1;

public class PedidosAdicionais3 {
	
	

	
		
		public static void main(String[] args) throws Exception  {
			
			Customer EdgarJunior = new Customer("Edgar Junior", "Av Luiz Freire");
			Customer EduardoSilveira = new Customer("Eduardo Silveira", "Rua Emilio Freitas");
			Customer JanioSilva = new Customer("Janio da Silva ","Av Presidente Prudente");
			
			Product prTV = new Product("Notebook", 1500.00, 24.5);
			Product prLaptop = new Product("SmartPohne", 1200.00, 5.2);
			Product prLavadora = new Product("Ipod", 1000.00, 50);
			Product prRelogio = new Product("Iphone", 1300, 0.5);
			
			Shipping spStandard = new Shipping(20.0, 0);
			Shipping spExpress = new Shipping(20.0, 0);
			
			
					
			Order order1 = new Order(1);
			order1.setCustomer(EdgarJunior);
			order1.addOrderItem(new OrderItem(prTV, 1));
			order1.addOrderItem(new OrderItem(prLaptop, 2));
			
			order1.printOrder();
			
			System.out.println(EdgarJunior.checkout(order1, new CreditCard(), spStandard));
			
			Order order2 = new Order(2);
			order2.setCustomer(EduardoSilveira);
			order2.addOrderItem(new OrderItem(prLavadora, 1));
			order2.addOrderItem(new OrderItem(prRelogio, 2));
			
			order2.printOrder();
			
			System.out.println(EduardoSilveira.checkout(order2, new CreditCard(), spExpress));
			
			Order order3 = new Order(3);
			order3.setCustomer(JanioSilva);
			order3.addOrderItem(new OrderItem(prLaptop,2));
			
			order3.printOrder();
			
			System.out.println(JanioSilva.checkout(order3, new CreditCard(), spStandard));
			
			
			
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



