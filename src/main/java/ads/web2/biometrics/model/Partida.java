package ads.web2.biometrics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.Duration;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String local_partida;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime inicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fim;

    public Partida() {
    }

    public Partida(String local_partida, LocalDateTime inicio, LocalDateTime fim) {
        this.local_partida = local_partida;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Integer duracao(LocalDateTime inicio, LocalDateTime fim) {
        this.inicio = inicio;
        this.fim = fim;

        Duration duracao = Duration.between(inicio, fim);

        long horas = duracao.toHours();
        long minutos = duracao.toMinutesPart();

        return fim.getHour() - inicio.getHour();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalPartida() {
        return local_partida;
    }

    public void setLocal(String local_partida) {
        this.local_partida = local_partida;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
}
