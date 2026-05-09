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
    public List<NinjaModel> listar() {
        return ninjaService.listar();
    }
    @GetMapping("/listar/{id}")
    public NinjaModel procuraPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }
    @PostMapping("/criar")
    public NinjaModel cadastraNinja(@RequestBody NinjaModel ninjaModel){
        return ninjaService.cadastra(ninjaModel);
    }
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        ninjaService.deleta(id);
    }
    @PutMapping("/atualiza/{id}")
    public NinjaModel atualizar(@PathVariable Long id, @RequestBody NinjaModel ninjaModelAtualizado){
        return ninjaService.atualiza(id, ninjaModelAtualizado);
        //ninjaService.atualiza(id, ninjaModelAtualizado);
    }
}
