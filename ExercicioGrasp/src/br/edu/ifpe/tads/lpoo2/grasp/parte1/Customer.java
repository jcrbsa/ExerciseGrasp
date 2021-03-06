package br.edu.ifpe.tads.lpoo2.grasp.parte1;

class Customer {
	private String name;
	private String address;
	
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return this.name;
	}	
	
	public String checkout(Order order, Payment payment, Shipping shipping) throws Exception {		
		
		/*
		 * 3 a)Lance uma exce��o se o produto n�o puder ser entregue 
		 * no prazo m�ximo do tipo de frete escolhido ao fechar a compra (checkout).
		 * 
		 * 
		 */
		if(shipping.deliveryTime > Shipping.TEMPO_MAXIMO_ENTREGA){
			throw new Exception("o produto n�o pode ser entregue no prazo m�ximo do tipo de frete escolhido ao fechar a compra!");
		}
		order.setPayment(payment);
		order.setShipping(shipping);
		
		double total = Mainold.calculate(order);
		
		return  "Customer: " + this.name + "\n" + 
				"Address:" + this.address + "\n" +
				"Order#: " + order.getNumber() + "\n" + 
				"Total: " + total + "\n";
	}	
}