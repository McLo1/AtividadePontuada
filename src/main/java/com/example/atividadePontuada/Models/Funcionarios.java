package com.example.atividadePontuada.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
public class Funcionarios {

    //Classe Usuario

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Insira o nome do Funcionario") //Validações com NotBlank para que o usuario não deixe as informações em branco
    private String nome;
    @NotBlank(message = "Insira o CPF do Funcionario")
    private String cpf;
    @NotBlank(message = "Insira a data de nascimento do funcionario")
    private String dataNascimento;

    @Enumerated(value = EnumType.STRING)
    private Sexo sexo;

    @Enumerated(value = EnumType.STRING)
    private Setor setor;

    @Enumerated(value = EnumType.STRING)
    private EstadoCivil estadoCivil;

    private double salario;
    @NotBlank(message = "Insira o e-mail do Funcionario")
    @Email(message = "Insira um e-mail valido!") //Validação para que não seja registrado um E-mail Invalido
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    //Construtores, Getters e Setters

    public Funcionarios() {
    }

    public Funcionarios(long id, String nome, String cpf, String dataNascimento, Sexo sexo, Setor setor, EstadoCivil estadoCivil, double salario, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.setor = setor;
        this.estadoCivil = estadoCivil;
        this.salario = salario;
        this.email = email;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
