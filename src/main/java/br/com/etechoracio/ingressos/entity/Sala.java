package br.com.etechoracio.ingressos.entity;

import br.com.etechoracio.ingressos.enums.CategoriaFilmeEnum;
import br.com.etechoracio.ingressos.enums.ClassificacaoIndicativaEnum;
import br.com.etechoracio.ingressos.enums.SimNaoEnum;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="TBL_SALA")
public class Sala {
    @Id
    @Column(name = "ID_SALA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "NR_PRECO")
    private Float preco;

    @Column(name = "DT_EXCLUSAO")
    private LocalDateTime dataExclusao;

}
