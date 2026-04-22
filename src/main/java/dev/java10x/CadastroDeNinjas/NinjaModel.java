package dev.java10x.CadastroDeNinjas;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro_de_ninjas")
public class NinjaModel {
// faltou o modificador private nos atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private int idade;

    public NinjaModel(String nome, String email, int idade){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
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
