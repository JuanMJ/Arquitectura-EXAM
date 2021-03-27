<%@ page language='java' contentType='text/html; charset=UTF-8'
	pageEncoding='UTF-8'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>Cuentas</title>
</head>
<body>	
    <table border=1>
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Compras</th>
                <th>Cuentas</th>
                <th>Cheques</th>
                <th colspan=2>Mantenimiento</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td><c:out value="${cliente.name}" /></td>
                    <c:choose>
                    <c:when test="${cliente.name == clienteActual}">
	                    <td>                     
		                    <table border=1>
					        <tbody>
							        	<c:forEach var="compra" items="${compras}">
						                <tr>
						                    <td><c:out value="${compra.name}" /></td>
						                    <td><c:out value="${compra.id}" /></td>
						                </tr>
						            	</c:forEach>
		                    </tbody>
		    				</table>
	                    </td>                     
	    				<td>  
		                    <c:choose>
		                    <c:when test="${cliente.name == clienteActual}">
				                    <table border=1>
							        <tbody>
									        	<c:forEach var="cuenta" items="${cuentas}">
								                <tr>
								                    <td><c:out value="${cuenta.name}" /></td>
								                    <td><c:out value="${cuenta.id}" /></td>
								                </tr>
								            	</c:forEach>
				                    </tbody>
				    				</table>
			            </td>                     
	    				<td>Pendiente</a></td>
	    				<td>Pendiente</a></td>
	    				<td>Pendiente</a></td>
	    				</c:when>  
		                    </c:choose>
	    				</td>  
    				</c:when>  
    				<c:otherwise>
	                    <td></td>
	    				<td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
			         </c:otherwise>  				
                    </c:choose>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>Agregar Cliente (Pendiente)</p>
	</body>
    </table>
    <p>Agregar Cuenta (Pendiente)</p>
</body>
</html>