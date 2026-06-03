package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @GetMapping("/boasvindas")
    @Operation(summary = "mensagem de boas vindas", description = "uma mensagme de boas vindas para melhor recepcionar usuarios do sistema")
    public String mensagemDeBoasVindas(){
        return "olá seja bem vindo ao sistema de cadastro de ninjas";
    }
    @Operation(summary = "listar cadastros", description = "listar todos ninjas cadastrados no banco")
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listar() {

        List<NinjaDTO> ninjas = ninjaService.listarDTO();
        return ResponseEntity.ok(ninjas);
    }
    @Operation(summary = "pesquisa cadastro no banco", description = "procura e devolve um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ninja listado pelo id em seu cadastro"),
            @ApiResponse(responseCode = "404", description = "id não encontrado no banco de dados")
    })
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
    @Operation(summary = "cria novo ninja", description = "rota cria novo ninja no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ninja cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro ao cadastrar ninja")
    })
    public ResponseEntity<String> cadastraNinjaResponse(@RequestBody NinjaDTO ninjaDTO){
         ninjaService.cadastroDTO(ninjaDTO);

         return ResponseEntity.status(HttpStatus.CREATED)
                 .body("ninja: " + ninjaDTO.getNome() + " cadastrado com sucesso");
    }

    @DeleteMapping("/deleta/{id}")
    @Operation(summary = "deleta ninja do banco", description = "deleta ninja cadastrado no banco de dados usando seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ninja deletado com sucesso do banco"),
            @ApiResponse(responseCode = "404", description = "ninja não encontrado")
    })
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
    @Operation(summary = "atualiza ninjas", description = "rota atualiza um ninja já cadastrodo no banco de dados usando seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ninja atualizado com sucesso no banco"),
            @ApiResponse(responseCode = "404", description = "ninja não encontrado")
    })
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
