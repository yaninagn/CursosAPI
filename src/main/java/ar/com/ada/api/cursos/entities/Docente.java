package ar.com.ada.api.cursos.entities;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "docente")
public class Docente extends Persona {
    @Id
    @Column(name = "docente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer docenteId;
    @ManyToMany
    @JoinTable(name = "docente_x_curso", joinColumns = @JoinColumn(name = "docente_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
    @JsonIgnore
    private List<Curso> cursosQueDicta = new ArrayList<>();
    @OneToOne(mappedBy = "docente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Usuario usuario;//se agrego relacion bidireccional entre Docente->Usuario + el cascade type ALL.

    public Integer getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Integer docenteId) {
        this.docenteId = docenteId;
    }

    public List<Curso> getCursosQueDicta() {
        return cursosQueDicta;
    }

    public void setCursosQueDicta(List<Curso> cursosQueDicta) {
        this.cursosQueDicta = cursosQueDicta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.usuario.setDocente(this);// aca establecemos la relacion bidireccional
    }

}