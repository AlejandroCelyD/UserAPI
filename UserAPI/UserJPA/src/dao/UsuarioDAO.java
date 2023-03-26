package dao;

import controlador.UsuarioJpaController;
import entidad.Usuario;

public class UsuarioDAO {
    
    private UsuarioJpaController usuarioController = new UsuarioJpaController();
    private Usuario usuario = new Usuario();
    private String mensaje = "";
    
    public String insertarUsuario(String username, String nombre, String contrasena, String correo)  {
        try {
            usuario.setKIdUsuario(Integer.MIN_VALUE);
            usuario.setNUsername(username);
            usuario.setNNombre(nombre);
            usuario.setOContrasena(contrasena);
            usuario.setOCorreo(correo);
            usuarioController.create(usuario);
            mensaje = "Guardado correctamente";
        } catch (Exception e) {
            System.out.println("Mensaje en guardar" + e.getMessage());
            mensaje = "No se pudo guardar la informacion";
        }
        return mensaje;
    }
    
    public String actualizarUsuario(int id, String username, String nombre, String contrasena, String correo)  {
        try {
            usuario.setKIdUsuario(id);
            usuario.setNUsername(username);
            usuario.setNNombre(nombre);
            usuario.setOContrasena(contrasena);
            usuario.setOCorreo(correo);
            usuarioController.create(usuario);
            mensaje = "Actualizado correctamente";
        } catch (Exception e) {
            System.out.println("Mensaje en actualizar" + e.getMessage());
            mensaje = "No se pudo actualizar la informacion";
        }
        return mensaje;
    }
    
    public String eliminarUsuario(int id){
        try {
            usuarioController.destroy(id);
            mensaje = "Eliminado correctamente";
        } catch (Exception e) {
            System.out.println("Mensaje en eliminar " + e.getMessage());
            mensaje = "No se pudo eliminar la informacion";
        }
        return mensaje;
    }
    
}
