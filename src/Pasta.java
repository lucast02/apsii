import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pasta implements ItemSistema {
    private final String nome;
    private final List<ItemSistema> filhos;

    public Pasta(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da pasta não pode ser vazio.");
        }

        this.nome = nome;
        this.filhos = new ArrayList<>();
    }

    public void adicionar(ItemSistema item) {
        Objects.requireNonNull(item, "O item não pode ser nulo.");

        if (item == this) {
            throw new IllegalArgumentException("Uma pasta não pode ser adicionada a ela mesma.");
        }

        if (item instanceof Pasta && ((Pasta) item).contem(this)) {
            throw new IllegalArgumentException("Essa operação criaria um ciclo entre pastas.");
        }

        filhos.add(item);
    }

    public void remover(ItemSistema item) {
        filhos.remove(item);
    }

    private boolean contem(ItemSistema itemProcurado) {
        for (ItemSistema filho : filhos) {
            if (filho == itemProcurado) {
                return true;
            }

            if (filho instanceof Pasta && ((Pasta) filho).contem(itemProcurado)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getTamanho() {
        int total = 0;

        for (ItemSistema filho : filhos) {
            total += filho.getTamanho();
        }

        return total;
    }

    @Override
    public void exibir(String recuo) {
        System.out.println(recuo + "+ " + nome + " (" + getTamanho() + " KB)");

        for (ItemSistema filho : filhos) {
            filho.exibir(recuo + "  ");
        }
    }
}
