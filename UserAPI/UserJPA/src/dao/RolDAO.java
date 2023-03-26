package dao;

import controlador.RolJpaController;
import entidad.Rol;


public class RolDAO {
    
    private RolJpaController rolController = new RolJpaController();
    private Rol rol = new Rol();
    private String mensaje = "";
    
    public String insertarRol(String nombre, String descripcion){
        try{
            rol.setKIdRol(Integer.SIZE);
            rol.setNNombre(nombre);
            rol.setODescripcion(descripcion);
            rolController.create(rol);
            mensaje = "Guardado correctamente";
        }catch(Exception e){
            System.out.println("Mensaje en guardar" + e.getMessage());
            mensaje = "No se pudo guardar la informacion";
        };
        
        return mensaje;
    }
    
    public String actualizarRol(int id, String nombre, String descripcion){
        try{
            rol.setKIdRol(id);
            rol.setNNombre(nombre);
            rol.setODescripcion(descripcion);
            rolController.edit(rol);
            mensaje = "Actualizado correctamente";
        }catch(Exception e){
            System.out.println("Mensaje en actualizar" + e.getMessage());
            mensaje = "No se pudo actualizador la informacion";
        };
        
        return mensaje;
    }
    
    public String eliminarRol(int id){
        try {
            rolController.destroy(id);
            mensaje = "Eliminado correctamente";
        } catch (Exception e) {
            System.out.println("Mensaje en eliminar " + e.getMessage());
            mensaje = "No se pudo eliminar la informacion";
        }
        return mensaje;
    }
}
