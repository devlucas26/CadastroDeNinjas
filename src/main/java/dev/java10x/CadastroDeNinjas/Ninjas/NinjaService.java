package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarDTO(){

        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .toList();
    }

    public NinjaDTO listarPorId(Long id){

        return ninjaRepository.findById(id)
                .map(ninjaMapper::map)
                .orElse(null);
    }

    //TODO entender com isso funciona e replicar para as missões
    // cadastrar usando DTO
    public NinjaDTO cadastroDTO(NinjaDTO ninjaDTO){

        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    // DELETAR é o único método que não precisa de DTO, menos uma preocupação
    public void deleta(Long id){
        ninjaRepository.deleteById(id);
    }
    // UPDATE
    public NinjaDTO atualiza(Long id, NinjaDTO ninjaAtualizado){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            NinjaModel ninjaModel = ninjaMapper.map(ninjaAtualizado);
            ninjaModel = ninjaRepository.save(ninjaModel);
            return ninjaMapper.map(ninjaModel);
        }
        return null;
    }
}

