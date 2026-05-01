package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String mensagem(){
        return "endpoint do NinjaController";
    }
    // exemplo: esqueleto dos endpoints

    // creat
    @PostMapping("/criar")
    public String cadastra(){
        return "ninja cadastrado";
    }
    // read - lista todos
    @GetMapping("/todos")
    public String listaTodos(){
        return "lista todos os ninjas";
    }
    // read - procura pelo id
    @GetMapping("/listaporid")
    public String listaPorId(){
        return "lista o ninja por id";
    }
    // update
    @PutMapping("/atualiza")
    public String atualizarNinja(){
        return "atualiza ninja por id";
    }
    // delete
    @DeleteMapping("/deletar")
    public String deletar(){
        return "deletar por id";
    }
}
