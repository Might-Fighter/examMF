package exammf.modelo;

/**
 * Clase Tarea - Modelo
 * Representa una tarea académica del estudiante
 * 
 * @author MightFighter
 */
public class Tarea {
    // Atributos privados
    private String codigo;
    private String titulo;
    private String curso;
    private String fechaEntrega;
    private String estado;

    /**
     * Constructor de Tarea
     * 
     * @param codigo       Código único de la tarea
     * @param titulo       Título de la tarea
     * @param curso        Curso al que pertenece
     * @param fechaEntrega Fecha de entrega (formato: yyyy-MM-dd)
     * @param estado       Estado de la tarea (Pendiente, En proceso, Completada)
     */
    public Tarea(String codigo, String titulo, String curso, String fechaEntrega, String estado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.curso = curso;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    /**
     * Getters y Setters
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", curso='" + curso + '\'' +
                ", fechaEntrega='" + fechaEntrega + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
