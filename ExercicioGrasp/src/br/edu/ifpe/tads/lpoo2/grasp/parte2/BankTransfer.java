package br.edu.ifpe.tads.lpoo2.grasp.parte2;

class BankTransfer extends Payment {

	@Override
	double orderPayment(Order order) {
		double total = 0;
		
		for (OrderItem item : order.getItems()) {
			total += item.calculatePriceItem(order.getShipping());		
		}
		 total *= 0.9;
		 return total;
	
	}


}