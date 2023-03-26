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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ALEJANDRO
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByKIdUsuario", query = "SELECT u FROM Usuario u WHERE u.kIdUsuario = :kIdUsuario"),
    @NamedQuery(name = "Usuario.findByNUsername", query = "SELECT u FROM Usuario u WHERE u.nUsername = :nUsername"),
    @NamedQuery(name = "Usuario.findByNNombre", query = "SELECT u FROM Usuario u WHERE u.nNombre = :nNombre"),
    @NamedQuery(name = "Usuario.findByOContrasena", query = "SELECT u FROM Usuario u WHERE u.oContrasena = :oContrasena"),
    @NamedQuery(name = "Usuario.findByOCorreo", query = "SELECT u FROM Usuario u WHERE u.oCorreo = :oCorreo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "k_id_usuario")
    private Integer kIdUsuario;
    @Basic(optional = false)
    @Column(name = "n_username")
    private String nUsername;
    @Basic(optional = false)
    @Column(name = "n_nombre")
    private String nNombre;
    @Basic(optional = false)
    @Column(name = "o_contrasena")
    private String oContrasena;
    @Basic(optional = false)
    @Column(name = "o_correo")
    private String oCorreo;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Rol> rolCollection;

    public Usuario() {
    }

    public Usuario(Integer kIdUsuario) {
        this.kIdUsuario = kIdUsuario;
    }

    public Usuario(Integer kIdUsuario, String nUsername, String nNombre, String oContrasena, String oCorreo) {
        this.kIdUsuario = kIdUsuario;
        this.nUsername = nUsername;
        this.nNombre = nNombre;
        this.oContrasena = oContrasena;
        this.oCorreo = oCorreo;
    }

    public Integer getKIdUsuario() {
        return kIdUsuario;
    }

    public void setKIdUsuario(Integer kIdUsuario) {
        this.kIdUsuario = kIdUsuario;
    }

    public String getNUsername() {
        return nUsername;
    }

    public void setNUsername(String nUsername) {
        this.nUsername = nUsername;
    }

    public String getNNombre() {
        return nNombre;
    }

    public void setNNombre(String nNombre) {
        this.nNombre = nNombre;
    }

    public String getOContrasena() {
        return oContrasena;
    }

    public void setOContrasena(String oContrasena) {
        this.oContrasena = oContrasena;
    }

    public String getOCorreo() {
        return oCorreo;
    }

    public void setOCorreo(String oCorreo) {
        this.oCorreo = oCorreo;
    }

    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kIdUsuario != null ? kIdUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.kIdUsuario == null && other.kIdUsuario != null) || (this.kIdUsuario != null && !this.kIdUsuario.equals(other.kIdUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Usuario[ kIdUsuario=" + kIdUsuario + " ]";
    }
    
}
