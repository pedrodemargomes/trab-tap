class Streaming {
	static private Streaming streaming;
	private Streaming(){
	}
	static public Streaming getInstance() {
		if(streaming == null) {
			streaming = new Streaming();
		}
		return streaming;
	}
	String login;
	String senha;
	String plano;
	DiretorioDeMusicas diretorioDeMusicas = new DiretorioDeMusicas();
}
