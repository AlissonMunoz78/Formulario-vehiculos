import java.util.ArrayList;

public class Vehiculos {

    public static class Vehiculo {
        private String placa;
        private String marca;
        private int cilindraje;
        private String tipoCombustible;
        private String color;
        private ArrayList<Propietarios.Propietario> propietarios;

        public Vehiculo(String placa, String marca, int cilindraje, String tipoCombustible, String color, ArrayList<Propietarios.Propietario> propietarios) {
            this.placa = placa;
            this.marca = marca;
            this.cilindraje = cilindraje;
            this.tipoCombustible = tipoCombustible;
            this.color = color;
            this.propietarios = propietarios;
        }

        public String getPlaca() {
            return placa;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public int getCilindraje() {
            return cilindraje;
        }

        public void setCilindraje(int cilindraje) {
            this.cilindraje = cilindraje;
        }

        public String getTipoCombustible() {
            return tipoCombustible;
        }

        public void setTipoCombustible(String tipoCombustible) {
            this.tipoCombustible = tipoCombustible;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public ArrayList<Propietarios.Propietario> getPropietarios() {
            return propietarios;
        }

        public void setPropietarios(ArrayList<Propietarios.Propietario> propietarios) {
            this.propietarios = propietarios;
        }

        @Override
        public String toString() {
            return "Vehiculo{" +
                    "placa='" + placa + '\'' +
                    ", marca='" + marca + '\'' +
                    ", cilindraje=" + cilindraje +
                    ", tipoCombustible='" + tipoCombustible + '\'' +
                    ", color='" + color + '\'' +
                    ", propietarios=" + propietarios +
                    '}';
        }
    }
}
