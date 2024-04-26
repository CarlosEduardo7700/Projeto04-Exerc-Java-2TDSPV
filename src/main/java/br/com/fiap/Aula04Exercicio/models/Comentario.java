package br.com.fiap.Aula04Exercicio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "ja_comentario")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue
    @Column(name = "id_comentario")
    private Long id;

    @Column(name = "ds_conteudo", length = 100, nullable = false)
    private String conteudo;

    @Column(name = "dt_criacao", nullable = false)
    private LocalDate dataDeCriacao;

    @Column(name = "nm_autor", length = 50)
    private String nomeDoAutor;

    @ManyToOne
    @JoinColumn(name = "id_post", nullable = false)
    private Post post;
}
