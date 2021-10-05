package com.algaworks.crm.model;

import lombok.Data;

import javax.persistence.*;

@Data // Gera os getters, setters, hashCode e Equals
@Entity//uma entidade é mapeada para uma tabela no banco de dados
public class Cliente {
    @Id // propriedade que identifica nossa entidade, nossa chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //coluna id

    @Column(nullable = false) //O campo não pode deixar de ser prenchido
    private String nome; //coluna nome
}
