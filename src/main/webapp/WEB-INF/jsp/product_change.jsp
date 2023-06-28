<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>H+ Sport</title>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<header id="home" class="header">
    <nav class="nav" role="navigation">
        <div class="container nav-elements">
            <div class="branding">
                <a href="home"><img src="images/hpluslogo.svg"
                                    alt="Logo - H Plus Sports"></a>
            </div>
            <!-- branding -->
            <ul class="navbar">
                <li><a href="#">home</a></li>
                <li><a href="#">login</a></li>
                <li><a href="#">search</a></li>
                <li><a href="#">linkedin</a></li>
            </ul><!-- navbar -->
            <!-- navbar -->
        </div>
        <!-- container nav-elements -->
    </nav>
</header>
<!-- #home -->

<section id="search" class="section">
    <header class="imageheader"></header>
    <div class="container">
        <h2 class="headline">Update/Add products</h2>
        <form:form method="post" action="/registerproduct" modelAttribute="product">
            <label class="card-title">Search existing product</label>
            <input path="search" name="search" value="">
            <input type="submit" value="Search">
            <input type="submit" value="Update product">   <!-- ведет на форму изменения/добавления продукта, как сделать? -->
        </form>
    </div>
</section>
<!-- guarantee -->

<c:if test="${!empty(products)}">
    <section id="products" class="section">
        <c:forEach var="product" items="${products}">
        <div class="productContainer">

            <div class="productContainerItem">
                <img id="pic1" src="${product.imagePath}">
                <input type="text" name="product"
                       value="${product.name}"><br/>

            </div>

            </c:forEach>
        </div>

    </section>
</c:if>

<c:if test="${empty(products)}">
    <section id="products" class="section">
        <label>Product name</label> <form:input path="productname" type="text" /><form:errors path="productname" cssClass="error"/><br/>
        <form action="uploadImage.jsp" method="post" enctype="multipart/form-data">
            <input type="file" name="imageFile" accept="image/*" />
            <input type="submit" value="Upload" />
        </form>
        <!-- TODO implement upload image logic -->
    </section>
</c:if>

<footer class="footer">
    <div class="container">
        <nav class="nav" role="navigation">
            <div class="container nav-elements">
                <div class="branding">
                    <a href="#home"><img src="images/hpluslogo.svg"
                                         alt="Logo - H Plus Sports"></a>
                    <p class="address">
                        100 Main Street<br> Seattle, WA 98144
                    </p>
                </div>
            </div>
        </nav>
        <p class="legal">H+ Sport is a fictitious brand created by
            lynda.com solely for the purpose of training. All products and
            people associated with H+ Sport are also fictitious. Any resemblance
            to real brands, products, or people is purely coincidental.
            Information provided about the product is also fictitious and should
            not be construed to be representative of actual products on the
            market in a similar product category.</p>
    </div>
    <!-- container -->
</footer>
<!-- footer -->


</body>
</html>