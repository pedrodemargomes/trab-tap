import java.util.ArrayList;
import java.util.Scanner; 

class p {
	public static void main(String[] args){

		Streaming streaming = Streaming.getInstance();
		
		//System.out.println( streaming.diretorioDeMusicas.playlists.get(0).albuns.get(0).musicas.get(0).nome );
		Playlist playlist1 = new Playlist("a","a","a");
		Playlist playlist2 = new Playlist("b","b","b");
		Playlist playlist3 = new Playlist("c","c","c");
		Playlist playlist4 = new Playlist("d","d","d");
		Playlist playlist5 = new Playlist("e","e","e");
		
		playlist1.add(playlist3);
		playlist2.add(playlist5);
		
		ArrayList<Musica> musicas = new ArrayList<Musica>();
		
		musicas.add(new Musica("Baby Be Mine", "Disco", 4));
		musicas.add(new Musica("The Girl Is Mine", "Disco", 3));
		
		musicas.add(new Musica("Speak to Me", "Rock",1));
		musicas.add(new Musica("Breathe", "Rock", 2));
		
		musicas.add(new Musica("Hells Bells", "Hard rock", 5));
		musicas.add(new Musica("Shoot to Thrill", "Hard rock", 5));
		musicas.add(new Musica("Stayin' Alive" ,  "Disco", 4));
		musicas.add(new Musica("How Deep Is Your Love?" ,  "Disco",	4));
		musicas.add(new Musica("Rolling in the Deep", "Soul", 3));
		musicas.add(new Musica("Don't You Remember", "Soul", 4));
		musicas.add(new Musica("Without Me", "Hip Hop", 4));
		musicas.add(new Musica("Business" , "Hip Hop",4));
		musicas.add(new Musica(	"Rehab","Soul",3));
		musicas.add(new Musica("You Know I'm No Good","Soul", 4));
		musicas.add(new Musica("Enter Sandman","Heavy metal",5));
		musicas.add(new Musica("Sad but True","Heavy metal", 5));
		musicas.add(new Musica("Is This Love","Reggae", 3));
		musicas.add(new Musica("No Woman, No Cry" ,"Reggae",7));
		musicas.add(new Musica("Welcome To The Jungle","Hard rock",	4));
		musicas.add(new Musica("It's So Easy","Hard rock",  3));
		musicas.add(new Musica("Don't Panic","rock alternativo", 2));
		musicas.add(new Musica("Shiver","rock alternativo ", 4));
		musicas.add(new Musica("Kid A","Eletronica", 4));
		musicas.add(new Musica("The National Anthem","Eletronica", 5));
		musicas.add(new Musica("SexyBack","Pop", 4));
		musicas.add(new Musica("My Love","Pop", 4));
		musicas.add(new Musica("Thunder on the Mountain","Blues", 5));
		musicas.add(new Musica("Spirit on the Water","Blues", 7));
		musicas.add(new Musica("American Idiot","punk rock ",2));
		musicas.add(new Musica("Jesus of Suburbia","punk rock ", 9));
		musicas.add(new Musica("Cabeça Dinossauro","Rock",2));
		musicas.add(new Musica("Polícia","Rock", 2));
		musicas.add(new Musica("Wake Up Mr. West","Hip Hop", 0));
		musicas.add(new Musica("Heard 'Em Say","Hip Hop", 3));
		musicas.add(new Musica("The Power of Equality","Rock", 4));
		musicas.add(new Musica("If You Have to Ask","Rock",3));
		musicas.add(new Musica("Eduardo e Mônica","rock alternativo", 4));
		musicas.add(new Musica("Central Do Brasil", "rock alternativo",1));
		musicas.add(new Musica("In Bloom","Rock alternativo", 4));
		musicas.add(new Musica("Come As You Are", "Rock alternativo",3));
		
		ArrayList<Album> albuns = new ArrayList<Album>();
		
		albuns.add(new Album("Thriller" ,"Michael Jackson", "Disco"));
		albuns.add(new Album("The Dark Side of the Moon"," Pink Floyd", "Rock"));
		albuns.add(new Album("Back in Black", "AC/DC ", "Hard rock"));
		albuns.add(new Album("Saturday Night Fever" , "Bee Gees", "Disco"));
		albuns.add(new Album("21", "Adele", "Pop"));
		albuns.add(new Album("The Eminem Show" ,"Eminem", "Hip Hop"));
		albuns.add(new Album("Back to Black", "Amy Winehouse", "soul"));
		albuns.add(new Album("The Black Album", "Metallica","Heavy metal"));
		albuns.add(new Album("Legend", "Bob Marley", "Reggae"));
		albuns.add(new Album("Appetite for Destruction" ,"Guns N'Roses", "Hard rock"));
		albuns.add(new Album("Parachutes", "Coldplay", "rock alternativo "));
		albuns.add(new Album("Kid A", "Radiohead", "Eletronica"));
		albuns.add(new Album("FutureSex", "Justin Timberlake" , "Pop"));
		albuns.add(new Album("Modern Times", "Bob Dylan", "Blues"));
		albuns.add(new Album("American Idiot", "Green Day", "punk rock "));
		albuns.add(new Album("Cabeça Dinossauro", "Titãs", "Rock"));
		albuns.add(new Album("Late Registration", "Kanye West", "Hip Hop"));
		albuns.add(new Album("Blood Sugar Sex Magik", "Red Hot Chili Peppers", "Rock"));
		albuns.add(new Album("Dois", "Legião Urbana", "rock alternativo"));
		albuns.add(new Album("Nevermind", "Nirvana", "Rock alternativo"));
		
		ArrayList<Musica> aux = new ArrayList<Musica>();
		
		for(int i = 0;i< 20; i++ ) {
			for(int j = 0;j< 2; j++ ) {
				aux.add(musicas.get(0));
				musicas.remove(0);
			}
			albuns.get(i).insereMusicas(aux);
			aux.clear();
		}
		
		for(int i = 0;i< 4; i++ ) {
			playlist1.add(albuns.get(0));
			albuns.remove(0);
		}
		
		for(int i = 0;i< 4; i++ ) {
			playlist2.add(albuns.get(0));
			albuns.remove(0);
		}
		
		for(int i = 0;i< 4; i++ ) {
			playlist3.add(albuns.get(0));
			albuns.remove(0);
		}
		
		for(int i = 0;i< 4; i++ ) {
			playlist4.add(albuns.get(0));
			albuns.remove(0);
		}
		for(int i = 0;i< 4; i++ ) {
			playlist5.add(albuns.get(0));
			albuns.remove(0);
		}
		
		streaming.diretorioDeMusicas.add(playlist1);
		streaming.diretorioDeMusicas.add(playlist2);
		streaming.diretorioDeMusicas.add(playlist4);
		
		
		ConcreteVisitorEstilo c = new ConcreteVisitorEstilo("Hard rock");
		streaming.diretorioDeMusicas.aceitarVisitor(c);
		
	}
}
