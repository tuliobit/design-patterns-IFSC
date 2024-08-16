import quarto.Quarto;
import quarto.QuartoOcupado;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeReservaSingleton {
    private static GerenciadorDeReservaSingleton instance;

    private List<Quarto> quartos;
    private List<Hospede> hospedes;

    // Construtor privado para impedir a instânciação externa
    private GerenciadorDeReservaSingleton() {
        this.quartos = new ArrayList<>();
        this.hospedes = new ArrayList<>();
    }

    // Método público estático para retornar a instância única da classe
    public static GerenciadorDeReservaSingleton getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeReservaSingleton();
        }
        return instance;
    }

    // Método para adicionar um quarto à lista
    public void adicionarQuarto(Quarto quarto) {
        this.quartos.add(quarto);
    }

    // Método para adicionar um hóspede à lista
    public void adicionarHospede(Hospede hospede) {
        this.hospedes.add(hospede);
    }

    // Método para verificar se um quarto está disponível
    public boolean verificarDisponibilidade(int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumeroQuarto() == numeroQuarto && quarto.isDisponivel()) {
                return true;
            }
        }
        return false;
    }

    // Método para reservar um quarto para um hóspede
    public boolean reservarQuarto(int numeroQuarto, Hospede hospede) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumeroQuarto() == numeroQuarto && quarto.isDisponivel()) {
                quarto.setEstado(new QuartoOcupado());
                this.hospedes.add(hospede);
                return true;
            }
        }
        return false;
    }

}
