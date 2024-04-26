package br.com.fiap.Aula04Exercicio.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ja_tag")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue
    @Column(name = "id_tag")
    private Long id;

    @Column(name = "nm_tag", length = 20, nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;

}
