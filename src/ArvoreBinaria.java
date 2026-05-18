public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);
        if(estaVazia()) {
            this.raiz = novoNo;
            System.out.println("Raiz criada com sucesso com valor: " + novoNo.getConteudo());
        } else {
            No aux = this.raiz;
            while(true) {
                if(aux.getConteudo() > novoNo.getConteudo()) {
                    if(aux.getEsquerda() == null) {
                        aux.setEsquerda(novoNo);
                        System.out.println("Nó " + novoNo.getConteudo() + " inserido com sucesso.");
                        return;
                    } else {
                        aux = aux.getEsquerda();
                    }
                } else if (aux.getConteudo() < novoNo.getConteudo()) {
                    if(aux.getDireita() == null) {
                        aux.setDireita(novoNo);
                        System.out.println("Nó " + novoNo.getConteudo() + " inserido com sucesso.");
                        return;
                    } else {
                        aux = aux.getDireita();
                    }
                } else {
                    System.out.println("Não são permitidos nós repetidos na árvore binária. O " + novoNo.getConteudo() + " já existe na árvore.");
                    return;
                }
            }
        }
    }

//    public void inserir(Integer conteudo) {
//        No novoNo = new No(conteudo);
//        if(estaVazia()) {
//            this.raiz = novoNo;
//            System.out.println("Raiz criada com sucesso com valor: " + novoNo.getConteudo());
//        } else {
//            inserirRecursivo(novoNo, this.raiz);
//        }
//    }
//
//    public void inserirRecursivo(No novoNo, No aux) {
//        if(aux.getConteudo() > novoNo.getConteudo()) {
//            if(aux.getEsquerda() == null) {
//                aux.setEsquerda(novoNo);
//                System.out.println("Nó " + novoNo.getConteudo() + " inserido com sucesso.");
//                return;
//            } else {
//                inserirRecursivo(novoNo, aux.getEsquerda());
//            }
//        } else if (aux.getConteudo() < novoNo.getConteudo()) {
//            if(aux.getDireita() == null) {
//                aux.setDireita(novoNo);
//                System.out.println("Nó " + novoNo.getConteudo() + " inserido com sucesso.");
//                return;
//            } else {
//                inserirRecursivo(novoNo, aux.getDireita());
//            }
//        } else {
//            System.out.println("Não são permitidos nós repetidos na árvore binária. O " + novoNo.getConteudo() + " já existe na árvore.");
//            return;
//        }
//    }

    private boolean estaVazia () {
        if(this.raiz.getConteudo() == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean remover(Integer conteudo) {
        if (estaVazia()){
            return false;
        }
        if (this.raiz.getConteudo().equals(conteudo)) {
            removerRaiz();
            return true;
        }
        No atual = this.raiz;
        No pai = null;
        while (atual != null && !atual.getConteudo().equals(conteudo)) {
            pai = atual;
            if (conteudo < atual.getConteudo()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }
        if (atual == null) {
            return false;
        }
        if(atual.getDireita() == null && atual.getEsquerda() == null){
            removerFolha(atual, pai);
        } else if (atual.getDireita() != null && atual.getEsquerda() != null) {
            removerPaiDeDois(atual);
        } else {
            removerPaiDeUm(atual, pai);
        }
        return true;
    }
    private void removerFolha(No atual, No pai){
        if (pai.getEsquerda() == atual) {
            pai.setEsquerda(null);
        } else {
            pai.setDireita(null);
        }
    }

    private void removerPaiDeUm(No atual, No pai){
        No netoDoPai;
        if (atual.getEsquerda() != null) {
            netoDoPai = atual.getEsquerda();
        } else {
            netoDoPai = atual.getDireita();
        }
        if (pai.getEsquerda() == atual) {
            pai.setEsquerda(netoDoPai);
        } else {
            pai.setDireita(netoDoPai);
        }
    }

    private void removerPaiDeDois(No atual){
        No paiSucessor = atual;
        No sucessor  = atual.getDireita();
        while (sucessor.getEsquerda() != null){
            paiSucessor  =  sucessor;
            sucessor = sucessor.getEsquerda();
        }
        atual.setConteudo(sucessor.getConteudo());

        if (paiSucessor.getEsquerda() == sucessor) {
            paiSucessor.setEsquerda(sucessor.getDireita());
        } else {
            paiSucessor.setDireita(sucessor.getDireita());
        }
    }

    private void removerRaiz(){

        if (this.raiz.getEsquerda() == null && this.raiz.getDireita() == null) {
            this.raiz = null;
        }
        else if (this.raiz.getEsquerda() != null && this.raiz.getDireita() != null) {
            removerPaiDeDois(this.raiz);
        }
        else {
            if (this.raiz.getEsquerda() != null) {
                this.raiz = this.raiz.getEsquerda();
            } else {
                this.raiz = this.raiz.getDireita();
            }
        }
    }

    public boolean percurso(String percurso) {
        if(estaVazia()) {
            System.out.println("A árvore não existe.");
            return false;
        }

        switch (percurso) {
            case("Pre"):
                System.out.println("Executando a árvore em pré ordem.");
                this.preOrdem(this.raiz);
                break;
            case("Em"):
                System.out.println("Executando a árvore em ordem.");
                this.emOrdem(this.raiz);
                break;
            case("Pos"):
                System.out.println("Executando a árvore em pós ordem.");
                this.posOrdem(this.raiz);
                break;
            default:
                System.out.println("Percurso inexistente!");
                break;

        }
        return false;
    }

    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

}