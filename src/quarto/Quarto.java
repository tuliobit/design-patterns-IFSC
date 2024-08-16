package quarto;

public class Quarto {
    private Integer numeroQuarto;
    private Integer maximoHospedes;
    private Boolean temVistaMar;
    private Boolean temSacada;
    private EstadoQuarto estado;

    public Quarto(Integer numeroQuarto, Integer maximoHospedes, Boolean temVistaMar, Boolean temSacada, EstadoQuarto estado) {
        this.numeroQuarto = numeroQuarto;
        this.maximoHospedes = maximoHospedes;
        this.temVistaMar = temVistaMar;
        this.temSacada = temSacada;
        this.estado = estado;
    }

    public void reservar() {
        estado.reservar(this);
    }

    public void liberar() {
        estado.liberar(this);
    }

    public void ocupar() {
        estado.ocupar(this);
    }

    public void colocarEmManutencao() {
        estado.colocarEmManutencao(this);
    }

    public void setEstado(EstadoQuarto estado) {
        this.estado = estado;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Integer getMaximoHospedes() {
        return maximoHospedes;
    }

    public void setMaximoHospedes(Integer maximoHospedes) {
        this.maximoHospedes = maximoHospedes;
    }

    public boolean temVistaMar() {
        return temVistaMar;
    }

    public void setTemVistaMar(Boolean temVistaMar) {
        this.temVistaMar = temVistaMar;
    }

    public boolean temSacada() {
        return temSacada;
    }

    public void setTemSacada(Boolean temSacada) {
        this.temSacada = temSacada;
    }

    public boolean isDisponivel() {
        return estado.isDisponivel();
    }
}
