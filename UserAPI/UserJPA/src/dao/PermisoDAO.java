package dao;

import controlador.PermisoJpaController;
import entidad.Permiso;

public class PermisoDAO {
    
    private PermisoJpaController permisoController = new PermisoJpaController();
    private Permiso permiso = new Permiso();
    private String mensaje = "";
    
    public String insertarPermiso(String categoria, String nombre, int acceso){
        try{
            permiso.setKIdPermiso(Integer.SIZE);
            permiso.setOCategoria(categoria);
            permiso.setNNombre(nombre);
            permiso.setVAcceso(acceso);
            permisoController.create(permiso);
            mensaje = "Guardado correctamente";
        }catch(Exception e){
            System.out.println("Mensaje en guardar" + e.getMessage());
            mensaje = "No se pudo guardar la informacion";
        };
        
        return mensaje;
    }
    
    public String actualizarPermiso(int id, String categoria, String nombre, int acceso){
        try{
            permiso.setKIdPermiso(id);
            permiso.setOCategoria(categoria);
            permiso.setNNombre(nombre);
            permiso.setVAcceso(acceso);
            permisoController.edit(permiso);
            mensaje = "Actualizado correctamente";
        }catch(Exception e){
            System.out.println("Mensaje en actualizar " + e.getMessage());
            mensaje = "No se pudo actualizar la informacion";
        };
        
        return mensaje;
    }
    
    public String eliminarPermiso(int id){
        try {
            permisoController.destroy(id);
            mensaje = "Eliminado correctamente";
        } catch (Exception e) {
            System.out.println("Mensaje en eliminar " + e.getMessage());
            mensaje = "No se pudo eliminar la informacion";
        }
        return mensaje;
    }
    
}
