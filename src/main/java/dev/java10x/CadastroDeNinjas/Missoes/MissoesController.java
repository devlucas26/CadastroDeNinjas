package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/missoes")
@RestController
public class MissoesController {

    @GetMapping("/listar")
    public String listarTodos() {
        return "listar todos os dados";
    }
    @PostMapping("/criar")
    public String cadastrar(){
        return "cadastro realizado com sucesso";
    }
    @PutMapping("/atualizar/id")
    public String atualizar(){
        return "atualização realizada com sucesso";
    }
    @DeleteMapping("/deletar/id")
    public String deletar(){
        return "deletado com sucesso";
    }
    @GetMapping("/listar/id")
    public String listarId(){
        return "procura missoes por id";
    }
}
