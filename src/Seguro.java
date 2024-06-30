import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Seguro {
    private String nome;
    private String descricao;
    private double preco;
    private LocalDate validade;

    public Seguro(String nome, String descricao, double preco, LocalDate validade) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.validade = validade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "\nSeguro{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", validade=" + validade +
                '}';
    }
}
