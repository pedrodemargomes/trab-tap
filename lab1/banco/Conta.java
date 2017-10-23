
class Conta {
	String numeroConta;
	double saldo;
	void deposita(double val) {
		saldo += val;
	}
	void retira(double val) {
		saldo -= val;
	}
	double getSaldo() {
		return saldo;
	}
	abstract void atualizaSaldo();
}

class ContaCorrente extends Conta {
	void atualizaSaldo() {
		saldo *= 1.1;
	}
	
}

class ContaPoupanca extends Conta {
	void atualizaSaldo() {
		saldo *= 1.2;
	}
	
}

class Cliente {
	String nome;
	String cpf;
	ArrayList<ContaCorrente> contasCorr;
	ArrayList<ContaPoupanca> contasPoup;
	void criaConta(int tipo) {
		if(tipo == 0) {
			ContaCorrente c = new ContaCorrente();
			if(contasCorr == NULL)
				contasCorr = new ArrayList<ContaCorrente>();
			contasCorr.add(c);
		} else {
			ContaPoupanca c = new ContaPoupanca();
			if(contasPoup == NULL)
				contasPoup = new ArrayList<ContaPoupanca>();
			contasPoup.add(c);
		}
	}
}
