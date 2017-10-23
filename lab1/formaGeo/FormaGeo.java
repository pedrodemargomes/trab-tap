class Quadrado {
	double l1;
	public Quadrado(double l) {
		l1 = l;
	}
	public double imprimeArea() {
		return l1*l1;
	}
}

class Retangulo extends Quadrado {
	double l2;
	public Retangulo(double pl1,double pl2) {
		super(pl1);
		l2 = pl2;
	}
	public double imprimeArea() {
		return l1*l2;
	}
}

class Circulo {
	double raio;
	public Circulo(double p_raio) {
		raio = p_raio;
	}
	public double imprimeArea() {
		return raio*raio*3.14159265359;
	}
}
