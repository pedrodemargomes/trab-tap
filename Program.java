class Program {	
	public static void main(String args[]) {
		
		Streaming streaming = Streaming.getInstance();
		
		Playlist playlist1 = new Playlist();
		playlist1.nome = "musicas do campo";
		playlist1.estiloPrincipal = "sertanejo";
		playlist1.estiloSecundario = "modão";
		
		Album album = new Album();
		album.nome = "cx2";
		album.nomeBanda = "cx";
		album.estilo = "sertanejo";
		
		Musica musica = new Musica();
		musica.nome = "sinonimos";
		musica.estilo = "sertanejo";
		musica.duracaoMin = 4.2;
		
		album.add(musica);
		playlist1.add(album);
		streaming.diretorioDeMusicas.add(playlist1);
		
		Visitor v = new Visitor();
		v.visitar(streaming.diretorioDeMusicas);
		
	} 

}
