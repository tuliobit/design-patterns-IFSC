package quarto;

public class QuartoDisponivel implements EstadoQuarto {
    @Override
    public boolean isDisponivel() {
        return true;
    }

    @Override
    public void reservar(Quarto quarto) {
        quarto.setEstado(new QuartoReservado());
        System.out.println("O quarto " + quarto.getNumeroQuarto() + " foi reservado.");
    }

    @Override
    public void liberar(Quarto quarto) {
        System.out.println("O quarto " + quarto.getNumeroQuarto() + " já está disponível.");
    }

    @Override
    public void ocupar(Quarto quarto) {
        quarto.setEstado(new QuartoOcupado());
        System.out.println("O quarto " + quarto.getNumeroQuarto() + " agora está ocupado.");
    }

    @Override
    public void colocarEmManutencao(Quarto quarto) {
        quarto.setEstado(new QuartoManutencao());
        System.out.println("O quarto " + quarto.getNumeroQuarto() + " foi colocado em manutenção.");
    }
}
