package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public List<NinjaDTO> listar() {
        return ninjaService.listarDTO();
    }

    @GetMapping("/listar/{id}")
    public NinjaDTO procuraPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }

    @PostMapping("/criar")
    public NinjaDTO cadastraNinja(@RequestBody NinjaDTO ninjaDTO){
        return ninjaService.cadastroDTO(ninjaDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        ninjaService.deleta(id);
    }

    @PutMapping("/atualiza/{id}")
    public NinjaDTO atualizar(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualiza(id, ninjaAtualizado);
        //ninjaService.atualiza(id, ninjaModelAtualizado);
    }
}
