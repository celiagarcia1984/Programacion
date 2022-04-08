package modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AsistentesEntityPK implements Serializable {
    @Column(name = "dniPersona")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dniPersona;
    @Column(name = "nombreEvento")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        AsistentesEntityPK that = (AsistentesEntityPK) o;
        return Objects.equals(dniPersona, that.dniPersona) && Objects.equals(nombreEvento, that.nombreEvento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dniPersona, nombreEvento);
    }
}
