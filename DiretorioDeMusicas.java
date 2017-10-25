import java.util.ArrayList;


// +++++++++++++++++++++
class Playlist {
	String nome;
	String estiloPrincipal;
	String estiloSecundario;
	ArrayList<Album> albuns = new ArrayList<Album>();
	ArrayList<Playlist> playlists = new ArrayList<Playlist>();
	
	public Playlist(String nome, String estiloPrincipal, String estiloSecundario) {
			this.nome = nome;
			this.estiloPrincipal = estiloPrincipal;
			this.estiloSecundario = estiloSecundario;
	}
	
	public void add(Album componente) {
			this.albuns.add(componente);
    }
    
    public void add(Playlist componente) {
			this.playlists.add(componente);
    }
	
    public void remove(Album componente) {
			this.albuns.remove(componente);
    }
    
    public void remove(Playlist componente) {
			this.playlists.remove(componente);
    }
    
    public void aceitarVisitor(ConcreteVisitor visitor) {
        visitor.visitar(this);
    }
    
}

class Album  {
	String nome;
	String nomeBanda;
	String estilo;
	ArrayList<Musica> musicas = new ArrayList<Musica>();
	
	public Album(String nome, String nomeBanda, String estilo){
		this.nome = nome;
		this.nomeBanda = nomeBanda;
		this.estilo = estilo;
	}
	
	public void add(Musica componente) {
        this.musicas.add(componente);
    }
	
    public void remove(Musica componente) {
        this.musicas.remove(componente);
    }
    
    public void aceitarVisitor(ConcreteVisitor visitor) {
        visitor.visitar(this);
    }
    
    void insereMusicas(ArrayList<Musica> musicas) {
		for(int i = 0;i < musicas.size();i++) {
			this.add(musicas.get(i));
		}
	}
    
}

class Musica  {
	String nome;
	String estilo;
	double duracaoMin;
	
	public Musica(String nome, String estilo, double duracaoMin) {
		this.nome = nome;
		this.estilo = estilo;
		this.duracaoMin = duracaoMin;
	}
	
	public void aceitarVisitor(ConcreteVisitor visitor) {
        visitor.visitar(this);
    }
	
}
// ++++++++++++++++++++++=

//+++++++++++++++++++++++

interface Visitor {
	void visitar(DiretorioDeMusicas diretorioDeMusicas);
	void visitar(Playlist playlist);
	void visitar(Album album);
	void visitar(Musica musica);
}

class ConcreteVisitor implements Visitor {
	public String estilo = null;
	public boolean busca3min = false;
	
	public ConcreteVisitor(String estilo, boolean busca3min) {
		this.estilo = estilo;
		this.busca3min = busca3min;
	}
	
	public void visitar(DiretorioDeMusicas diretorioDeMusicas) {
		for(int i = 0;i<diretorioDeMusicas.playlists.size();i++) {
			diretorioDeMusicas.playlists.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Playlist playlist) {
		for(int i = 0;i<playlist.playlists.size();i++) {
			if( (this.busca3min == true) && (playlist.estiloPrincipal.equals(this.estilo) ) )
				System.out.println(playlist.estiloPrincipal);
			playlist.playlists.get(i).aceitarVisitor(this);
		}
		for(int i = 0;i<playlist.albuns.size();i++) {
			if( (this.busca3min == true) && (playlist.estiloPrincipal.equals(this.estilo) ) )
				System.out.println(playlist.estiloPrincipal);
			playlist.albuns.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Album album) {
		for(int i = 0;i<album.musicas.size();i++) {
			album.musicas.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Musica musica) {
		if(this.busca3min == true) {
			if(musica.estilo.equals(this.estilo) && musica.duracaoMin > 3)
				System.out.println(musica.nome+" "+musica.estilo+" "+musica.duracaoMin);
		} else {
			if(this.estilo == null)
				System.out.println(musica.nome+" "+musica.estilo+" "+musica.duracaoMin);
			else {
				if(this.estilo.equals(musica.estilo) )
					System.out.println(musica.nome+" "+musica.estilo+" "+musica.duracaoMin);
			}
		}
		
	}
}

// +++++++++++++++++++++++

class DiretorioDeMusicas {
	ArrayList<Playlist> playlists = new ArrayList<Playlist>();
	
	public void aceitarVisitor(ConcreteVisitor visitor) {
        visitor.visitar(this);
    }
	
	void add(Playlist playlist) {
		this.playlists.add(playlist);
	}
	
}



