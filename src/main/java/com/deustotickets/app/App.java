package com.deustotickets.app;

import com.deustotickets.domain.TipoUsuario;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Resource res = new Resource("127.0.0.1", "8080");
        res.registerUser("Usuario1", "u1@gmail.com", "u1", TipoUsuario.CLIENTE);
    }
}
