package com.example.atividadePontuada.Service;

import com.example.atividadePontuada.Models.Funcionarios;
import com.example.atividadePontuada.Repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionarios> listarTodos(){
        return funcionarioRepository.findAll();
    } //Logica para Listar os Usuarios Salvos

    public Funcionarios salvar(@Valid Funcionarios funcionarios){
        if (funcionarioRepository.findByEmail(funcionarios.getEmail()).isPresent()){ //validação com E-mail, não é possivel cadastrar um Usuario com o mesmo E-mail já utilizado
            throw new RuntimeException("Um usuario Já possui Esse e-mail");  //Logica para Cadastrar Novos Usuarios
        }
        return funcionarioRepository.save(funcionarios);
    }

    public Funcionarios atualizar(@Valid Funcionarios funcionarios){
        Funcionarios funcionarioAtualizar = funcionarioRepository.findById(funcionarios.getId())
                .orElseThrow(() -> new RuntimeException("Funcionario não cadastrado"));


        funcionarioAtualizar.setNome(funcionarios.getNome());
        funcionarioAtualizar.setCpf(funcionarios.getCpf());
        funcionarioAtualizar.setDataNascimento(funcionarios.getDataNascimento());
        funcionarioAtualizar.setSexo(funcionarios.getSexo());
        funcionarioAtualizar.setSetor(funcionarios.getSetor());
        funcionarioAtualizar.setEstadoCivil(funcionarios.getEstadoCivil());
        funcionarioAtualizar.setSalario(funcionarios.getSalario());
        funcionarioAtualizar.setEmail(funcionarios.getEmail());
        funcionarioAtualizar.setEndereco(funcionarios.getEndereco());

        return funcionarioRepository.save(funcionarioAtualizar); //Logica para Atualizar um Usuario Já cadastrado
    }

    public void deletar(long id){
        Funcionarios funcionarioAtualizar = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não cadastrado"));

        funcionarioRepository.deleteById(id); //Logica para deletar um Funcionario
    }

}
