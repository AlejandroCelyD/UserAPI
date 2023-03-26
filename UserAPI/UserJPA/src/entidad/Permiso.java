
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

@Entity

@Table(name = "permiso")
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByKIdPermiso", query = "SELECT p FROM Permiso p WHERE p.kIdPermiso = :kIdPermiso"),
    @NamedQuery(name = "Permiso.findByOCategoria", query = "SELECT p FROM Permiso p WHERE p.oCategoria = :oCategoria"),
    @NamedQuery(name = "Permiso.findByNNombre", query = "SELECT p FROM Permiso p WHERE p.nNombre = :nNombre"),
    @NamedQuery(name = "Permiso.findByVAcceso", query = "SELECT p FROM Permiso p WHERE p.vAcceso = :vAcceso")})

public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "k_id_permiso")
    private Integer kIdPermiso;
    @Basic(optional = false)
    @Column(name = "o_categoria")
    private String oCategoria;
    @Basic(optional = false)
    @Column(name = "n_nombre")
    private String nNombre;
    @Basic(optional = false)
    @Column(name = "v_acceso")
    private int vAcceso;
    @JoinTable(name = "rol_permiso", joinColumns = {
        @JoinColumn(name = "k_id_permiso", referencedColumnName = "k_id_permiso")}, inverseJoinColumns = {
        @JoinColumn(name = "k_id_rol", referencedColumnName = "k_id_rol")})
    @ManyToMany
    private Collection<Rol> rolCollection;

    public Permiso() {
    }

    public Permiso(Integer kIdPermiso) {
        this.kIdPermiso = kIdPermiso;
    }

    public Permiso(Integer kIdPermiso, String oCategoria, String nNombre, int vAcceso) {
        this.kIdPermiso = kIdPermiso;
        this.oCategoria = oCategoria;
        this.nNombre = nNombre;
        this.vAcceso = vAcceso;
    }

    public Integer getKIdPermiso() {
        return kIdPermiso;
    }

    public void setKIdPermiso(Integer kIdPermiso) {
        this.kIdPermiso = kIdPermiso;
    }

    public String getOCategoria() {
        return oCategoria;
    }

    public void setOCategoria(String oCategoria) {
        this.oCategoria = oCategoria;
    }

    public String getNNombre() {
        return nNombre;
    }

    public void setNNombre(String nNombre) {
        this.nNombre = nNombre;
    }

    public int getVAcceso() {
        return vAcceso;
    }

    public void setVAcceso(int vAcceso) {
        this.vAcceso = vAcceso;
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
        hash += (kIdPermiso != null ? kIdPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.kIdPermiso == null && other.kIdPermiso != null) || (this.kIdPermiso != null && !this.kIdPermiso.equals(other.kIdPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Permiso[ kIdPermiso=" + kIdPermiso + " ]";
    }
    
}
