package br.com.etechoracio.ingressos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name = "TBL_SESSAO")
@Getter
@Setter
public class Sessao {
    @Id
    @Column(name = "ID_SESSAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DT_DATA")
    private LocalDateTime data;

    @Column(name = "NR_PRECO")
    private double preco;

    @Column(name = "DT_EXCLUSAO")
    private LocalDateTime dataExclusao;

    @ManyToOne
    @JoinColumn(name = "ID_SALA")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "ID_FILME")
    private Filme filme;

}
