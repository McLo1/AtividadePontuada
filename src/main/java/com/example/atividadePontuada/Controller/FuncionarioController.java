package com.example.atividadePontuada.Controller;

import com.example.atividadePontuada.Models.Funcionarios;
import com.example.atividadePontuada.Service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    public FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionarios> listarTodos(){
        return funcionarioService.listarTodos();
    }


    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionarios funcionarios){
        funcionarioService.salvar(funcionarios);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensagem " + funcionarios.getNome(), " Criado com sucesso " + "HTTP: " +HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Funcionarios funcionarios){
        funcionarioService.atualizar(funcionarios);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("Mensagem"  , "Atualizado com sucesso " + "HTTP: "+ HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@Valid @PathVariable long id){
        funcionarioService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("Mensagem"  , "Funcionario Excluido com sucesso " + "HTTP: " + HttpStatus.OK));
    }
}
