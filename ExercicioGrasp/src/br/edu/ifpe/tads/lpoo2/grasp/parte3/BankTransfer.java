package br.edu.ifpe.tads.lpoo2.grasp.parte3;

class BankTransfer extends Payment {

	@Override
	double orderPayment(double totalItems) {
		// TODO Auto-generated method stub
		
		totalItems *= 0.9; // 10% de desconto		return
		return totalItems;
	}

}