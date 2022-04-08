package modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "persona", schema = "ejer2")
public class PersonaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dni")
    private String dni;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "apellido")
    private String apellido;
    @ManyToOne
    @JoinColumn(name = "nombreEmpresa", referencedColumnName = "nombre", nullable = false)
    private EmpresaEntity empresaByNombreEmpresa;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaEntity that = (PersonaEntity) o;
        return Objects.equals(dni, that.dni) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, apellido);
    }

    public EmpresaEntity getEmpresaByNombreEmpresa() {
        return empresaByNombreEmpresa;
    }

    public void setEmpresaByNombreEmpresa(EmpresaEntity empresaByNombreEmpresa) {
        this.empresaByNombreEmpresa = empresaByNombreEmpresa;
    }
}
