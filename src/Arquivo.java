public class Arquivo implements ItemSistema {
    private final String nome;
    private final int tamanho;

    public Arquivo(String nome, int tamanho) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do arquivo não pode ser vazio.");
        }
        if (tamanho < 0) {
            throw new IllegalArgumentException("O tamanho do arquivo não pode ser negativo.");
        }

        this.nome = nome;
        this.tamanho = tamanho;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public void exibir(String recuo) {
        System.out.println(recuo + "- " + nome + " (" + tamanho + " KB)");
    }
}
