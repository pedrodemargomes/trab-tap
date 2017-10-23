class Program {
	public static void main(String args[]) {
		
		Quadrado q = new Quadrado(4.0);
		System.out.println(q.imprimeArea());
		
		Retangulo r = new Retangulo(2.0,9.0);
		System.out.println(r.imprimeArea());
		
		Circulo c = new Circulo(10.0);
		System.out.println(c.imprimeArea());
		
	}
}
