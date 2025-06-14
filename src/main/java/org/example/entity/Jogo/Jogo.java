package org.example.entity.Jogo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jogo {
    private List<Jogador> jogadores;
    private List<Carta> cartas;
    public void embaralharCartas(){
        System.out.println("Cartas antes de embaralhar: "+cartas);
        Collections.shuffle(this.cartas,new Random());
        System.out.println("Cartas depois de embaralhar: "+cartas);
    }
    public void escreverCartas() {
        for(int i = 0; i<3; i++) {
            Carta auxCarta = new Carta("Ás", 11);
            this.cartas.add(auxCarta);
            auxCarta = new Carta("Dois", 2);
            this.cartas.add(auxCarta);
            auxCarta = new Carta("Três", 3);
            this.cartas.add(auxCarta);
            auxCarta = new Carta("Quatro", 4);
            this.cartas.add(auxCarta);
            auxCarta = new Carta("Cinco", 5);
            this.cartas.add(auxCarta);
            auxCarta = new Carta("Seis", 6);
            this.cartas.add(auxCarta);
            auxCarta = new Carta("Sete", 7);
            this.cartas.add(auxCarta);
            auxCarta = new Carta("Oito", 8);
            this.cartas.add(auxCarta);
            auxCarta = new Carta("Nove", 9);
            this.cartas.add(auxCarta);
            auxCarta = new Carta("Valete", 10);
            this.cartas.add(auxCarta);
            auxCarta = new Carta("Dama", 10);
            this.cartas.add(auxCarta);
            auxCarta = new Carta("Rei", 10);
            this.cartas.add(auxCarta);
        }
    }
    public void criarJogo(){
        for(int i = 0; i < this.jogadores.size(); i++){
            for(int j = 0; j<2; j++){
                Carta cartaAdicionada = this.cartas.get(0);
                this.cartas.remove(0);
                this.jogadores.get(i).getCartasList().add(cartaAdicionada);
                contabilizar();
                System.out.println("Carta: " + cartaAdicionada + " removida do baralho e adicionada a o jogador: " + this.jogadores.get(i));
            }
        }
    }
    public boolean contabilizar(){
        for(int i = 0; i < jogadores.size(); i++){
            int total = 0;
            for(int j = 0; j < jogadores.get(i).getCartasList().size(); j++) {
                total += jogadores.get(i).getCartasList().get(j).getValor();
            }
            jogadores.get(i).setValorTotal(total);
            if(jogadores.get(i).getValorTotal() >= 21)
                return true;
        }
        return false;
    }
    public void finalizarjogo(){
        jogadores.sort(Comparator.comparingInt(Jogador::getValorTotal).reversed());
        System.out.println("Ranking:");
        if(jogadores.get(0).getValorTotal() <= 21) {
            System.out.println(jogadores.get(0).getJogadorName() + " Ganhou! Pois e o valor mais proximo de 21");
        }else{
            if (jogadores.get(0).getValorTotal() == jogadores.get(1).getValorTotal()){
                System.out.println(" Empate!");
            }
            else{
                System.out.println(jogadores.get(1).getJogadorName() + " Ganhou! pois o jogador " + jogadores.get(0).getJogadorName() +" Estorou");
            }

        }
    }
}
