
public class Jogador {
	private String nome;
	private int pontos;
	
	//Construtor
	Jogador(String nome){
		this.nome = nome;
		pontos = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setPontos( int ponto) {
		this.pontos = ponto;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	//Metodo toString
	@Override
	public String toString() {
		return "Nome do jogador: "+nome+"\nPontuação: "+pontos;
	}

}
