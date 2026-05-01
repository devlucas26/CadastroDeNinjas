package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/listar")
    public String listarTodos(){
        return "listar todos os ninjas";
    }
    @PostMapping("/criar")
    public String cadastrarNinja(){
        return "cadastro realizado com sucesso";
    }
    @PutMapping("/atualizar/id")
    public String atualizarNinja(){
        return "atualização realizado com sucesso";
    }
    @GetMapping("/listar/id")
    public String procuraPorId(){
        return "procura ninja por id";
    }
    @DeleteMapping("/deletar/id")
    public String deletar(){
        return "deleção com sucesso";
    }
}
