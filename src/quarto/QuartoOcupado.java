package quarto;

public class QuartoOcupado implements EstadoQuarto {
    @Override
    public boolean isDisponivel() {
        return false;
    }

    @Override
    public void reservar(Quarto quarto) {
        System.out.println("O quarto " + quarto.getNumeroQuarto() + " está ocupado e não pode ser reservado.");
    }

    @Override
    public void liberar(Quarto quarto) {
        quarto.setEstado(new QuartoDisponivel());
        System.out.println("O quarto " + quarto.getNumeroQuarto() + " foi liberado e agora está disponível.");
    }

    @Override
    public void ocupar(Quarto quarto) {
        System.out.println("O quarto " + quarto.getNumeroQuarto() + " já está ocupado.");
    }

    @Override
    public void colocarEmManutencao(Quarto quarto) {
        System.out.println("O quarto " + quarto.getNumeroQuarto() + " está ocupado e não pode ser colocado em manutenção.");
    }
}