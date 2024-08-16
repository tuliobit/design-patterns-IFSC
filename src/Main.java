import quarto.Quarto;
import quarto.QuartoBuilder;
import quarto.QuartoDisponivel;
import quarto.QuartoManutencao;

public class Main {
    public static void main(String[] args) {
        try {
            // GetInstance do singleton GerenciadorDeReserva
            GerenciadorDeReservaSingleton gerenciador = GerenciadorDeReservaSingleton.getInstance();

            // Criação de quartos-exemplo com builders
            Quarto quarto1 = new QuartoBuilder()
                    .setNumeroQuarto(101)
                    .setMaximoHospedes(2)
                    .setTemVistaMar(true)
                    .setTemSacada(false)
                    .setEstado(new QuartoDisponivel())
                    .build();

            Quarto quarto2 = new QuartoBuilder()
                    .setNumeroQuarto(102)
                    .setMaximoHospedes(3)
                    .setTemVistaMar(false)
                    .setTemSacada(true)
                    .setEstado(new QuartoManutencao())
                    .build();

            Quarto quarto3 = new QuartoBuilder()
                    .setNumeroQuarto(103)
                    .setMaximoHospedes(1)
                    .setTemVistaMar(false)
                    .setTemSacada(false)
                    .setEstado(new QuartoDisponivel())
                    .build();

            Quarto quarto4 = new QuartoBuilder()
                    .setNumeroQuarto(104)
                    .setMaximoHospedes(4)
                    .setTemVistaMar(true)
                    .setTemSacada(true)
                    .setEstado(new QuartoManutencao())
                    .build();

            gerenciador.adicionarQuarto(quarto1);
            gerenciador.adicionarQuarto(quarto2);
            gerenciador.adicionarQuarto(quarto3);
            gerenciador.adicionarQuarto(quarto4);

            // Criação da fachada para facilitar as operações de reserva
            ReservaFacade reservaFacade = new ReservaFacade();

            // Verificar a disponibilidade dos quartos via Facade
            System.out.println("Quarto 101 disponível? " + reservaFacade.verificarDisponibilidade(101));
            System.out.println("Quarto 102 disponível? " + reservaFacade.verificarDisponibilidade(102));
            System.out.println("Quarto 103 disponível? " + reservaFacade.verificarDisponibilidade(103));
            System.out.println("Quarto 104 disponível? " + reservaFacade.verificarDisponibilidade(104));
            System.out.println();

            // Tentar reservar o quarto 102 (que está em manutenção)
            Endereco endereco1 = new Endereco();
            endereco1.setLogradouro("Rua Exemplo");
            endereco1.setNumero("123");
            endereco1.setBairro("Bairro Exemplo");
            endereco1.setCidade("Cidade Exemplo");
            endereco1.setEstado("Estado Exemplo");
            endereco1.setCep("12345-678");
            endereco1.setComplemento("Apto 101");

            System.out.println("Tenta criar reserva para quarto 102, que estava indisponível:");
            boolean reservaFeita = reservaFacade.criarReserva("João da Silva", "123.456.789-00", "joao@example.com", "123456789", endereco1, 102);
            System.out.println("Reserva para quarto 102 feita? " + reservaFeita);
            System.out.println();

            // Reservar o quarto 103
            Endereco endereco2 = new Endereco();
            endereco2.setLogradouro("Rua Nova");
            endereco2.setNumero("456");
            endereco2.setBairro("Bairro Novo");
            endereco2.setCidade("Cidade Nova");
            endereco2.setEstado("Estado Novo");
            endereco2.setCep("87654-321");
            endereco2.setComplemento("Casa");

            System.out.println("Tenta criar reserva para quarto 103, que estava disponível:");
            reservaFeita = reservaFacade.criarReserva("Maria da Silva", "987.654.321-00", "maria@example.com", "987654321", endereco2, 103);
            System.out.println("Reserva para quarto 103 feita? " + reservaFeita);
            System.out.println("Verifica state do quarto 103 após reserva:");
            System.out.println("Quarto 103 disponível? " + reservaFacade.verificarDisponibilidade(103));
            System.out.println();

            // Altera state do quarto 103 para disponivel e consulta pela Facade
            quarto3.liberar();
            System.out.println("Quarto 103 disponível? " + reservaFacade.verificarDisponibilidade(103));
            System.out.println();

            System.out.println("Tenta reservar o quarto 104 (que está em manutenção)");
            boolean reservaQuarto4 = reservaFacade.criarReserva("Carlos dos Santos", "111.222.333-44", "carlos@example.com", "998877665", endereco2, 104);
            System.out.println("Reserva para quarto 104 feita? " + reservaQuarto4);

        } catch (Exception e) {
            System.err.println("Erro ao construir o quarto: " + e.getMessage());
        }
    }
}
