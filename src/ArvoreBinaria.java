public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore criada com sucesso");
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        if(estaVazia()) {
            this.raiz = novoNo;
        } else {
            No aux = this.raiz;
            while(aux != null) {
                if(conteudo < aux.getConteudo()) {
                    if(aux.getEsquerda() != null) {
                        aux = aux.getEsquerda();
                    } else {
                        aux.setEsquerda(novoNo);
                        return;
                    }
                } else {
                    if(aux.getDireita() != null) {
                        aux = aux.getDireita();
                    } else {
                        aux.setDireita(novoNo);
                        return;
                    }
                }
            }

        }
    }

    private boolean estaVazia () {
        if(this.raiz.getConteudo() == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public void percurso() {
        this.posOrdem(this.raiz);
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }
}
