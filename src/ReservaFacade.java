public class ReservaFacade {
    private GerenciadorDeReservaSingleton gerenciador;

    public ReservaFacade() {
        this.gerenciador = GerenciadorDeReservaSingleton.getInstance();
    }

    // Método para criar uma reserva de um novo hospede
    public boolean criarReserva(String nomeHospede, String cpf, String email, String telefone, Endereco endereco, int numeroQuarto) {
        Hospede hospede = new Hospede();
        hospede.setNomeCompleto(nomeHospede);
        hospede.setCpf(cpf);
        hospede.setEmail(email);
        hospede.setTelefone(telefone);
        hospede.setEndereco(endereco);

        gerenciador.adicionarHospede(hospede);

        return gerenciador.reservarQuarto(numeroQuarto, hospede);
    }

    public boolean verificarDisponibilidade(int numeroQuarto) {
        return gerenciador.verificarDisponibilidade(numeroQuarto);
    }
}
