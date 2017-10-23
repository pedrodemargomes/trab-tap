import java.util.ArrayList;

class Streaming {
	static private Streaming streaming;
	private Streaming(){
	}
	static public Streaming getInstance() {
		if(streaming == NULL) {
			streaming = new Streaming();
		}
		return streaming;
	}
	String login;
	String senha;
	String plano;
	DiretorioDeMusicas diretorioDeMusicas;
}
