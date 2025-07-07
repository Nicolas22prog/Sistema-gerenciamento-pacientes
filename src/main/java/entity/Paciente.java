package entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "paciente")
public class Paciente {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long cpf;
    private String endereco;
    private String email;
    private OffsetDateTime dataNasc;
    private OffsetDateTime dataInicio;

    public Paciente(Long id, String nome, Long cpf, String endereco, String email, OffsetDateTime dataNasc, OffsetDateTime dataInicio) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        this.dataInicio = dataInicio;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public OffsetDateTime getDataNasc() {
        return dataNasc;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNasc(OffsetDateTime dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
    
     
}
