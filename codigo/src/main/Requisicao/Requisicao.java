package main.Requisicao;

import java.time.LocalDateTime;
import java.util.ArrayList;

import main.Clientes.Cliente;
import main.Mesa.Mesa;

public class Requisicao {
    private ArrayList<Mesa> mesas;

    public void alocarCliente(String nomeCliente, int qtdClientes) {
        Mesa mesa = verificacaoMesa(qtdClientes);
        LocalDateTime entrada = LocalDateTime.now();
        if (mesa != null) {
            Cliente cliente = new Cliente(nomeCliente, qtdClientes);
            mesa.alocarCliente(cliente);
            System.out.println("Alocando mesa para " + qtdClientes + " clientes, entrada: " + entrada);
        } else {
            // Cliente cliente = new Cliente(qtdClientes);
            // ClienteEspera(cliente);
            System.out.println("Não exitem mesas disponiveis no momento para essa quantidade de pessoas!");
        }

    }

    private Mesa verificacaoMesa(int qtdClientes) {
        for (Mesa mesa : mesas) {
            if (mesa.diponibilidade() && mesa.getCapacidade() >= qtdClientes) {
                System.out.println("Mesa Disponivel " + mesa);
                return mesa;
            }
        }
        return null;
    }

    /*
     * private void ClienteEspera(Cliente cliente) {
     * listaEspera.add(cliente);
     * System.out.println("Cliente alocado para a espera!");
     * }
     * 
     * public void removerCliente() {
     * for (Mesa mesa : mesas) {
     * if (!mesa.cliente.isEmpty()) {
     * Cliente cliente = mesa.cliente.get(0);
     * mesa.removerMesa(cliente);
     * System.out.println("Cliente removido da mesa.");
     * if (!listaEspera.isEmpty()) {
     * Cliente proximoCliente = listaEspera.poll();
     * if (mesa.getCapacidade() >= proximoCliente.getCliente()) {
     * mesa.alocarCliente(proximoCliente);
     * System.out.println("Próximo cliente da lista de espera alocado na mesa.");
     * } else {
     * listaEspera.add(proximoCliente);
     * System.out.
     * println("Não há mesas disponíveis para o próximo cliente da lista de espera."
     * );
     * }
     * }
     * return;
     * }
     * }
     * System.out.println("Não há clientes para remover das mesas.");
     * }
     */
}
