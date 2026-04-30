package exammf.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestorTareas - Modelo
 * Gestiona la lista de tareas académicas
 */
public class GestorTareas {
    private List<Tarea> listaTareas;

    public GestorTareas() {
        listaTareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }

    public List<Tarea> getTareas() {
        return listaTareas;
    }

    public boolean eliminarTarea(String codigo) {
        return listaTareas.removeIf(t -> t.getCodigo().equals(codigo));
    }

    public Tarea buscarTarea(String criterio) {
        for (Tarea t : listaTareas) {
            if (t.getCodigo().equalsIgnoreCase(criterio) || t.getTitulo().equalsIgnoreCase(criterio)) {
                return t;
            }
        }
        return null;
    }

    public boolean cambiarEstado(String codigo, String nuevoEstado) {
        for (Tarea t : listaTareas) {
            if (t.getCodigo().equals(codigo)) {
                t.setEstado(nuevoEstado);
                return true;
            }
        }
        return false;
    }
}
