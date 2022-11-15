<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2022
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h2 class="css">Product List</h2>
<form style="margin-left: 258px" action="<%=request.getContextPath()%>/ProductServlet" method="get">
    <input placeholder="tìm kiếm sản phẩm" type="text" name="productName">
    <input type="submit" name="action" value="search">
</form>
<form style="margin-left: 258px" action="<%=request.getContextPath()%>/ProductServlet">
    <select name="searchPrice">
        <option value="0">0-500</option>
        <option value="500">500-1000</option>
        <option value="1000">1000-1500</option>
    </select>
    <input type="submit" name="action" value="searchPrice">
</form>
<div class="css">
    <table border="1">
        <thead>
        <tr>
            <th>Product ID</th>
            <th class="mot">Product Name</th>
            <th class="hai">Price</th>
            <th class="hai">Created</th>
            <th class="des">Descriptions</th>
            <th class="hai">Product Status</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listProduct}" var="pro">
            <tr>
                <td>${pro.productID}</td>
                <td class="mot">${pro.productName}</td>
                <td>${pro.price}</td>
                <td class="hai"><fmt:formatDate value="${pro.created}" pattern="dd-MM-yyyy"/></td>
                <td class="des">${pro.descriptions}</td>
                <td class="hai">${pro.productStatus?"Còn Hàng":"Hết Hàng"}</td>
                <td>
                    <a class="edit" href="<%=request.getContextPath()%>/ProductServlet?productID=${pro.productID}&&action=update">Update</a>
                    <a class="edit" href="<%=request.getContextPath()%>/ProductServlet?productID=${pro.productID}&&action=delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<a class="box" href="views/newProduct.jsp">Create new Product</a>
<style>
    .edit{
        text-decoration: none;
    }
    .css{
        display: flex;
        justify-content: center;
    }
    .box{
        position: absolute;
        border: 2px solid black;
        margin-top: 15px;
        margin-left: 700px;
        padding: 10px;
        text-decoration: none;
        cursor: pointer;
        text-align: center;
        background-color: coral;
    }
    th {
        text-align: center;
        height: 55px;
    }
    td{
        text-align: center;
    }
    th{
        background-color: chartreuse;
    }
    .mot{
        width: 180px;
    }
    .hai{
        width: 120px;
    }
    .des{
        width: 250px;
    }
</style>
</body>
</html>
