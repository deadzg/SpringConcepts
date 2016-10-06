<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
	<spring:url value="/printUser" var="userActionUrl" />
	<h2>${msg}</h2>
	<form:form class="form-horizontal" method="post"
                modelAttribute="userForm" action="${userActionUrl}">
    	<form:input path="name" type="text" class="form-control"
                                id="name" placeholder="Name" />
        <button type="submit" class="btn-lg btn-primary pull-right">Add
       </button>
    
    </form:form>

</html>