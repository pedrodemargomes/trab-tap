import java.util.ArrayList;
import java.util.Scanner; 

class p {
	public static void main(String[] args){
		
		//~ String n = "aa";
		//~ int h = 1;
		//~ if("aa1".equals(n+h)) {
			//~ System.out.println("ADDAD");
		//~ }
		//~ 
		//~ Scanner scan = new Scanner(System.in);
		//~ String s = scan.next();
		

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
		String a = "musica ";
		musicas.add(new Musica("aasa", "fff", 5));
		for(int i = 1;i < 100;i++) {
			musicas.add(new Musica( a+i, a+i, i));
		}
		
		ArrayList<Album> albuns = new ArrayList<Album>();
		a = "albums ";
		for(int i = 0;i < 20;i++) {
			albuns.add(new Album(a+i, a+i, a+i));
		}
		
		ArrayList<Musica> aux = new ArrayList<Musica>();
		
		for(int i = 0;i< 20; i++ ) {
			for(int j = 0;j< 5; j++ ) {
				aux.add(musicas.get(0));
				musicas.remove(0);
			}
			albuns.get(i).insereMusicas(aux);
			aux.clear();
		}
	
		
		for(int i = 0;i< 4; i++ )
			playlist1.add(albuns.get(i));
			
		for(int i = 4;i< 8; i++ )
			playlist2.add(albuns.get(i));
			
		for(int i = 8;i< 12; i++ )
			playlist3.add(albuns.get(i));
			
		for(int i = 12;i< 16; i++ )
			playlist4.add(albuns.get(i));
			
		for(int i = 16;i< 20; i++ )
			playlist5.add(albuns.get(i));
		
		streaming.diretorioDeMusicas.add(playlist1);
		streaming.diretorioDeMusicas.add(playlist2);
		streaming.diretorioDeMusicas.add(playlist4);
		
		
		ConcreteVisitor c = new ConcreteVisitor("musica 4",true);
		streaming.diretorioDeMusicas.aceitarVisitor(c);
		
	}
}
