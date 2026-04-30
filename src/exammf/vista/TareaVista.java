package exammf.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Vista - Interfaz gráfica Swing
 * 
 * @author MightFighter
 */
public class TareaVista extends JFrame {
    // Formulario
    private JTextField txtCodigo;
    private JTextField txtTitulo;
    private JTextField txtCurso;
    private JTextField txtFecha;
    private JComboBox<String> cmbEstado;

    // Botones
    private JButton btnRegistrar;
    private JButton btnEliminar;
    private JButton btnCambiarEstado;
    private JButton btnBuscar;
    private JButton btnMostrarTodos;

    // Búsqueda
    private JTextField txtBuscar;

    // Tabla
    private JTable tablaTareas;
    private DefaultTableModel modeloTabla;

    public TareaVista() {
        setTitle("Sistema de Gestión de Tareas Académicas by MightFighter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 750);
        setMinimumSize(new Dimension(850, 700)); // Para evitar que el usuario la haga muy pequeña
        setLocationRelativeTo(null);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Fuentes y colores generales
        Font fuenteGeneral = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteTitulos = new Font("Segoe UI", Font.BOLD, 14);
        Color colorFondoBotones = new Color(52, 152, 219); // Azul brillante
        Color colorTextoBotones = Color.WHITE;

        // Panel Principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(15, 15));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Panel Norte: Formulario de Registro
        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 10, 10));
        javax.swing.border.TitledBorder bordeForm = BorderFactory.createTitledBorder("Datos de la Tarea");
        bordeForm.setTitleFont(fuenteTitulos);
        panelFormulario.setBorder(
                BorderFactory.createCompoundBorder(bordeForm, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setFont(fuenteGeneral);
        panelFormulario.add(lblCodigo);
        txtCodigo = new JTextField();
        txtCodigo.setFont(fuenteGeneral);
        panelFormulario.add(txtCodigo);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setFont(fuenteGeneral);
        panelFormulario.add(lblTitulo);
        txtTitulo = new JTextField();
        txtTitulo.setFont(fuenteGeneral);
        panelFormulario.add(txtTitulo);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setFont(fuenteGeneral);
        panelFormulario.add(lblCurso);
        txtCurso = new JTextField();
        txtCurso.setFont(fuenteGeneral);
        panelFormulario.add(txtCurso);

        JLabel lblFecha = new JLabel("Fecha de entrega:");
        lblFecha.setFont(fuenteGeneral);
        panelFormulario.add(lblFecha);
        txtFecha = new JTextField();
        txtFecha.setFont(fuenteGeneral);
        panelFormulario.add(txtFecha);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setFont(fuenteGeneral);
        panelFormulario.add(lblEstado);
        cmbEstado = new JComboBox<>(new String[] { "Pendiente", "En proceso", "Completada" });
        cmbEstado.setFont(fuenteGeneral);
        cmbEstado.setBackground(Color.WHITE);
        panelFormulario.add(cmbEstado);

        btnRegistrar = new JButton("Registrar Tarea");
        btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnRegistrar.setBackground(new Color(46, 204, 113)); // Verde
        btnRegistrar.setForeground(colorTextoBotones);
        btnRegistrar.setFocusPainted(false);
        panelFormulario.add(new JLabel("")); // Espacio vacío
        panelFormulario.add(btnRegistrar);

        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);

        // Panel Centro: Tabla
        String[] columnas = { "Código", "Título", "Curso", "Fecha", "Estado" };
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaTareas = new JTable(modeloTabla);
        tablaTareas.setFont(fuenteGeneral);
        tablaTareas.setRowHeight(25);
        tablaTareas.getTableHeader().setFont(fuenteTitulos);
        tablaTareas.getTableHeader().setBackground(new Color(236, 240, 241));
        tablaTareas.setSelectionBackground(new Color(189, 195, 199));

        JScrollPane scrollTabla = new JScrollPane(tablaTareas);
        javax.swing.border.TitledBorder bordeTabla = BorderFactory.createTitledBorder("Lista de Tareas");
        bordeTabla.setTitleFont(fuenteTitulos);
        scrollTabla
                .setBorder(BorderFactory.createCompoundBorder(bordeTabla, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        panelPrincipal.add(scrollTabla, BorderLayout.CENTER);

        // Panel Sur: Acciones y Búsqueda divididos en dos filas
        JPanel panelSur = new JPanel(new GridLayout(2, 1, 5, 5));

        // Fila 1: Acciones de Tarea
        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        javax.swing.border.TitledBorder bordeAcciones = BorderFactory.createTitledBorder("Acciones de Tarea");
        bordeAcciones.setTitleFont(fuenteTitulos);
        panelAcciones.setBorder(bordeAcciones);

        btnEliminar = new JButton("Eliminar Seleccionada");
        configurarBoton(btnEliminar, new Color(231, 76, 60), fuenteGeneral); // Rojo

        btnCambiarEstado = new JButton("Cambiar Estado");
        configurarBoton(btnCambiarEstado, colorFondoBotones, fuenteGeneral);

        panelAcciones.add(btnEliminar);
        panelAcciones.add(btnCambiarEstado);

        // Fila 2: Búsqueda
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        javax.swing.border.TitledBorder bordeBusqueda = BorderFactory.createTitledBorder("Búsqueda");
        bordeBusqueda.setTitleFont(fuenteTitulos);
        panelBusqueda.setBorder(bordeBusqueda);

        JLabel lblBuscar = new JLabel("Buscar (Código/Título):");
        lblBuscar.setFont(fuenteGeneral);
        panelBusqueda.add(lblBuscar);

        txtBuscar = new JTextField(15);
        txtBuscar.setFont(fuenteGeneral);
        panelBusqueda.add(txtBuscar);

        btnBuscar = new JButton("Buscar");
        configurarBoton(btnBuscar, colorFondoBotones, fuenteGeneral);

        btnMostrarTodos = new JButton("Mostrar Todas");
        configurarBoton(btnMostrarTodos, new Color(149, 165, 166), fuenteGeneral); // Gris

        panelBusqueda.add(btnBuscar);
        panelBusqueda.add(btnMostrarTodos);

        panelSur.add(panelAcciones);
        panelSur.add(panelBusqueda);

        panelPrincipal.add(panelSur, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
    }

    // Método auxiliar para estilo de botones
    private void configurarBoton(JButton boton, Color fondo, Font fuente) {
        boton.setFont(fuente);
        boton.setBackground(fondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
    }

    // Métodos para obtener datos del formulario
    public String getCodigo() {
        return txtCodigo.getText().trim();
    }

    public String getTitulo() {
        return txtTitulo.getText().trim();
    }

    public String getCurso() {
        return txtCurso.getText().trim();
    }

    public String getFecha() {
        return txtFecha.getText().trim();
    }

    public String getEstado() {
        return (String) cmbEstado.getSelectedItem();
    }

    // Método para limpiar formulario
    public void limpiarFormulario() {
        txtCodigo.setText("");
        txtTitulo.setText("");
        txtCurso.setText("");
        txtFecha.setText("");
        cmbEstado.setSelectedIndex(0);
    }

    // Métodos para interactuar con la tabla
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public JTable getTablaTareas() {
        return tablaTareas;
    }

    public String getCriterioBusqueda() {
        return txtBuscar.getText().trim();
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Asignación de ActionListeners para el controlador
    public void addBtnRegistrarListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }

    public void addBtnEliminarListener(ActionListener listener) {
        btnEliminar.addActionListener(listener);
    }

    public void addBtnCambiarEstadoListener(ActionListener listener) {
        btnCambiarEstado.addActionListener(listener);
    }

    public void addBtnBuscarListener(ActionListener listener) {
        btnBuscar.addActionListener(listener);
    }

    public void addBtnMostrarTodosListener(ActionListener listener) {
        btnMostrarTodos.addActionListener(listener);
    }
}
