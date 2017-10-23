import java.util.ArrayList;

// +++++++++++++++++++++
class Playlist {
	String nome;
	String estiloPrincipal;
	String estiloSecundario;
	ArrayList<Album> albuns = new ArrayList<Album>();
	
	public void aceitarVisitor(PlaylistVisitor visitor) {
        visitor.visitar(this);
    }
	
	void add(Album album) {
		albuns.add(album);
	}
	
	void remove(Album album) {
		albuns.remove(album);
	}
}

class Album {
	String nome;
	String nomeBanda;
	String estilo;
	ArrayList<Musica> musicas = new ArrayList<Musica>();
	
	public void aceitarVisitor(AlbumVisitor visitor) {
        visitor.visitar(this);
    }
	
	void add(Musica musica) {
		musicas.add(musica);
	}
	
	void remove(Musica musica) {
		musicas.remove(musica);
	}
}

class Musica {
	String nome;
	String estilo;
	double duracaoMin;
	
	public void aceitarVisitor(MusicaVisitor visitor) {
        visitor.visitar(this);
    }
}
// ++++++++++++++++++++++=

//+++++++++++++++++++++++

abstract class Visitor {
	void visitar();
}

class ConcreteVisitorAll extends Visitor {
	void visitar(DiretorioDeMusicas diretorioDeMusicas) {
		for(int i = 0;i<diretorioDeMusicas.playlists.size();i++) {
			diretorioDeMusicas.playlists.get(i).aceitarVisitor(new PlaylistVisitor());
		}
	}
	
	void visitar(Playlist playlist) {
		for(int i = 0;i<playlist.albuns.size();i++) {
			playlist.albuns.get(i).aceitarVisitor(new AlbumVisitor());
		}
	}

	void visitar(Album album) {
		for(int i = 0;i<album.musicas.size();i++) {
			album.musicas.get(i).aceitarVisitor(new MusicaVisitor());
		}
	}

	void visitar(Musica musica) {
		System.out.println(musica.nome+" "+musica.estilo+" "+musica.duracaoMin);
	}
}

class ConcreteVisitorEstilo extends Visitor {
	void visitar(DiretorioDeMusicas diretorioDeMusicas, String estilo) {
		for(int i = 0;i<diretorioDeMusicas.playlists.size();i++) {
			diretorioDeMusicas.playlists.get(i).aceitarVisitor(new PlaylistVisitor(), estilo);
		}
	}
	
	void visitar(Playlist playlist, String estilo) {
		for(int i = 0;i<playlist.albuns.size();i++) {
			playlist.albuns.get(i).aceitarVisitor(new AlbumVisitor(), estilo);
		}
	}
	
	void visitar(Album album, String estilo) {
		for(int i = 0;i<album.musicas.size();i++) {
			album.musicas.get(i).aceitarVisitor(new MusicaVisitor(), estilo);
		}
	}
	
	void visitar(Musica musica, String estilo) {
		if(estilo == musica.estilo)
			System.out.println(musica.nome+" "+musica.estilo+" "+musica.duracaoMin);
	}
}

// +++++++++++++++++++++++


//~ interface ComponenteDiretorioDeMusicas {
	//~ void printMusicas();
//~ }

class DiretorioDeMusicas /*implements ComponenteDiretorioDeMusicas*/ {
	ArrayList<Playlist> playlists = new ArrayList<Playlist>();
	
    //~ public void printMusicas() {
		//~ for(int i=0;i< playlists.size();i++) {
			//~ playlists.get(i).printMusicas();
		//~ }
    //~ }
    
    public void add(Playlist playlist) {
        playlists.add(playlist);
    }
	
    public void remove(Playlist playlist) {
        playlists.remove(playlist);
    }
    
    public void aceitarVisitor(Visitor visitor) {
        visitor.visitar(this);
    }
	
}

//~ class DiretorioDeMusicasFolha implements ComponenteDiretorioDeMusicas {
	//~ public void printMusicas() {
		//~ System.out.println("aaa");
    //~ }
//~ }




