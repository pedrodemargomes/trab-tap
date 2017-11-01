import java.util.ArrayList;

interface Composite {
	public void aceitarVisitor(ConcreteVisitorAll visitor);
    
    public void aceitarVisitor(ConcreteVisitorEstilo visitor);
    
    public void aceitarVisitor(ConcreteVisitorEstiloTempo visitor);
}


// +++++++++++++++++++++
class Playlist implements Composite {
	String nome;
	String estiloPrincipal;
	String estiloSecundario;
	ArrayList<Composite> albuns = new ArrayList<Composite>();
	ArrayList<Composite> playlists = new ArrayList<Composite>();
	
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
    
    public void aceitarVisitor(ConcreteVisitorAll visitor) {
        visitor.visitar(this);
    }
    
    public void aceitarVisitor(ConcreteVisitorEstilo visitor) {
        visitor.visitar(this);
    }
    public void aceitarVisitor(ConcreteVisitorEstiloTempo visitor) {
        visitor.visitar(this);
    }
    
}

class Album implements Composite {
	String nome;
	String nomeBanda;
	String estilo;
	ArrayList<Composite> musicas = new ArrayList<Composite>();
	
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
    
    public void aceitarVisitor(ConcreteVisitorAll visitor) {
        visitor.visitar(this);
    }
    
    public void aceitarVisitor(ConcreteVisitorEstilo visitor) {
        visitor.visitar(this);
    }
    public void aceitarVisitor(ConcreteVisitorEstiloTempo visitor) {
        visitor.visitar(this);
    }
    
    void insereMusicas(ArrayList<Musica> musicas) {
		for(int i = 0;i < musicas.size();i++) {
			this.add(musicas.get(i));
		}
	}
    
}

class Musica implements Composite {
	String nome;
	String estilo;
	double duracaoMin;
	
	public Musica(String nome, String estilo, double duracaoMin) {
		this.nome = nome;
		this.estilo = estilo;
		this.duracaoMin = duracaoMin;
	}
	
	public void aceitarVisitor(ConcreteVisitorAll visitor) {
        visitor.visitar(this);
    }
    
    public void aceitarVisitor(ConcreteVisitorEstilo visitor) {
        visitor.visitar(this);
    }
    public void aceitarVisitor(ConcreteVisitorEstiloTempo visitor) {
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

class ConcreteVisitorEstiloTempo implements Visitor {
	public ConcreteVisitorEstiloTempo(String estilo) {
		this.estilo = estilo;
	}
	String estilo;
	public void visitar(DiretorioDeMusicas diretorioDeMusicas) {
		for(int i = 0;i<diretorioDeMusicas.playlists.size();i++) {
			diretorioDeMusicas.playlists.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Playlist playlist) {
		if(playlist.estiloPrincipal == this.estilo)
			System.out.println(playlist.nome+" "+playlist.estiloPrincipal);
		for(int i = 0;i<playlist.playlists.size();i++) {
			playlist.playlists.get(i).aceitarVisitor(this);
		}
		for(int i = 0;i<playlist.albuns.size();i++) {
			playlist.albuns.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Album album) {
		for(int i = 0;i<album.musicas.size();i++) {
			album.musicas.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Musica musica) {
		if( (musica.estilo == this.estilo) && (musica.duracaoMin > 3) )
			System.out.println(musica.nome+" "+musica.estilo+" "+musica.duracaoMin);
	}
}

class ConcreteVisitorEstilo implements Visitor {
	public ConcreteVisitorEstilo(String estilo) {
		this.estilo = estilo;
	}
	String estilo;
	public void visitar(DiretorioDeMusicas diretorioDeMusicas) {
		for(int i = 0;i<diretorioDeMusicas.playlists.size();i++) {
			diretorioDeMusicas.playlists.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Playlist playlist) {
		for(int i = 0;i<playlist.playlists.size();i++) {
			playlist.playlists.get(i).aceitarVisitor(this);
		}
		for(int i = 0;i<playlist.albuns.size();i++) {
			playlist.albuns.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Album album) {
		for(int i = 0;i<album.musicas.size();i++) {
			album.musicas.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Musica musica) {
		if(musica.estilo == this.estilo)
			System.out.println(musica.nome+" "+musica.estilo+" "+musica.duracaoMin);
	}
}

class ConcreteVisitorAll implements Visitor {	
	public void visitar(DiretorioDeMusicas diretorioDeMusicas) {
		for(int i = 0;i<diretorioDeMusicas.playlists.size();i++) {
			diretorioDeMusicas.playlists.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Playlist playlist) {
		for(int i = 0;i<playlist.playlists.size();i++) {
			playlist.playlists.get(i).aceitarVisitor(this);
		}
		for(int i = 0;i<playlist.albuns.size();i++) {
			playlist.albuns.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Album album) {
		for(int i = 0;i<album.musicas.size();i++) {
			album.musicas.get(i).aceitarVisitor(this);
		}
	}
	
	public void visitar(Musica musica) {
		System.out.println(musica.nome+" "+musica.estilo+" "+musica.duracaoMin);
	}
}

// +++++++++++++++++++++++

class DiretorioDeMusicas implements Composite {
	ArrayList<Composite> playlists = new ArrayList<Composite>();
	
	public void aceitarVisitor(ConcreteVisitorAll visitor) {
        visitor.visitar(this);
    }
    
    public void aceitarVisitor(ConcreteVisitorEstilo visitor) {
        visitor.visitar(this);
    }
    public void aceitarVisitor(ConcreteVisitorEstiloTempo visitor) {
        visitor.visitar(this);
    }
	
	void add(Playlist playlist) {
		this.playlists.add(playlist);
	}
	
}



