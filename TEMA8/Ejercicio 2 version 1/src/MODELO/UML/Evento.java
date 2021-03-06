package MODELO.UML;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Evento {
    String nombre;
    String lugar;
    LocalDate fecha;
    LocalTime horaInicio;
    LocalTime horaFin;
    int aforo;
    int aforoDisponible;
    ArrayList<Persona>listaPersonasAsistentes = new ArrayList<>();

    public Evento(String nombre, String lugar, LocalDate fecha, LocalTime horaInicio,
                  LocalTime horaFin, int aforo, int aforoDisponible) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aforo = aforo;
        this.aforoDisponible = aforoDisponible;
    }

    public Evento(String nombre, String lugar, LocalDate fecha, LocalTime horaInicio,
                  LocalTime horaFin, int aforo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aforo = aforo;
    }

    public Evento(String nombre, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int aforo,
                  int aforoDisponible, ArrayList<Persona> listaPersonasAsistentes) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aforo = aforo;
        this.aforoDisponible = aforoDisponible;
        this.listaPersonasAsistentes = listaPersonasAsistentes;
    }

    public Evento() {
    }

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public int getAforoDisponible() {
        return aforoDisponible;
    }

    public void setAforoDisponible(int aforoDisponible) {
        this.aforoDisponible = aforoDisponible;
    }

    @Override /*Este es el texto que sale cuando se confirman los datos de borrado*/
    public String toString() {
        return "Evento: " + nombre + "\n" +
                "Lugar: " + lugar + "\n" +
                "Fecha: " + fecha +"\n"+
                "HoraInicio: " + horaInicio + "\n"+
                "HoraFin: " + horaFin + "\n"+
                "Aforo: " + aforo + "\n"+
                "Aforo disponible: " + aforoDisponible;
    }
}
