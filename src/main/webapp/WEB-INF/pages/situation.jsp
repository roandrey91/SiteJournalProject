<jsp:include page="_header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="row">
    <div class="col-md-12">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <h1 class="text-center">Situation day</h1>
                <form action="" id="andrei-form">
                    <div id="data-container">
                        <div class="data-row well">
                            <div class="form-group">
                                <%--<jsp:useBean id="situationDay" class="com.sitejournal.data.DaySituatiation"--%>
                                             <%--scope="request"/>--%>
                                <form:form action="situation" method="post" modelAttribute="situationDay">
                                <%--<form:input path="situationDay.upDate"/>--%>
                                <%--<input type="date"  value="${situationDay.upDate}" required>--%>
                                <%--<input type="date" class="form-control data-situatiei" name="data-situatiei"--%>
                                       <%--placeholder="Select Date" value="${situationDay.upDate}" required>--%>
                                <p class="help-block">Select Date</p>
                            </div>
                            <div class="form-group">

                                <form:textarea path="situationDay.describeDay" rows="4" cols="80" />
                                <%--<textarea class="form-control" rows="4" cols="80" name="textul-situatiei"--%>
                                          <%--id="textul-situatiei" placeholder="Describe the day"><c:out--%>
                                        <%--value="${situationDay.describeDay}"/></textarea>--%>
                                <p class="help-block">Describe site situation and what happend in this day.</p>

                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <a href="#" id="add-situation" role="button" class="btn btn-success btn-xs pull-right"><span
                                class="glyphicon glyphicon-plus"></span></a>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Send" class="btn btn-primary btn-lg">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form:form>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    $(".data-situatiei").datepicker({
        dateFormat: "dd-mm-yy"
    });

    $(document).ready(function () {

        $('form#andrei-form').on('click', '#add-situation', function () {
            // console.log('clicked');
            var copia_unui_singur_form = $('#data-container .data-row').first().clone();
            // console.log(copia_unui_singur_form);

            $(copia_unui_singur_form).find('input').removeClass('hasDatepicker').attr('id', '').val('');
            $(copia_unui_singur_form).find('textarea').val('');

            $(copia_unui_singur_form).appendTo('#data-container');
            $(copia_unui_singur_form).find(".data-situatiei").datepicker();
        });

        $('form#andrei-form').on('submit', function (e) {
            e.preventDefault();
            e.stopPropagation();

            var final_object = [];

            $('.data-row', this).each(function () {
                var selected_date = $(this).find('input').val();
                var entered_text = $(this).find('textarea').val();

                final_object.push({
                    'date': selected_date,
                    'text': entered_text
                });
            });

            console.log(final_object);

            $.ajax({
                url: '/path/to/file',
                type: 'POST',
                dataType: 'json)',
                data: final_object
            })
                .done(function () {
                    console.log("adding data to database: success");
                })
                .fail(function () {
                    console.log("adding data to database: error");
                })
                .always(function () {
                    console.log("sending to server: complete");
                });

        });
    });
</script>


<jsp:include page="_footer.jsp"/>