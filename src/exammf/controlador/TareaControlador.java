package exammf.controlador;

import exammf.modelo.GestorTareas;
import exammf.modelo.Tarea;
import exammf.vista.TareaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Controlador - Conecta la Vista con el Modelo
 * 
 * @author MightFighter
 */
public class TareaControlador {
    private TareaVista vista;
    private GestorTareas modelo;

    public TareaControlador(TareaVista vista, GestorTareas modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // Asignar listeners a los botones de la vista
        this.vista.addBtnRegistrarListener(new RegistrarListener());
        this.vista.addBtnMostrarTodosListener(new MostrarTodosListener());

        // Cargar datos iniciales en la tabla si los hubiera
        actualizarTabla();
    }

    /**
     * Actualiza la tabla de la vista con los datos del modelo
     */
    private void actualizarTabla() {
        vista.getModeloTabla().setRowCount(0); // Limpiar tabla
        for (Tarea t : modelo.getTareas()) {
            vista.getModeloTabla().addRow(new Object[] {
                    t.getCodigo(), t.getTitulo(), t.getCurso(), t.getFechaEntrega(), t.getEstado()
            });
        }
    }

    // ==========================================
    // CLASES INTERNAS: ActionListeners
    // ==========================================

    class RegistrarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String codigo = vista.getCodigo();
            String titulo = vista.getTitulo();
            String curso = vista.getCurso();
            String fecha = vista.getFecha();
            String estado = vista.getEstado();

            // Validación básica
            if (codigo.isEmpty() || titulo.isEmpty() || curso.isEmpty() || fecha.isEmpty()) {
                vista.mostrarMensaje("Por favor complete todos los campos.");
                return;
            }

            // Verificar si el código ya existe
            if (modelo.buscarTarea(codigo) != null) {
                vista.mostrarMensaje("Ya existe una tarea registrada con ese código.");
                return;
            }

            // Crear la tarea y agregarla al modelo
            Tarea nuevaTarea = new Tarea(codigo, titulo, curso, fecha, estado);
            modelo.agregarTarea(nuevaTarea);

            // Actualizar vista
            actualizarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Tarea registrada exitosamente.");
        }
    }

    class MostrarTodosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            actualizarTabla();
        }
    }
}
