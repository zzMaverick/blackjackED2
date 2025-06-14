package org.example.entity.Arvore;

import org.example.entity.Jogo.Jogador;

import java.util.List;

public class Arvore {
        private No raiz;

        public Arvore() {
            this.raiz = null;
        }

        private int altura(No n) {
            return n == null ? 0 : n.altura;
        }

        private int max(int a, int b) {
            return (a > b) ? a : b;
        }

        private No rotacaoDireita(No y) {
            No x = y.esquerda;
            No T2 = x.direita;

            x.direita = y;
            y.esquerda = T2;

            y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
            x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;

            return x;
        }

        private No rotacaoEsquerda(No x) {
            No y = x.direita;
            No T2 = y.esquerda;

            y.esquerda = x;
            x.direita = T2;

            x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
            y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;

            return y;
        }

        private int getBalance(No n) {
            return (n == null) ? 0 : altura(n.esquerda) - altura(n.direita);
        }

        private No inserir(No no, int idJogo, List<Jogador> jogadores) {
            if (no == null)
                return new No(idJogo, jogadores);

            if (idJogo < no.idJogo)
                no.esquerda = inserir(no.esquerda, idJogo, jogadores);
            else if (idJogo > no.idJogo)
                no.direita = inserir(no.direita, idJogo, jogadores);
            else
                return no;

            no.altura = 1 + max(altura(no.esquerda), altura(no.direita));
            int balance = getBalance(no);

            if (balance > 1 && idJogo < no.esquerda.idJogo)
                return rotacaoDireita(no);

            if (balance < -1 && idJogo > no.direita.idJogo)
                return rotacaoEsquerda(no);

            if (balance > 1 && idJogo > no.esquerda.idJogo) {
                no.esquerda = rotacaoEsquerda(no.esquerda);
                return rotacaoDireita(no);
            }

            if (balance < -1 && idJogo < no.direita.idJogo) {
                no.direita = rotacaoDireita(no.direita);
                return rotacaoEsquerda(no);
            }

            return no;
        }

        public void inserir(int idJogo, List<Jogador> jogadores) {
            raiz = inserir(raiz, idJogo, jogadores);
        }

        public void emOrdem() {
            emOrdem(raiz);
        }

        private void emOrdem(No no) {
            if (no != null) {
                emOrdem(no.esquerda);
                System.out.print(no.idJogo + " "+no.jogadores+"\n");
                emOrdem(no.direita);
            }
        }

}
