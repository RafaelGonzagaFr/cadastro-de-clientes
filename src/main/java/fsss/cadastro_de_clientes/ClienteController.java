package fsss.cadastro_de_clientes;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity getAllClientes() {
        var clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity registrarCliente(@RequestBody ClienteDTO data){
        Cliente novoCliente = new Cliente(data);
        clienteRepository.save(novoCliente);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateCliente(@RequestBody ClienteDTO data) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(data.id());
        if(optionalCliente.isPresent()){
            Cliente cliente = optionalCliente.get();
            cliente.setNome(data.nome());
            cliente.setEmail(data.email());
            cliente.setTelefone(data.email());
            cliente.setCidade(data.cidade());
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCliente(@PathVariable String id){
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            clienteRepository.delete(cliente);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
