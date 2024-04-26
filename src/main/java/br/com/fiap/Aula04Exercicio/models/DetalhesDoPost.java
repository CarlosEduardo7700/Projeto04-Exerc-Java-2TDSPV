package br.com.fiap.Aula04Exercicio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "ja_detalhes_post")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class DetalhesDoPost {

    @Id
    @GeneratedValue
    @Column(name = "id_detalhes_post")
    private Long id;

    @Column(name = "nm_autor", length = 50)
    private String nomeDoAutor;

    @Column(name = "dt_criacao", nullable = false)
    private LocalDate dataDeCriacao;

    @Column(name = "dt_publicacao", nullable = false)
    private LocalDate dataDePublicacao;

    @OneToOne
    @JoinColumn(name = "id_post", nullable = false)
    private Post post;

}
