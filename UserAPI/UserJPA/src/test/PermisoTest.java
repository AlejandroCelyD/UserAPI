package test;

import dao.PermisoDAO;

public class PermisoTest {
   
    public static void main(String[] args) {
        PermisoDAO pdao = new PermisoDAO();
        
        System.out.println(pdao.actualizarPermiso(1,"a", "b", 3));
    }
}
