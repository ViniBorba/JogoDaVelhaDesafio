import java.util.Scanner;

public class ClassePrincipal {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Nome do jogador Um: ");
		Jogador jogador_1 = new Jogador(entrada.next());
		
		System.out.println("Nome do jogador Dois: ");
		Jogador jogador_2 = new Jogador(entrada.next());
		
		System.out.println("Informe o tamanho do tabuleiro: ");
		int auxTamanhoTabuleiro = entrada.nextInt();
		
		char jogar = 's';
		
		
		do { JogoDaVelha novoJogo = new JogoDaVelha(auxTamanhoTabuleiro, auxTamanhoTabuleiro);
			for(int i =0; i < auxTamanhoTabuleiro * auxTamanhoTabuleiro; i++) {
				
				//Jogador 1
				System.out.println("Jogador 1 informa linha: ");
				int linh1 = entrada.nextInt();
				
				System.out.println("Jogador 1 informa coluna: ");
				int coluna1 = entrada.nextInt();
				
				if(novoJogo.realizaJogada(linh1, coluna1, 'X')) {
					System.out.println("Jogada realizada");
				} else {
					System.out.println("JOGADA NÃO REALIZADA");
					System.out.println(novoJogo.toString());
					System.out.println("Jogador 1 informa linha: ");
					linh1 = entrada.nextInt();
					System.out.println("Jogador 1 informa coluna: ");
					coluna1 = entrada.nextInt();
					novoJogo.realizaJogada(linh1, coluna1, 'X');
				}
				if(novoJogo.vereficaGanhador(novoJogo.getTabuleiro())) {
					System.out.println("!!JOGADOR "+ jogador_1.getNome() +" GANHOU!!");
					jogador_1.setPontos(jogador_1.getPontos() + 1);
					System.out.println(novoJogo.toString());
					break;
				}
				System.out.println(novoJogo.toString());
				i++;
				if(i >= auxTamanhoTabuleiro * auxTamanhoTabuleiro) {
					break;
				}
				
				//Jogador 2
				System.out.println("Jogador 2 informa linha: ");
				int linh2 = entrada.nextInt();
				
				System.out.println("Jogador 2 informa coluna: ");
				int coluna2 = entrada.nextInt();
				
				if(novoJogo.realizaJogada(linh2, coluna2, 'O')) {
					System.out.println("Jogada realizada");
				} else {
					System.out.println("JOGADA NÃO REALIZADA");
					System.out.println(novoJogo.toString());
					System.out.println("Jogador 2 informa linha: ");
					linh2 = entrada.nextInt();
					System.out.println("Jogador informa coluna: ");
					coluna2 = entrada.nextInt();
					novoJogo.realizaJogada(linh1, coluna1, 'O');
				}
				if(novoJogo.vereficaGanhador(novoJogo.getTabuleiro())) {
					System.out.println("JOGADOR "+ jogador_2.getNome() + " GANHOU!!");
					jogador_2.setPontos(jogador_2.getPontos() + 1);
					System.out.println(novoJogo.toString());
					break;
				}
				System.out.println(novoJogo.toString());	
				
			}
			System.out.println("Digite s para jogar mias ou qlq letra para sair");
			jogar = entrada.next().charAt(0);
			
		} while (jogar == 's');
		
		System.out.println("Pontuação");
		System.out.println("Jogador: "+jogador_1.getNome()+ " Pontos: "+jogador_1.getPontos());
		System.out.println("Jogador: "+jogador_2.getNome()+ " Pontos: "+jogador_2.getPontos());

	}

}
