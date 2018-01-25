/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MHuamani
 */
@Entity
@Table(name = "tab_usuario")
public class Usuario implements Serializable {

    @Size(max = 1)
    @Column(name = "C_ESTADO")
    private String cEstado;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "N_ID_USUARIO")
    private Long idUsuario;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    @Size(max = 255)
    @Column(name = "C_APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Size(max = 255)
    @Column(name = "C_APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Size(max = 10)
    @Column(name = "C_CLAVE")
    private String clave;
    @Size(max = 255)
    @Column(name = "C_NOMBRE")
    private String nombre;
    @Size(max = 10)
    @Column(name = "C_USUARIO")
    private String usuario;

    public Usuario() {
    }    

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }
    
}
