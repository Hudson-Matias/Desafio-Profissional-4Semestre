package br.edu.unicesumar.desafioProfissional.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "medico")
@Document(collection = "medico")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medico implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "crm", length = 6)
    private Integer crm;

    private String nome;

    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return crm == medico.crm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(crm);
    }
}
