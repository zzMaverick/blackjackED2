package org.example.entity.Arvore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import org.example.entity.Jogo.*;

@Getter
@Setter
public class No {
        int idJogo;
        int altura;
        List<Jogador> jogadores;
        No esquerda;
        No direita;

        public No(int idJogo, List<Jogador> jogadores) {
            this.idJogo = idJogo;
            this.altura = 1;
            this.jogadores = jogadores;
            this.esquerda = null;
            this.direita = null;
        }
}
