<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:if test="${sessionScope.admin == null}">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>


<a href="ServletListadoClientes">Gestionar clientes</a>
&nbsp;
<a href="ServletListadoZapatos?desde=0&cuantos=2">Gestionar zapatos</a>
&nbsp;
<a href="registrarClientes.jsp">Registrar clientes</a>
&nbsp;
<a href="registrarZapatos.jsp">Registrar zapatos</a>
&nbsp;
<a href="ServletLogOutAdmin">Salir</a>
&nbsp;
