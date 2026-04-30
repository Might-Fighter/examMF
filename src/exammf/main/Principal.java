package exammf.main;

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
            // Crear modelo
            GestorTareas modelo = new GestorTareas();

            // Crear vista
            TareaVista vista = new TareaVista();

            // Mostrar ventana
            vista.setVisible(true);
        });
    }
}
