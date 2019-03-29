<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
<body>
<f:view>
    <h2><h:outputText value="Hello World JSF!" /></h2>
    <h3>Nome da aplicacao = <h:outputText value="#{helloBean.nome}" /></h3>

    <h:form>
    </h:form>
</f:view>
</body>
</html>
