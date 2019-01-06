$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "/matches",
        timeout: 60000,
        success: function (response) {
            prepareTable(response)
        }
    });

    $('#photo').change(function (e) {
        e.preventDefault();
        var hasPhoto = $(this).is(":checked")
        ajaxForFilter(hasPhoto, "photo", "")

    });

    $('#inContact').change(function (e) {
        e.preventDefault();
        var isEnable = $(this).is(":checked")
        ajaxForFilter(isEnable, "inContact", "")
    });


    $('#favourite').change(function (e) {
        e.preventDefault();
        var favourite = $(this).is(":checked")
        ajaxForFilter(favourite, "favourite", "")
    });

    $("#slider_score").change(function (e) {
        var current = $(this)
        var value = current.prop('value')
        console.log(value)

        ajaxForFilter("true", "score", value)
    });

    $("#slider_age").change(function (e) {
        var current = $(this)
        var value = current.prop('value')
        console.log(value)
        ajaxForFilter("true", "age", value)
    });

    $("#slider_height").change(function (e) {
        var current = $(this)
        var value = current.prop('value')
        ajaxForFilter("true", "height", value)
    });


    function ajaxForFilter(isEnable, filterName, value) {
        $.ajax({
            type: "GET",
            url: "/filters?isEnable=" + isEnable + "&filterName=" + filterName+ "&value=" + value,
            timeout: 60000,
            success: function (response) {
                prepareTable(response)
            }
        });
    }

    function prepareTable(response) {
        $("#result tbody").html("");
        if (response.length > 0) {
            for (i = 0; i < response.length; i++) {
                $("#result tbody").append(
                    "<tr>" +
                    "<td id='displayName'> " + response[i].displayName + "</td>" +
                    "<td id='age'>" + response[i].age + "</td>" +
                    "<td id='jonTitle'>" + response[i].jobTitle + "</td>" +
                    "<td id='heightInCm'>" + response[i].heightInCm + "</td>" +
                    "<td id='city'>" + response[i].city.name + "</td>" +
                    "<td id='mainPhoto'><img class='SourceImage' src=" + processImage(response[i].mainPhoto) + " ></td>" +
                    "<td id='compatibilityScore'>" + response[i].compatibilityScore + "</td>" +
                    "<td id='contactsExchanged'>" + response[i].contactsExchanged + "</td>" +
                    "<td id='favourite'>" + response[i].favourite + "</td>" +
                    "<td id='religion'>" + response[i].religion + "</td>" +
                    "</tr>"
                );
            }
        }
        else {
            alert("No data available")
        }
    }


    function processImage(responsePhoto) {
        if (responsePhoto === "Not available") {
            return "no_image_avail.png"
        } else {
            return responsePhoto
        }
    }

});