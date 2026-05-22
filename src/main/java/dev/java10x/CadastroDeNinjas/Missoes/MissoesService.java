package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    // LISTA TODOS DOS DADOS
    public List<MissoesDTO> listarDTO(){

        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .toList();
    }

    // LISTAR POR ID
    public MissoesDTO listarPorIdDTO(Long id){

        return missoesRepository.findById(id)
                .map(missoesMapper::map)
                .orElse(null);
    }

    // permanece da mesma forma, não há necessidade de alterar o DELETE
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }
    // CADASTRO
    public MissoesDTO cadastra(MissoesDTO missoesDTO){

        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }
    // FALTANDO O ATUALIZAR, QUE SEMPRE É O MAIS CHATO
    public MissoesDTO atualizaDTO(Long id, MissoesDTO missoesDTO){

        if (missoesRepository.existsById(id)){
            missoesDTO.setId(id);
            MissoesModel missoesModel = missoesMapper.map(missoesDTO);
            missoesModel = missoesRepository.save(missoesModel);

            return missoesMapper.map(missoesModel);
        }
        return null;
    }
}
