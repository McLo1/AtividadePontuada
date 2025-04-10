package com.example.atividadePontuada.Repository;

import com.example.atividadePontuada.Models.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long> {
    Optional<Funcionarios> findByEmail(String email);

}
