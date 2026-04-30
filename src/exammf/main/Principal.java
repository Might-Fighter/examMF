package exammf.main;

import exammf.controlador.TareaControlador;
import exammf.modelo.GestorTareas;
import exammf.vista.TareaVista;
import javax.swing.SwingUtilities;

/**
 * Clase Principal - Punto de entrada
 * 
 * @author MightFighter
 */
public class Principal {

    public static void main(String[] args) {
        // Ejecutar en Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // 1. Crear modelo
            GestorTareas modelo = new GestorTareas();

            // 2. Crear vista
            TareaVista vista = new TareaVista();
            
            // 3. Crear controlador (conecta modelo y vista)
            TareaControlador controlador = new TareaControlador(vista, modelo);

            // 4. Mostrar ventana
            vista.setVisible(true);
        });
    }
}
