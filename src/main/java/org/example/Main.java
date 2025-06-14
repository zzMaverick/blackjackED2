package org.example;


import org.example.entity.Arvore.Arvore;
import org.example.entity.Jogo.Carta;
import org.example.entity.Jogo.Jogador;
import org.example.entity.Jogo.Jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        int id = 1;
        Scanner sc = new Scanner(System.in);
        int opcaoDasCartas,opcaoDoJogo;
        while(true){
            System.out.println("1-Jogar nova partida");
            System.out.println("2-Consultar jogos");
            opcaoDoJogo = sc.nextInt();
            if(opcaoDoJogo == 1){
                Jogador jogadorCasa = new Jogador("Casa", new ArrayList<>(),0);
                Jogador jogador = new Jogador("Jogador", new ArrayList<>(),0);
                List<Carta> baralho = new ArrayList<>();
                List<Jogador> jogadores = new ArrayList<>();
                jogadores.add(jogadorCasa);
                jogadores.add(jogador);
                for (int i = 0; i < jogadores.size(); i++) {
                    System.out.println(jogadores.get(i));
                }
                Jogo jogo = new Jogo(jogadores,baralho);
                jogo.escreverCartas();
                jogo.embaralharCartas();
                jogo.criarJogo();
                while (true){
                    jogo.getJogadores().get(1).imprimirMao();
                    System.out.println("1-Pedir mais uma carta");
                    System.out.println("2-Parar");
                    opcaoDasCartas = sc.nextInt();
                    if (opcaoDasCartas == 2 )
                        break;
                    else {
                        jogadores.get(1).pedirMaisUma(jogo.getCartas());
                        if (jogo.contabilizar()) {
                            jogo.getJogadores().get(1).imprimirMao();
                            break;
                        }
                    }
                }
                jogo.finalizarjogo();
                arvore.inserir(id,jogadores);
                id++;
            }
            else{
                if(opcaoDoJogo == 2 ){
                    arvore.emOrdem();
                }
            }
        }
    }
}
