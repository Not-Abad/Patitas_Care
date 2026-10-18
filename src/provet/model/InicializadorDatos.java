/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provet.model;

/**
 *
 * @author jesus-abad
*/
public class InicializadorDatos {

    public static void cargarUsuarios() {
        // Limpiamos la lista por si acaso se llama más de una vez
        ControlUsuarios.listaUsuarios.clear();

        // 1. Administrador (Tú, Abad)
        ControlUsuarios.listaUsuarios.add(new Usuario(
            "Abad",
            "123456",
           "Administrador", 
           "2281001122", 
           "0905chucho@gmail.com", 
           "/provet/view/imagenes/abad.png"
        ));

        // 2. Veterinario
        ControlUsuarios.listaUsuarios.add(new Usuario(
            "Angie", 
         "123456",
            "Veterinario", 
            "2281234567", 
            "angie@patitascare.com", 
            "/provet/view/imagenes/mascota2.jpeg"
        ));

        // 3. Recepcionista
        ControlUsuarios.listaUsuarios.add(new Usuario(
            "Chiu", 
             "123456",   
            "Recepcionista", 
            "2289876543", 
            "loveenhyeb@gmail.com", 
            "/provet/view/imagenes/mascota2.jpeg"
        ));

        // 4. Cajero
        ControlUsuarios.listaUsuarios.add(new Usuario(
            "Axel", 
            "123456",   
            "Cajero", 
            "2285554433", 
            "axel@patitascare.com", 
            "/provet/view/imagenes/mascota2.jpeg"
        ));

        // 5. Secretaria
        ControlUsuarios.listaUsuarios.add(new Usuario(
            "Mayela", 
            "123456",    
            "Secretaria", 
            "2281112233", 
                "0905chucho@gmail.com", 
            "/provet/view/imagenes/mascota2.jpeg"
        ));
        
        System.out.println("LOG: 5 usuarios cargados correctamente en el sistema.");
    }
}
