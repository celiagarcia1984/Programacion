package modelo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "evento", schema = "ejer2", catalog = "")
public class EventoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "lugar")
    private String lugar;
    @Basic
    @Column(name = "fecha")
    private Date fecha;
    @Basic
    @Column(name = "horaInicio")
    private Time horaInicio;
    @Basic
    @Column(name = "horaFin")
    private Time horaFin;
    @Basic
    @Column(name = "aforo")
    private int aforo;
    @OneToMany(mappedBy = "eventoByNombreEvento")
    private Collection<AsistentesEntity> asistentesByNombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventoEntity that = (EventoEntity) o;
        return aforo == that.aforo && Objects.equals(nombre, that.nombre) && Objects.equals(lugar, that.lugar) && Objects.equals(fecha, that.fecha) && Objects.equals(horaInicio, that.horaInicio) && Objects.equals(horaFin, that.horaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, lugar, fecha, horaInicio, horaFin, aforo);
    }

    public Collection<AsistentesEntity> getAsistentesByNombre() {
        return asistentesByNombre;
    }

    public void setAsistentesByNombre(Collection<AsistentesEntity> asistentesByNombre) {
        this.asistentesByNombre = asistentesByNombre;
    }
}
