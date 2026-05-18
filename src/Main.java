public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(11);
        arvoreBinaria.inserir(12);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(1);
        arvoreBinaria.remover(5);
        arvoreBinaria.percurso("Pre");
    }
}
