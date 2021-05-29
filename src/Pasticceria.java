
public class Pasticceria {
	private String nome;
	private String luogo;
	private Prodotto prodotti[];
	private int numProdotti;
	
	public Pasticceria(String nome, String luogo,  int numProdottiMax) {
		this.nome = nome;
		this.luogo = luogo;
		prodotti = new Prodotto[numProdottiMax];
		numProdotti = 0;
	}
	
		//GET & SET
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public int getNumProdotti() {
		return numProdotti;
	}
	public void setNumProdotti(int numProdotti) {
		this.numProdotti = numProdotti;
	}
		
	@Override
	public String toString() {
		return "Pasticceria\nnome: " + nome + "\nluogo: " + luogo 
				+ "\nnumero prodotti: " + numProdotti + "\nprodotti:" + visualizzaProdotti();
	}
	
	public String visualizzaProdotti() {
		String p = "";
		for (int i = 0; i < numProdotti; i++)
			p += prodotti[i].toString() + "\n";
		return p;
	}
	public boolean aggiungiProdotto(Prodotto p) {
		if(numProdotti < prodotti.length) {
			prodotti[numProdotti] = p;
			numProdotti ++;
			return true;
		}
		return false;
	}
	public boolean eliminaProdotto(String cod) {
		for (int i = 0; i < numProdotti; i++) {
			if(prodotti[i].getCodice().equalsIgnoreCase(cod)) {
				numProdotti --;
				for (int j = i; j < numProdotti; j++) 
					prodotti[j] = prodotti[j+1];
				
				return true;
			}	
		}
		return false;
	}
	public Prodotto[] prodottiSenzaZucchero() {
		Prodotto senzaZucchero[] = new Prodotto[numProdotti];
		int n = 0;
		for (int i = 0; i < numProdotti; i++) 
			if(prodotti[i].getZucchero() == false) {
				senzaZucchero[n] = prodotti[i];
				n++;
			}
		return senzaZucchero;
	}
	public Prodotto prodottoPiuCostoso() {
		Prodotto max = new Prodotto("", "", 0.0f, false);
		for (int i = 0; i < numProdotti; i++) {
			if(prodotti[i].getPrezzo() > max.getPrezzo())
				max = prodotti[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		Pasticceria pa = new Pasticceria("Dolci", "Roma", 8);
		System.out.println(pa.aggiungiProdotto(new Prodotto("torta", "h7210j",17.40f,true)));
		System.out.println(pa.aggiungiProdotto(new Prodotto("crepes", "sdfae1",2.50f,true)));
		System.out.println(pa.aggiungiProdotto(new Prodotto("biscotti", "dged45",2.15f,false)));
		System.out.println(pa.aggiungiProdotto(new Prodotto("cheesecake", "kjfdsd10",15.90f,true)));
		System.out.println(pa.aggiungiProdotto(new Prodotto("fette biscottate", "kjadhail4",1.30f,false)));
		System.out.println(pa.aggiungiProdotto(new Prodotto("cornetto", "qqeqw47",1.50f,true)));
		System.out.println(pa.aggiungiProdotto(new Prodotto("bigne", "ahge59",0.90f,true)));
		System.out.println(pa.aggiungiProdotto(new Prodotto("ciambella alle mele", "bjkju21",14.80f,false)));
		System.out.println(pa.aggiungiProdotto(new Prodotto("errore", "volontario", 20.7f, true)));
		
		System.out.println(pa.toString());
		
		System.out.println(pa.eliminaProdotto("sdfae1"));
		System.out.println(pa.eliminaProdotto("ahge59"));
		System.out.println(pa.eliminaProdotto("erroreVolontario"));
		
		System.out.println("Prodotti senza zucchero:");
		Prodotto p[] = pa.prodottiSenzaZucchero();
		for (int i = 0; i < p.length; i++) 
			if(p[i] != null) System.out.println(p[i].toString());
			else break;
		System.out.println("prodotto piu' costoso:\n " + pa.prodottoPiuCostoso().toString());
		System.out.println("numero prodotti: " + pa.getNumProdotti());
	}
}
