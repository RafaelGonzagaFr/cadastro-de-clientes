package fsss.cadastro_de_clientes;

import jakarta.persistence.*;
import lombok.*;

@Table (name = "cliente")
@Entity (name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String cidade;

    public Cliente(ClienteDTO data){
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.cidade = data.cidade();
    }
}
