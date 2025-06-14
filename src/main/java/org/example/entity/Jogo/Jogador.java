package org.example.entity.Jogo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Jogador {
    private String jogadorName;
    private List<Carta> cartasList;
    private int valorTotal ;
    public Jogador(String jogador) {
        this.jogadorName = jogador;
        this.valorTotal =0;
    }

    public void pedirMaisUma(List<Carta> cartas){
        Carta cartaAdicionada = cartas.get(0);
        cartas.remove(0);
        cartasList.add(cartaAdicionada);
    }
    public void imprimirMao(){
        int total = 0;
        for(int i = 0; i < this.cartasList.size();i++)
            total +=  cartasList.get(i).getValor();
        this.valorTotal = total;
        System.out.println("Mao: "+cartasList);
    }
}
