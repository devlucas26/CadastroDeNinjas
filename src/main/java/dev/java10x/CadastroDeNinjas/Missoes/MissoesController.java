package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/missoes")
@RestController
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }
    @GetMapping("/listar")
    public List<MissoesModel> listarTodos() {
        return missoesService.listar();
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
    @GetMapping("/listar/{id}")
    public MissoesModel listarId(@PathVariable Long id){
        return missoesService.listarPorId(id);
    }
    @PostMapping("/cadastrar")
    public MissoesModel cadastarMissao(@RequestBody MissoesModel missoesModel){
        return missoesService.cadastraMissao(missoesModel);
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }
}
