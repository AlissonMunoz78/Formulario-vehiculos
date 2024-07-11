import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class Main extends JFrame {

    private JTextField txtPlaca, txtMarca, txtCilindraje, txtTipoCombustible, txtColor;
    private JTextArea txtPropietarios;
    private JButton btnRegistrar, btnLimpiar;
    private String url = "jdbc:mysql://localhost:3306/vehiculos";
    private String user = "root";
    private String password = "123456";

    public Main() {
        super("Registro de Vehículos");

        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(new JLabel("Placa:"));
        txtPlaca = new JTextField();
        panel.add(txtPlaca);

        panel.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        panel.add(txtMarca);

        panel.add(new JLabel("Cilindraje:"));
        txtCilindraje = new JTextField();
        panel.add(txtCilindraje);

        panel.add(new JLabel("Tipo de Combustible:"));
        txtTipoCombustible = new JTextField();
        panel.add(txtTipoCombustible);

        panel.add(new JLabel("Color:"));
        txtColor = new JTextField();
        panel.add(txtColor);

        panel.add(new JLabel("Propietarios (separados por coma):"));
        txtPropietarios = new JTextArea(2, 20);
        panel.add(new JScrollPane(txtPropietarios));

        btnRegistrar = new JButton("Registrar Vehículo");
        btnLimpiar = new JButton("Limpiar Formulario");

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnRegistrar);
        btnPanel.add(btnLimpiar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarVehiculo();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }

    public void mostrarInterfaz() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    private void registrarVehiculo() {
        String placa = txtPlaca.getText();
        String marca = txtMarca.getText();
        int cilindraje = Integer.parseInt(txtCilindraje.getText());
        String tipoCombustible = txtTipoCombustible.getText();
        String color = txtColor.getText();
        String propietariosText = txtPropietarios.getText();
        String[] propietariosArray = propietariosText.split(",");

        ArrayList<Propietarios.Propietario> propietarios = new ArrayList<>();
        for (String propietarioStr : propietariosArray) {
            String[] datosPropietario = propietarioStr.trim().split("\\s*,\\s*");
            if (datosPropietario.length == 3) {
                Propietarios.Propietario propietario = new Propietarios.Propietario(datosPropietario[0], datosPropietario[1], datosPropietario[2]);
                propietarios.add(propietario);
            }
        }

        Vehiculos.Vehiculo vehiculo = new Vehiculos.Vehiculo(placa, marca, cilindraje, tipoCombustible, color, propietarios);
        guardarVehiculoEnBD(vehiculo);

        JOptionPane.showMessageDialog(this, "Vehículo registrado correctamente.");

        limpiarFormulario();
    }

    private void limpiarFormulario() {
        txtPlaca.setText("");
        txtMarca.setText("");
        txtCilindraje.setText("");
        txtTipoCombustible.setText("");
        txtColor.setText("");
        txtPropietarios.setText("");
    }

    private void guardarVehiculoEnBD(Vehiculos.Vehiculo vehiculo) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO vehiculos (placa, marca, cilindraje, tipo_combustible, color) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setInt(3, vehiculo.getCilindraje());
            stmt.setString(4, vehiculo.getTipoCombustible());
            stmt.setString(5, vehiculo.getColor());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al registrar el vehículo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.mostrarInterfaz();
        });
    }
}
