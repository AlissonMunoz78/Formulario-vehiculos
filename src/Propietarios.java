import java.util.Objects;

public class Propietarios {

    public static class Propietario {
        private String nombre;
        private String apellido;
        private String identificacion;

        public Propietario(String nombre, String apellido, String identificacion) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.identificacion = identificacion;
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

        public String getIdentificacion() {
            return identificacion;
        }

        public void setIdentificacion(String identificacion) {
            this.identificacion = identificacion;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Propietario that = (Propietario) o;
            return Objects.equals(identificacion, that.identificacion);
        }

        @Override
        public int hashCode() {
            return Objects.hash(identificacion);
        }

        @Override
        public String toString() {
            return "Propietario{" +
                    "nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", identificacion='" + identificacion + '\'' +
                    '}';
        }
    }
}
