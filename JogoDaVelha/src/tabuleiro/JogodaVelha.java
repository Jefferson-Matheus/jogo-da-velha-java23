package tabuleiro;

import java.util.Scanner;

public class JogodaVelha {
	private char[][] tabuleiro;
	private char jogador1;
	private char jodador2;
	private char jogadorAtual;
	private int tentativas;
	private boolean vencedor;
	
	public JogodaVelha() {
		this.tabuleiro = new char[3][3];
		this.jogador1 = 'X';
		this.jodador2 = 'O';
		this.vencedor = false;
		this.jogadorAtual = jogador1;
		this.tentativas = 9;
		popularArray();
	}
	

	private void popularArray() {
		for(int i = 0; i < tabuleiro.length; i++) {
			for(int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = ' ';
			}
		}
	}
	
	public void exibirJogoDaVelha() {
		System.out.print("\t" + tabuleiro[0][0] + "|" + tabuleiro[0][1] + "|" + tabuleiro[0][2] + "\n");
		
		System.out.print("\t-----\n");
		
		System.out.print("\t" + tabuleiro[1][0] + "|" + tabuleiro[1][1] + "|" + tabuleiro[1][2] + "\n");
		
		System.out.print("\t-----\n");
		
		System.out.print("\t" + tabuleiro[2][0] + "|" + tabuleiro[2][1] + "|" + tabuleiro[2][2]  + "\n");
	}
	
	private boolean verificarlinhas() {
		if((tabuleiro[0][0] == 'O') && (tabuleiro[0][1] == 'O') && (tabuleiro[0][2] == 'O') ) {
			jogadorAtual = jodador2;
			return true;
			
		}else if((tabuleiro[1][0] == 'O') && (tabuleiro[1][1] == 'O') && (tabuleiro[1][2] == 'O')) {
			jogadorAtual = jodador2;
			return true;
			
		}else if((tabuleiro[2][0] == 'O') && (tabuleiro[2][1] == 'O') && (tabuleiro[2][2] == 'O')) {
			jogadorAtual = jodador2;
			return true;
		}
		
		
		
		if((tabuleiro[0][0] == 'X') && (tabuleiro[0][1] == 'X') && (tabuleiro[0][2] == 'X') ) {
			jogadorAtual = jogador1;
			return true;
			
		} else if((tabuleiro[1][0] == 'X') && (tabuleiro[1][1] == 'X') && (tabuleiro[1][2] == 'X')) {
			jogadorAtual = jogador1;
			return true;
			
		} else if((tabuleiro[2][0] == 'X') && (tabuleiro[2][1] == 'X') && (tabuleiro[2][2] == 'X')) {
			jogadorAtual = jogador1;
			return true;
		}
		
		return false;
		
	}
	
	private boolean verificarColunas() {
		if((tabuleiro[0][0] == 'O') && (tabuleiro[1][0] == 'O') && (tabuleiro[2][0] == 'O') ) {
			jogadorAtual = jodador2;
			return true;
			
		}else if((tabuleiro[0][1] == 'O') && (tabuleiro[1][1] == 'O') && (tabuleiro[2][1] == 'O')) {
			jogadorAtual = jodador2;
			return true;
			
		}else if((tabuleiro[0][2] == 'O') && (tabuleiro[1][2] == 'O') && (tabuleiro[2][2] == 'O')) {
			jogadorAtual = jodador2;
			return true;
		}
		
		
		
		if((tabuleiro[0][0] == 'X') && (tabuleiro[1][0] == 'X') && (tabuleiro[2][0] == 'X') ) {
			jogadorAtual = jogador1;
			return true;
			
		} else if((tabuleiro[0][1] == 'X') && (tabuleiro[1][1] == 'X') && (tabuleiro[2][1] == 'X')) {
			jogadorAtual = jogador1;
			return true;
			
		} else if((tabuleiro[0][2] == 'X') && (tabuleiro[1][2] == 'X') && (tabuleiro[2][2] == 'X')) {
			jogadorAtual = jogador1;
			return true;
		}
		
		return false;
	}
	
	private boolean verificarDiagonais() {
		if((tabuleiro[0][0] == 'X') && (tabuleiro[1][1] == 'X') && (tabuleiro[2][2] == 'X')) {
			jogadorAtual = jogador1;
			return true;
			
		}else if((tabuleiro[0][2] == 'X') && (tabuleiro[1][1] == 'X') && (tabuleiro[2][0] == 'X')) {
			jogadorAtual = jogador1;
			return true;
			
		}
		
		
		if((tabuleiro[0][0] == 'O') && (tabuleiro[1][1] == 'O') && (tabuleiro[2][2] == 'O')) {
			jogadorAtual = jodador2;
			return true;
			
		}else if((tabuleiro[0][2] == 'O') && (tabuleiro[1][1] == 'O') && (tabuleiro[2][0] == 'O')) {
			jogadorAtual = jodador2;
			return true;
			
		}
		
		return false;
	}
	
	
	public void iniciar() {
		Scanner scanner = new Scanner(System.in);
		while(!vencedor) {
			

			System.out.println("=================");
			
			exibirJogoDaVelha();
			
			System.out.println("=================");
			
			if(verificarlinhas()) {
				System.out.println("O " + jogadorAtual + " Ganhou");
				break;
			}
			
			if(verificarColunas()) {
				System.out.println("O " + jogadorAtual + " Ganhou");
				break;
			}
			
			if(verificarDiagonais()) {
				System.out.println("O " + jogadorAtual + " Ganhou");
				break;
			}
			
			if(verificarVelha()) {
				System.out.println("O Jogo Deu Velha");
				break;
			}
			
			System.out.println("Vez Do Jogador: " + jogadorAtual);
			
			System.out.println("=================");
			
			System.out.println("Digite Números De 0 Até 2 Para Informar A Linha");
			
			int linha = scanner.nextInt();
			
			System.out.println("Digite Números De 0 Até 2 Para Informar A Coluna");
			
			int coluna = scanner.nextInt();
			
			jogada(linha, coluna);
			
		}
		
		
		
	}
	
	
	private void jogada(int linha, int coluna) {
		if(verificarCedulaVazia(linha, coluna)) {
			tabuleiro[linha][coluna] = jogadorAtual;
			passarAVez();
			diminuirTentativas();
		}else {
			System.out.println("Cedula Invalida");
		}
		
	}
	
	
	private boolean verificarCedulaVazia(int linha, int coluna) {
		
		if(tabuleiro[linha][coluna] == ' ') {
			return true;
		}
		
		return false;
	}
	
	
	private void passarAVez() {
		if(jogadorAtual == 'X') {
			jogadorAtual = jodador2;
		}else {
			jogadorAtual = jogador1;
		}
	}


	private int getTentativas() {
		return tentativas;
	}


	private void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}
	
	
	private void diminuirTentativas() {
		setTentativas(getTentativas() - 1);
	}
	
	
	private boolean verificarVelha() {
		if(getTentativas() == 0) {
			return true;
		}
		
		return false;
	}
	
}
