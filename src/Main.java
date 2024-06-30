import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Banco santander = new Banco("Santander");
        Banco x = new Banco("x");

        Cliente cliente = new Cliente();
        cliente.setNome("Gustavo");
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Adriana");

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);
        Conta cc2 = new ContaCorrente(cliente2);
        Conta poupanca2 = new ContaPoupanca(cliente2);

        santander.adicionarConta(cc);
        santander.adicionarConta(poupanca);
        santander.adicionarConta(cc2);
        santander.adicionarConta(poupanca2);

        cc.depositar(100);
        cc.transferir(10, poupanca);

        cc.adicionarSeguro("Seguro cartao de debito",
                "Protege seu cartão em caso de roubo",
                25.49,
                LocalDate.of(2025,6,28));

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        System.out.println("======================================================");

        santander.exibirContas();
        x.exibirContas();

        System.out.println("======================================================");

        System.out.println(santander.pesquisarPorCliente("Gustavo"));
    }
}