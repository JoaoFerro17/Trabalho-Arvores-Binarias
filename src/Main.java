public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(-2);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(8);
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(-42);
        arvoreBinaria.inserir(99);
        arvoreBinaria.inserir(0);
        arvoreBinaria.inserir(87);
        arvoreBinaria.inserir(-10);
        arvoreBinaria.inserir(-11);
        arvoreBinaria.inserir(-9);
        System.out.println(arvoreBinaria.remover(-42));
        arvoreBinaria.percurso("Em");
    }
}
