package br.com.fiap.Aula04Exercicio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ja_post")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "id_post")
    private Long id;

    @Column(name = "ds_titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name = "ds_conteudo", length = 500, nullable = false)
    private String conteudo;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DetalhesDoPost detalhesDoPost;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comentario> comentarios = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "JA_TAG_POST",
            joinColumns = @JoinColumn(name = "id_post"),
            inverseJoinColumns = @JoinColumn(name = "id_tag"))
    private List<Tag> tags;

    public void addComentario(Comentario comentario) {
        comentario.setPost(this);
        comentarios.add(comentario);
    }
}
