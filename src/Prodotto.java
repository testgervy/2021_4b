// De Simone Matteo
public class Prodotto{
	private String nome;
	private String codice;
	private float prezzo;
	private boolean zucchero;
	//SET & GET
	public void setNome(String n){
		nome = n;
	}
	public String getNome (){
		return nome;
	}
	public void setCodice(String c){
		codice = c;
	}
	public String getCodice(){
		return codice;
	}
	public void setPrezzo(float p){
		prezzo = p;
	}
	public float getPrezzo(){
		return prezzo;
	}
	public void setZucchero(boolean z){
		zucchero = z;
	}
	public boolean getZucchero(){
		return zucchero;
	}
	@Override
	public String toString(){
		return "Prodotto:\nnome: " + nome + "\ncodice: " + codice + "\nprezzo: " 
				+ prezzo + "\nzucchero: " + zucchero + "\n";
	}
	public Prodotto (String n, String c, float pr, boolean z){
		nome = n;
		codice = c;
		prezzo = pr;
		zucchero = z;
	}
	//TEST
	public static void main(String[] args) {
		Prodotto p = new Prodotto("pasta", "01210j",1.2f,false);
		System.out.println(p.toString());
		
	}
	
}
