package MODELO.UML;

public class Asistente {
   String idAsistente;
   String dniPersona;
   String nombreEvento;

   public Asistente(String idAsistente, String dniPersona, String nombreEvento) {
      this.idAsistente = idAsistente;
      this.dniPersona = dniPersona;
      this.nombreEvento = nombreEvento;
   }

   public Asistente() {
   }

   public String getIdAsistente() {
      return idAsistente;
   }

   public void setIdAsistente(String idAsistente) {
      this.idAsistente = idAsistente;
   }

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
   public String toString() {
      return "Asistente{" +
              "idAsistente='" + idAsistente + '\'' +
              ", dniPersona='" + dniPersona + '\'' +
              ", nombreEvento='" + nombreEvento + '\'' +
              '}';
   }
}
