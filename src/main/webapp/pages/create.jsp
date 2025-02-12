<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>${isUpdate ? 'Edit Country' : 'Create Country'}</title>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/bootstrap.min.css">
    <script src="${path}/resources/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="partials/navigation.jsp"/>
    <div class="container">
        <div class="row">
            <form action="${path}${isUpdate ? '/update': '/save'}" method="post">
                <c:if test="${isUpdate}">
                    <input type="hidden" name="countryId" value="${country.countryId}"/>
                </c:if>

                <div class="mb-3">
                    <label for="name" class="form-label">Country name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter country name"
                           value="${isUpdate ? country.name : ''}">
                </div>

                <div class="mb-3">
                    <label for="continent" class="form-label">Continent</label>
                    <input type="text" class="form-control" id="continent" name="continent" placeholder="Enter country continent"
                           value="${isUpdate ? country.continent : ''}">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
