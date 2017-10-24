class p {
	public static void main(String[] args){
		Streaming streaming = Streaming.getInstance();
		
		streaming.diretorioDeMusicas.adicionaMusica("a", "b","c","d","e","f", "g", "h", 5);
		streaming.diretorioDeMusicas.adicionaMusica("a", "b","c","d","e","f", "g", "h", 1);
		streaming.diretorioDeMusicas.adicionaMusica("a", "b","c","d","e","f", "g", "h", 1);
		streaming.diretorioDeMusicas.adicionaMusica("a", "b","c","d","e","f", "g", "h", 3);
		streaming.diretorioDeMusicas.adicionaMusica("b", "b","c","d","e","f", "q", "h", 4);
		
		//System.out.println( streaming.diretorioDeMusicas.playlists.get(0).albuns.get(0).musicas.get(0).nome );
		
		Playlist r = new Playlist();
		r.nome = "daaadad";
		r.estiloPrincipal = "bbb";
		r.estiloSecundario = "ccc";
		
		Musica m = new Musica();
		m.nome = "zzzz";
		m.duracaoMin = 87;
		m.estilo = "fddd";
		
		Album a = new Album();
		a.nome = "assas";
		a.estilo = "grrgrg";
		a.nomeBanda = "gegr";
		
		a.musicas.add(m);
		r.albuns.add(a);
		
		streaming.diretorioDeMusicas.playlists.get(0).add(r);
		
		
		ConcreteVisitor c = new ConcreteVisitor();
		c.estilo = "fddd";
		c.busca3min = true;
		streaming.diretorioDeMusicas.aceitarVisitor(c);
		
	}
}
