public class Main {
    public static void main(String[] args) {
        Pasta projeto = new Pasta("Projeto");

        Pasta src = new Pasta("src");
        src.adicionar(new Arquivo("Main.java", 12));
        src.adicionar(new Arquivo("Pasta.java", 8));

        Pasta docs = new Pasta("docs");
        docs.adicionar(new Arquivo("relatorio.pdf", 300));

        projeto.adicionar(src);
        projeto.adicionar(docs);
        projeto.adicionar(new Arquivo("README.md", 2));

        projeto.exibir("");

        System.out.println("\nTamanho total do projeto: " + projeto.getTamanho() + " KB");
    }
}
