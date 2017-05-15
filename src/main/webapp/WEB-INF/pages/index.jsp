<jsp:include page="_header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="banner">
    <div class="container">
        <div class="banner-bottom">
            <div class="banner-bottom-right">

                <!--banner-->




                <script src="../js/responsiveslides.min.js"></script>
                <script>
                    // You can also use "$(window).load(function() {"
                    $(function () {
                        // Slideshow 4
                        $("#slider4").responsiveSlides({
                            auto: true,
                            pager: true,
                            nav: false,
                            speed: 500,
                            namespace: "callbacks",
                            before: function () {
                                $('.events').append("<li>before event fired.</li>");
                            },
                            after: function () {
                                $('.events').append("<li>after event fired.</li>");
                            }
                        });

                    });
                </script>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

<!-- content-section-starts-here -->




<div class="container">
    <div class="main-content">
        <div class="online-strip">
            <div class="col-md-4 follow-us">

            </div>
            <div class="col-md-4 shipping-grid">

                <div class="shipping-text">
                    <h1>Welcome to Site Journal! </h1>

                    <p>This project was made for my Final project to Fortect
                    Pre-Employment Training </p>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="col-md-4 online-itemOrder">

            </div>
            <div class="clearfix"></div>
        </div>
        <div class="products-grid">
            <header>
                <h3 class="head text-center">Muresan Andrei's final Project</h3>
            </header>



            <div class="clearfix"></div>
        </div>
    </div>

</div>

<%--Books slider starts here--%>



<%--Books slider ends here--%>

<!-- content-section-ends-here -->

<jsp:include page="_footer.jsp"/>