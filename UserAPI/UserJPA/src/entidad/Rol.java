/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ALEJANDRO
 */
@Entity
@Table(name = "rol")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByKIdRol", query = "SELECT r FROM Rol r WHERE r.kIdRol = :kIdRol"),
    @NamedQuery(name = "Rol.findByNNombre", query = "SELECT r FROM Rol r WHERE r.nNombre = :nNombre"),
    @NamedQuery(name = "Rol.findByODescripcion", query = "SELECT r FROM Rol r WHERE r.oDescripcion = :oDescripcion")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "k_id_rol")
    private Integer kIdRol;
    @Basic(optional = false)
    @Column(name = "n_nombre")
    private String nNombre;
    @Column(name = "o_descripcion")
    private String oDescripcion;
    @JoinTable(name = "usuario_rol", joinColumns = {
        @JoinColumn(name = "k_id_rol", referencedColumnName = "k_id_rol")}, inverseJoinColumns = {
        @JoinColumn(name = "k_id_usuario", referencedColumnName = "k_id_usuario")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @ManyToMany(mappedBy = "rolCollection")
    private Collection<Permiso> permisoCollection;

    public Rol() {
    }

    public Rol(Integer kIdRol) {
        this.kIdRol = kIdRol;
    }

    public Rol(Integer kIdRol, String nNombre) {
        this.kIdRol = kIdRol;
        this.nNombre = nNombre;
    }

    public Integer getKIdRol() {
        return kIdRol;
    }

    public void setKIdRol(Integer kIdRol) {
        this.kIdRol = kIdRol;
    }

    public String getNNombre() {
        return nNombre;
    }

    public void setNNombre(String nNombre) {
        this.nNombre = nNombre;
    }

    public String getODescripcion() {
        return oDescripcion;
    }

    public void setODescripcion(String oDescripcion) {
        this.oDescripcion = oDescripcion;
    }

    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kIdRol != null ? kIdRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.kIdRol == null && other.kIdRol != null) || (this.kIdRol != null && !this.kIdRol.equals(other.kIdRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Rol[ kIdRol=" + kIdRol + " ]";
    }
    
}
