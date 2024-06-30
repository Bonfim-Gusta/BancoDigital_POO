import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class Banco {
    public String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta){
        this.contas.add(conta);
    }

    public void exibirContas(){
        if (!contas.isEmpty()){
            System.out.println(contas);
        }
        else {
            System.out.printf("Banco %s nao possui contas cadastradas%n", nome);
        }
    }

    public List<Conta> pesquisarPorCliente(String cliente){
        return contas.stream().filter(c -> c.cliente.getNome().equalsIgnoreCase(cliente)).toList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
