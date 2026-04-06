package Eletronico;

public class Computador {
    private String marca;
    private float preco;
    private HardwareBasico[] hardware = new HardwareBasico[3];
    private MemoriaUSB memoriaUSB;
    private SistemaOperacional sistemaOperacional;

    public Computador(String marca) {
        this.marca = marca;

        if(this.marca.equals("Apple")){
            this.preco = 2200;
            this.hardware[0] = new HardwareBasico("Pentium Core i3", 2200);
            this.hardware[1] = new HardwareBasico("Memória RAM", 8);
            this.hardware[2] = new HardwareBasico("HD", 500);
            this.sistemaOperacional = new SistemaOperacional("macOS Sequoia", 64);
        }

        else if(this.marca.equals("Samsung")){
            this.preco = 3434;
            this.hardware[0] = new HardwareBasico("Pentium Core i5", 3370);
            this.hardware[1] = new HardwareBasico("Memória RAM", 16);
            this.hardware[2] = new HardwareBasico("HD", 1000);
            this.sistemaOperacional = new SistemaOperacional("Windows 8", 64);
        }

        else if(this.marca.equals("Dell")){
            this.preco = 7878;
            this.hardware[0] = new HardwareBasico("Pentium Core i7", 4500);
            this.hardware[1] = new HardwareBasico("Memória RAM", 32);
            this.hardware[2] = new HardwareBasico("HD", 2000);
            this.sistemaOperacional = new SistemaOperacional("Windows 10", 64);
        }
    }

    public void addMemoriaUsb(MemoriaUSB memoriaUSB){
        this.memoriaUSB = memoriaUSB;
    }

    public String getMarca() {
        return marca;
    }

    public float getPreco() {
        return preco;
    }


    public void mostraConfigsPC() {
        System.out.println("🏷️  Marca: " + this.marca);
        System.out.println("💰 Preço: R$ " + String.format("%.2f", this.preco));
        System.out.println("🔧 HARDWARE:");
        for (int i = 0; i < 3; i++) {
            System.out.println("   • " + hardware[i].getNome() + ": " + hardware[i].getCapacidade() +
                             (hardware[i].getNome().contains("RAM") || hardware[i].getNome().contains("HD") ? "GB" :
                              hardware[i].getNome().contains("Processador") ? "MHz" : ""));
        }
        System.out.println("🖥️  Sistema Operacional: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");

        if (this.memoriaUSB != null) {
            System.out.println("💾 Memória USB: " + memoriaUSB.getNome() + " - " + memoriaUSB.getCapacidade() + "GB");
        } else {
            System.out.println("💾 Memória USB: Nenhuma");
        }
    }


}
