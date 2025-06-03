import java.util.*;

public class FilaBrasileira {
    private String id;
    private List<String> fila;

    public FilaBrasileira(String id) {
        this.id = id;
        this.fila = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public List<String> getFila() {
        return fila;
    }

    public void inserirPessoa(String pessoa, PessoasConhecemPessoas estrutura) {
        int melhorPosicao = -1;

        for (int i = 0; i < fila.size(); i++) {
            if (estrutura.conhece(pessoa, fila.get(i))) {
                melhorPosicao = i;
            }
        }

        if (melhorPosicao == -1) {
            fila.add(pessoa); // adiciona no fim
        } else {
            fila.add(melhorPosicao + 1, pessoa); // encosta depois do último conhecido
        }
    }

    public void removerPrimeiro() {
        if (!fila.isEmpty()) {
            fila.remove(0);
        }
    }

    public void removerPessoa(String nome) {
        fila.remove(nome);
    }

    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(id).append(" ");
        for (String nome : fila) {
            sb.append("[").append(nome).append("] ");
        }
        return sb.toString().trim();
    }
}
