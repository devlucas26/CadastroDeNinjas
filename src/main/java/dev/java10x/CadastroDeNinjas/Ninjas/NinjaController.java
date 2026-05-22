package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listar() {

        List<NinjaDTO> ninjas = ninjaService.listarDTO();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> procuraPorId(@PathVariable Long id) {

        NinjaDTO ninjaDTO = ninjaService.listarPorId(id);

        if (ninjaDTO != null){
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ninja "+ id +" não encontrado");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> cadastraNinjaResponse(@RequestBody NinjaDTO ninjaDTO){
         ninjaService.cadastroDTO(ninjaDTO);

         return ResponseEntity.status(HttpStatus.CREATED)
                 .body("ninja: " + ninjaDTO.getNome() + " cadastrado com sucesso");
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<String> deletaResponse(@PathVariable Long id){
        //ninjaService.deleta(id);
        if(ninjaService.listarPorId(id) != null){
            ninjaService.deleta(id);
            return ResponseEntity.ok("ninja deletado do banco com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("id: " + id + " não encontrado");
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<Object> atualizarResponse(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninjaDTO = ninjaService.listarPorId(id);

        if (ninjaDTO != null){
            ninjaService.atualiza(id, ninjaAtualizado);
            return ResponseEntity.ok(ninjaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("id: " + id +  " não foi encontrado na base de dados");

    }
}
