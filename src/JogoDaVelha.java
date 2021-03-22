import java.util.Arrays;

public class JogoDaVelha {

	private char[][] tabuleiro;
	
	//Construtor
	JogoDaVelha(int linhas, int colunas){
		tabuleiro = new char[linhas][colunas];
	}
	
	//metodo que realiza a jogada
	public boolean realizaJogada(int linha, int coluna, char valor) {
		//tratar no main
		//true jogada realizada false jogada não realizada
		char auxChar = tabuleiro[linha][coluna];
		if(auxChar == 'X' || auxChar == 'O') {
			return false;
		}
		tabuleiro[linha][coluna] = valor;
		return true;
	}
	
	//Metodo pra ver se aluem ganhou
	public boolean vereficaGanhador(char[][] tabuleiro) {
		
		//array com X serve para comprar
		char[] arrayDeX = new char[tabuleiro.length];
		for(int linha =0; linha < arrayDeX.length; linha++) {
				arrayDeX[linha] = 'X';			
		}
		
		//array com O serve para comprar
		char[] arrayDeO = new char[tabuleiro.length];
		for(int linha =0; linha < arrayDeO.length; linha++) {
				arrayDeO[linha] = 'O';			
		}

		//Verefica se tem ganhador nas linhas
		char[] arrayCopare1 = new char[tabuleiro.length];//Array vai guardar informações de um dos array bidimensional
		for(int linha =0; linha < tabuleiro.length; linha++) {
			for(int coluna =0; coluna < tabuleiro[linha].length; coluna++) {
				arrayCopare1[coluna] = tabuleiro[coluna][linha];//Guarda as colunas do array bidimensional
			}
			if(Arrays.equals(arrayDeX, arrayCopare1)) {
				return true;
			}
			if(Arrays.equals(arrayDeO, arrayCopare1)) {
				return true;
			}
		}
		
		//Verefica se tem ganahador na coluna esquerda p/ direita
		char[] arrayCopare2 = new char[tabuleiro.length];
		for(int linha =0; linha < tabuleiro.length; linha++) {
				arrayCopare2[linha] = tabuleiro[linha][linha];//Guarda a diagonal esquerda p/ direita
			
			if(Arrays.equals(arrayDeX, arrayCopare2)) {
				return true;
			}
			if(Arrays.equals(arrayDeO, arrayCopare2)) {
				return true;
			}
		}
		
		//Ganhador nas linhas
		char[] arrayCopare3 = new char[tabuleiro.length];
		for(int linha =0; linha < tabuleiro.length; linha++) {
			for(int coluna =0; coluna < tabuleiro.length; coluna++) {
				arrayCopare3[coluna] = tabuleiro[linha][coluna];//Guarda o valor das linhas
			}
			if(Arrays.equals(arrayDeX, arrayCopare3)) {
				return true;
			}
			if(Arrays.equals(arrayDeO, arrayCopare3)) {
				return true;
			}
		}
		
		//Ganhador na coluna direita p/ esquerda
		char[] arrayCopare4 = new char[tabuleiro.length];
		for(int i = arrayDeX.length - 1; i > -1; i--) {
			int aux = 0;
			arrayCopare4[i] = tabuleiro[i][aux];
			
			if(Arrays.equals(arrayDeX, arrayCopare4)) {
				return true;
			}
			if(Arrays.equals(arrayDeO, arrayCopare4)) {
				return true;
			}
			aux++;
		}
		
		return false;
	}
	
	//
	public char[][] getTabuleiro(){
		return tabuleiro;
	}
	
	//
	@Override
	public String toString() {

		StringBuffer stringBuffer = new StringBuffer();
		
		for(int linha =0; linha < tabuleiro.length; linha++) {
			for(int coluna =0; coluna < tabuleiro[linha].length; coluna++) {
				stringBuffer.append("|"+tabuleiro[linha][coluna]+"|");
			}
			stringBuffer.append("\n");
		}
		
		return stringBuffer.toString();
	}

}
