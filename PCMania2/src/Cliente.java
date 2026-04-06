import Eletronico.Computador;

public class Cliente {
    private int contagemPcs;
    private String nome;
    private String cpf;
    private Computador[] computadores = new Computador[100];

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Computador[] getComputadores() {
        return computadores;
    }

    public int getContagemPcs() {
        return contagemPcs;
    }

    public void setContagemPcs(int contagemPcs) {
        this.contagemPcs = contagemPcs;
    }

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;

        System.out.println("Instância Cliente Criada!");
    }

    public void calculaTotalCompra(){
        float totalCompra = 0;
        for(int i = 0; i < contagemPcs; i++){
            totalCompra += computadores[i].getPreco();
        }
        System.out.println("════════════════════════════════════════");
        System.out.println("💵 RESUMO DO PEDIDO:");
        System.out.println("   📦 Total de computadores: " + contagemPcs);
        System.out.println("   💰 Valor total: R$ " + String.format("%.2f", totalCompra));
        System.out.println("════════════════════════════════════════");
    }

}
