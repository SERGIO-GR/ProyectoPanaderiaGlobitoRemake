<%-- 
    Document   : Errores
    Created on : 9/09/2020, 02:11:46 PM
    Author     : Usuario1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<%  
    String usuario = "";
    HttpSession sesionUser = request.getSession();
    if(sesionUser.getAttribute("usuario")==null){
%>
<jsp:forward page="inicio.jsp">
    <jsp:param name="error" value="Es obligatorio Autenticarse"/>
</jsp:forward>

<% }else{
        usuario = (String)sesionUser.getAttribute("usuario");
        } %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" 
              rel="stylesheet">
        <link rel="stylesheet" href="./css/style.css"/>
        <link rel="shortcut icon" href="./img/logo.jpg" type="image/x-icon"/>
    </head>
    <body>
        <header class="header" >
            <div class="logo" >
                <h1>Panederia el Globito</h1>
                <img src="./img/logo.jpg" alt="logo">       
            </div>
            <nav class="menu" >
                <a href="#">Principal</a>
                <a href="#">Nosotros</a>
                <a href="#">Productos</a>
                <a href="#">Contacto</a>
                <a href="inicio.jsp" >Iniciar Sesion</a>
            </nav>
        </header>
        <section class="globito" >
            <h2>La panadería el globito, hace pan artesanal desde 1842, y ahora esta en la nube
            compre su panecito aqui *w* nwn (*w*)</h2>
            <img src="./img/globito.jpg" alt="Globito" >
        </section>
        <h2 class="titutlo-p" >Pan Artesanal</h2>
        
        <section class="hide" >
            
        </section>
        <section class="errores" >
            <h2>Error al momento de ingresar sus credenciales favor de intentarlo de nuevo</h2>
        </section>
        <footer class="footer" >
            <p>Desarrollado por demoñoño </p>
        </footer>
        
        
    </body>
</html>
