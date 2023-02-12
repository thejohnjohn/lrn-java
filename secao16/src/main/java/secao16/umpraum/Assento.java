package secao16.umpraum;

import javax.persistence.*;

@Entity
@Table(name="assentos")
public class Assento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToOne(mappedBy = "assento")
    private Cliente cliente;

    public Assento (String nome) {
        this.nome = nome;
    }
}
