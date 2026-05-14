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
    public List<MissoesDTO> listarTodos() {
        return missoesService.listarDTO();
    }

    @PutMapping("/atualiza/{id}")
    public MissoesDTO atualizar(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        return missoesService.atualizaDTO(id,missoesDTO);
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarId(@PathVariable Long id){
        return missoesService.listarPorIdDTO(id);
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
