package com.algaworks.crm.repository;

import com.algaworks.crm.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Responsavel por interagir com o banco de dados
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
}
