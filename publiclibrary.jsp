<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view><html>
<head>
    <title>Sample</title>
</head>
<body>
    <br><br><br>
    <jsp:useBean id="libraryRender" scope="request" type="main.java.dao.BooksHandler"/>
    <h:dataTable id="dt1" value="${libraryRender.getBookById(1)}" var="item" bgcolor="#F1F1F1" border="10" cellpadding="5" cellspacing="3" rows="4" width="50%" dir="LTR" frame="hsides" rules="all" summary="This is a JSF code to create dataTable." >

        <f:facet name="header">
            <h:outputText value="This is 'dataTable' demo" />
        </f:facet>

        <h:column>
            <f:facet name="header">
                <h:outputText value="title" />
            </f:facet>
            <h:outputText style="" value="${item.title}" >WORK</h:outputText>
        </h:column>

        <h:column>
            <f:facet name="header">
                <h:outputText value="author"/>
            </f:facet>
            <h:outputText value="${item.author}">WORK</h:outputText>
        </h:column>
    </h:dataTable><br>

</body></html></f:view>
