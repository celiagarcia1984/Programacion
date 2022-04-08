package modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "asistentes", schema = "ejer2", catalog = "")
@IdClass(AsistentesEntityPK.class)
public class AsistentesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dniPersona")
    private String dniPersona;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nombreEvento")
    private String nombreEvento;

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsistentesEntity that = (AsistentesEntity) o;
        return Objects.equals(dniPersona, that.dniPersona) && Objects.equals(nombreEvento, that.nombreEvento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dniPersona, nombreEvento);
    }
}
