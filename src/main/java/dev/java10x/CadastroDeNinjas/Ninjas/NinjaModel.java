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
    private long id;
    private String nome;
    private String email;
    private int idade;

    // varios ninjas podem fazer a mesma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

    public NinjaModel(String nome, String email, int idade){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }
    public NinjaModel(String nome, String email, int idade, MissoesModel missoes) {
        this(nome,email,idade);
        this.missoes = missoes;
    }
    public NinjaModel(){

    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String Email){
        this.email = email;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public int getIdade(){
        return idade;
    }
}
