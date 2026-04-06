import Eletronico.Computador;
import Eletronico.HardwareBasico;
import Eletronico.MemoriaUSB;
import Eletronico.SistemaOperacional;
import Util.ProcessarPedido;

import java.util.Scanner;

import static Util.ProcessarPedido.processando;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Beto", "13571121651");
        MemoriaUSB[] memorias = new MemoriaUSB[3];
        float precoTotal;
        int verificaMemoria;
        int opcao = 0;
        int compraPc = 0;
        Scanner sc = new Scanner(System.in);
        Computador[] computador = new Computador[3];

        computador[0] = new Computador("Apple");
        computador[1] = new Computador("Samsung");
        computador[2] = new Computador("Dell");

        memorias[0] = new MemoriaUSB("Pen-drive",16);
        memorias[1] = new MemoriaUSB("Pen-drive",32);
        memorias[2] = new MemoriaUSB("HD Externo",1000);

        // Cabeçalho do Sistema
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║           🖥️  PCMANIA 2.0           ║");
        System.out.println("║        Sistema de Vendas de PC       ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();

        System.out.println("👤 DADOS DO CLIENTE:");
        System.out.println("   CPF: " + cliente.getCpf());
        System.out.println("   Nome: " + cliente.getNome());
        System.out.println("════════════════════════════════════════");

        do {
            System.out.println("\n📋 MENU PRINCIPAL:");
            System.out.println("   1 - 🛒 Comprar Computadores");
            System.out.println("   2 - 📊 Mostrar Configurações");
            System.out.println("   0 - 🚪 Sair");
            System.out.print("   Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n🛒 SEÇÃO DE COMPRAS");
                    System.out.println("════════════════════════════════════════");
                    System.out.println("📦 PROMOÇÕES DISPONÍVEIS:");
                    System.out.println();

                    // Apresentação das promoções com formatação melhor
                    for(int i = 0; i < computador.length; i++) {
                        System.out.println("╔══════════════════════════════════════╗");
                        System.out.println("║           PROMOÇÃO " + (i+1) + "                  ║");
                        System.out.println("╚══════════════════════════════════════╝");
                        computador[i].mostraConfigsPC();
                        System.out.println();
                    }

                    System.out.print("🔢 Digite o número da promoção desejada (1-3): ");
                    compraPc = sc.nextInt();

                    if(compraPc < 1 || compraPc > 3) {
                        System.out.println("❌ Opção inválida! Tente novamente.");
                        break;
                    }

                    // Criar o computador baseado na escolha
                    Computador pcEscolhido = null;
                    switch (compraPc) {
                        case 1:
                            pcEscolhido = new Computador("Apple");
                            break;
                        case 2:
                            pcEscolhido = new Computador("Samsung");
                            break;
                        case 3:
                            pcEscolhido = new Computador("Dell");
                            break;
                    }

                    cliente.getComputadores()[cliente.getContagemPcs()] = pcEscolhido;

                    // Opção de memória USB
                    System.out.println("\n💾 MEMÓRIA USB DISPONÍVEL:");
                    System.out.println("   " + memorias[compraPc-1].getNome() + " - " + memorias[compraPc-1].getCapacidade() + "GB");
                    System.out.print("   Deseja adicionar esta memória? (1-Sim / 0-Não): ");
                    verificaMemoria = sc.nextInt();

                    if(verificaMemoria == 1){
                        cliente.getComputadores()[cliente.getContagemPcs()].addMemoriaUsb(memorias[compraPc-1]);
                        System.out.println("✅ Memória USB adicionada com sucesso!");
                    } else {
                        System.out.println("ℹ️  Memória USB não foi adicionada.");
                    }

                    cliente.setContagemPcs(cliente.getContagemPcs() + 1);
                    System.out.println("✅ Computador adicionado ao carrinho!");
                    break;

                case 2:
                    System.out.println("\n📊 CONFIGURAÇÕES DOS COMPUTADORES COMPRADOS");
                    System.out.println("═══════════════════════════════════════════════");

                    if(cliente.getContagemPcs() == 0) {
                        System.out.println("ℹ️  Nenhum computador comprado ainda.");
                    } else {
                        for(int i = 0; i < cliente.getContagemPcs(); i++){
                            System.out.println("╔══════════════════════════════════════╗");
                            System.out.println("║         COMPUTADOR " + (i+1) + "                 ║");
                            System.out.println("╚══════════════════════════════════════╝");
                            cliente.getComputadores()[i].mostraConfigsPC();
                            System.out.println();
                        }
                        cliente.calculaTotalCompra();
                    }
                    break;

                case 0:
                    if(cliente.getContagemPcs() < 2){
                        System.out.println("❌ Você deve comprar no mínimo dois computadores para finalizar!");
                        opcao = -1; // Continua no loop
                        break;
                    } else {
                        System.out.println("\n✅ Pedido finalizado com sucesso!");
                        System.out.println("📦 Total de computadores: " + cliente.getContagemPcs());
                        break;
                    }

                default:
                    System.out.println("❌ Opção inválida! Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);

        System.out.println("\n🚀 Processando pedido...");
        processando(cliente.getComputadores());
    }


}