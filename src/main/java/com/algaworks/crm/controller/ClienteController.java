package com.algaworks.crm.controller;

import com.algaworks.crm.exceptions.ClienteNaoEncontradoException;
import com.algaworks.crm.model.Cliente;
import com.algaworks.crm.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Estamos informando que essa é uma classe que vai receber requisições devolver respostas
@RequestMapping("/clientes") //Mapeando requisições através do endpoint clientes
public class ClienteController {

    @Autowired// Vai injetar uma instância de ClienteRepository em tempo de execução
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }
    @GetMapping("/{id}")
    public Cliente buscarporID(@PathVariable (name = "id") Long id) throws ClienteNaoEncontradoException {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(!cliente.isPresent()){
            throw new ClienteNaoEncontradoException();
        }
        return cliente.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody Cliente cliente){ //o corpo da requisição vai convertido para o Objeto do tipo Cliente
        return clienteRepository.save(cliente); // Retorna o cliente salvo
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaCliente(@PathVariable (name = "id") Long id) throws ClienteNaoEncontradoException { //o corpo da requisição vai convertido para o Objeto do tipo Cliente
            Cliente cliente = buscarporID(id);
            clienteRepository.deleteById(id); // Retorna o cliente salvo

    }


}
