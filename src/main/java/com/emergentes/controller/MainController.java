package com.emergentes.controller;

import com.emergentes.bean.BeanContacto;
import com.emergentes.entidades.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Estamos en el servlet");
        try {
            //Permite evaluar el prametro
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            //Variable para el uso de la implementacion permite reaiza todas la operacion que hemos implementado
            BeanContacto dao = new BeanContacto();
            Contacto co = new Contacto();
            int id;

            switch (action) {
                case "add":
                    request.setAttribute("contacto", co);
                    request.getRequestDispatcher("frmcontacto.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    co = dao.buscar(id);
                    request.setAttribute("contacto", co);
                    request.getRequestDispatcher("frmcontacto.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("MainController");
                    break;
                case "view":
                    //obtener la lista de objetos (registros)
                    List<Contacto> lista = dao.listarTodos();
                    //Ponerlo como atributo de lista
                    request.setAttribute("contactos", lista);
                    //Pasamos el control
                    request.getRequestDispatcher("contacto.jsp").forward(request, response);
                    break;
                default:

                    break;
            }

        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String celular = request.getParameter("telefono");

        Contacto co = new Contacto();

        co.setId(id);
        co.setNombre(nombre);
        co.setCorreo(correo);
        co.setTelefono(celular);

        BeanContacto dao = new BeanContacto();
        if (id == 0) {
            try {
                // Nuevo registro
                dao.insertar(co);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            try {
                // Edicion de registro
                dao.actualizar(co);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("MainController");

    }

}
