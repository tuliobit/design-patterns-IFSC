package quarto;

public class QuartoReservado implements EstadoQuarto {
    @Override
    public boolean isDisponivel() {
        return false;
    }

    @Override
    public void reservar(Quarto quarto) {
        System.out.println("O quarto já está reservado.");
    }

    @Override
    public void liberar(Quarto quarto) {
        quarto.setEstado(new QuartoDisponivel());
        System.out.println("O quarto foi liberado e agora está disponível.");
    }

    @Override
    public void ocupar(Quarto quarto) {
        quarto.setEstado(new QuartoOcupado());
        System.out.println("O quarto agora está ocupado.");
    }

    @Override
    public void colocarEmManutencao(Quarto quarto) {
        quarto.setEstado(new QuartoManutencao());
        System.out.println("O quarto foi colocado em manutenção.");
    }
}
