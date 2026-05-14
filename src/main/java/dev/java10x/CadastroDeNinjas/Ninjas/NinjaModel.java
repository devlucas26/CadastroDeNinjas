package dev.java10x.CadastroDeNinjas.Ninjas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro_de_ninjas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {
// faltou o modificador private nos atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    // colocar email como unico
    @Column(unique = true, name = "email")
    private String email;
    private int idade;

    @Column(name = "img_url")
    private String imgUrl;

    // não há problemas em mexer no model se está se trabalhando com DTO's
    private String ninja_rank;

    // varios ninjas podem fazer a mesma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    @JsonIgnore
    private MissoesModel missoes;
}
