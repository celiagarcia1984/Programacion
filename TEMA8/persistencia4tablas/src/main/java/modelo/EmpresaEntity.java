package modelo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "empresa", schema = "ejer2")
public class EmpresaEntity {
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "empresaByNombreEmpresa")
    private Collection<PersonaEntity> personasByNombre;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaEntity that = (EmpresaEntity) o;
        return Objects.equals(direccion, that.direccion) && Objects.equals(telefono, that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion, telefono);
    }

    public Collection<PersonaEntity> getPersonasByNombre() {
        return personasByNombre;
    }

    public void setPersonasByNombre(Collection<PersonaEntity> personasByNombre) {
        this.personasByNombre = personasByNombre;
    }
}
