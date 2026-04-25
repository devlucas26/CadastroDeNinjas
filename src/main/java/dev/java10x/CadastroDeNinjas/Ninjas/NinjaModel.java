package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private long id;

    @Column(name = "nome")
    private String nome;

    // colocar email como unico
    @Column(unique = true, name = "email")
    private String email;
    private int idade;

    @Column(name = "img_url")
    private String imgUrl;

    // varios ninjas podem fazer a mesma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

}
