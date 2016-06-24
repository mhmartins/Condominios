<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h2>Mural de Informações</h2>
    
    <c:forEach items="${mural.informacoes}" var="informacao">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <he class="panel-title">${informacao.titulo}</he>
            </div>
            <div class="panel-body">
                ${informacao.informacao}
            </div>
            
        </div>
        
        
    </c:forEach>
    
</div>