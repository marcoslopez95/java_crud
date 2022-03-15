<%@tag import="java.util.List"%>
<%@tag import="java.util.Iterator"%>
<%@tag import="java.util.ArrayList"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="encabezado" required="true" type="ArrayList"%>

<table class="table table-hover">
    <thead>
        <tr>
            <%
                Iterator list = encabezado.iterator();
                    while (list.hasNext()){
                    
            %>
            <th>
               <%list.next();%>
            </th>
            <%}%>
        </tr>
    </thead>
</table>
<h2>${message}</h2>