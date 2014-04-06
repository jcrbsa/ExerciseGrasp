package br.edu.ifpe.tads.lpoo2.grasp.parte3;
class CreditCard extends Payment {

	@Override
	double orderPayment(double totalItems) {
		return totalItems *= 0.5; 
	}

		
}