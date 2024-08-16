package quarto;

public interface EstadoQuarto {
    boolean isDisponivel();
    void reservar(Quarto quarto);
    void liberar(Quarto quarto);
    void ocupar(Quarto quarto);
    void colocarEmManutencao(Quarto quarto);
}
