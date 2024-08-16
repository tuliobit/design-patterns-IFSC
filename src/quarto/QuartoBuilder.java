package quarto;

public class QuartoBuilder {
    private Integer numeroQuarto;
    private Integer maximoHospedes;
    private Boolean temVistaMar;
    private Boolean temSacada;
    private EstadoQuarto estado;

    public QuartoBuilder setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
        return this;
    }

    public QuartoBuilder setMaximoHospedes(Integer maximoHospedes) {
        this.maximoHospedes = maximoHospedes;
        return this;
    }

    public QuartoBuilder setTemVistaMar(Boolean temVistaMar) {
        this.temVistaMar = temVistaMar;
        return this;
    }

    public QuartoBuilder setTemSacada(Boolean temSacada) {
        this.temSacada = temSacada;
        return this;
    }

    public QuartoBuilder setEstado(EstadoQuarto estado) {
        this.estado = estado;
        return this;
    }

    public Quarto build() throws Exception{
        if (this.estado == null) {
            this.estado = new QuartoDisponivel();
        }
        if(this.numeroQuarto == null || this.maximoHospedes == null) {
            throw new Exception("Obrigatório número do quarto e limite de hospedes");
        }
        return new Quarto(numeroQuarto, maximoHospedes, temVistaMar, temSacada, estado);
    }
}

