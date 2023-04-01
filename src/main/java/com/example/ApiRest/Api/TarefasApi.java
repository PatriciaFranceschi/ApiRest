package com.example.ApiRest.Api;

import com.example.ApiRest.Facade.TarefasFacade;
import com.example.ApiRest.TarefasDTO.TarefaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasApi {

    @Autowired
    private TarefasFacade tarefasFacade;

    @PostMapping
    @ResponseBody
    public TarefaDTO criar(@RequestBody  TarefaDTO tarefaDTO){
        return tarefasFacade.criar(tarefaDTO);
    }
    @PutMapping("/{tarefaId}")
    @ResponseBody
    public  TarefaDTO atualizar(@PathVariable("tarefaId") Long tarefaId,
                                TarefaDTO tarefaDTO) {
        return tarefasFacade.atualizar(tarefaDTO, tarefaId);
    }
    @GetMapping
    @ResponseBody
    public List<TarefaDTO> getAll(){
        return tarefasFacade.getAll(); 
    }
}
