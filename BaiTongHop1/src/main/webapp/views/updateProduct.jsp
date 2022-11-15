<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2022
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<div class="ba">
    <h2 style="text-align: center">Update Product</h2>
    <form class="form" action="<%=request.getContextPath()%>/ProductServlet" method="post">
        <table>
            <tr>
                <td>Product ID</td>
                <td><input type="text" name="productID" value="${productUpdate.productID}" readonly></td>
            </tr>
            <tr>
                <td>Product Name</td>
                <td><input type="text" name="productName" value="${productUpdate.productName}"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="number" name="price" value="${productUpdate.price}"></td>
            </tr>
            <tr>
                <td>Created</td>
                <td><input type="date" name="created" value="${productUpdate.created}"></td>
            </tr>
            <tr>
                <td>Descriptions</td>
                <td><input type="text" name="descriptions" value="${productUpdate.descriptions}"></td>
            </tr>
            <tr>
                <td>Product Status</td>
                <td>
                    <c:choose>
                        <c:when test="${productUpdate.productStatus}">
                            <input type="radio" name="productStatus" id="active" value="true" checked/><label for="active">Còn
                            Hàng</label>
                            <input type="radio" name="productStatus" id="inactive" value="false"/><label for="inactive">Hết
                            Hàng</label>
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="productStatus" id="active" value="true" checked/><label for="active">Còn
                            Hàng</label>
                            <input type="radio" name="productStatus" id="inactive" value="false"/><label for="inactive">Hết
                            Hàng</label>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td style="cursor: pointer;text-align: center" colspan="2">
                    <input style="background-color: cornflowerblue" type="submit" value="Update" name="action"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<style>
    .form{
        border: 2px solid;
        padding: 10px;
    }
    .ba{
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
    }
</style>
</body>
</html>
