import java.util.Scanner;
import java.util.ArrayList;
public class Vehiculo {
    private String placa;
    private String marca;
    private int cilindraje;
    private String tipoCombustible;
    private String color;
    private ArrayList<Propietario> propietario;

    public Vehiculo(String placa, String marca, int cilindraje, String tipoCombustible, String color, ArrayList<Propietario> propietario) {
        this.placa = placa;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.tipoCombustible = tipoCombustible;
        this.color = color;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public ArrayList<Propietario> getPropietario() {
        return propietario;
    }

    public void setPropietario(ArrayList<Propietario> propietario) {
        this.propietario = propietario;
    }
}