$(document).ready(function () {

    var str = location.href.toString();
    var num = str.indexOf("?");
    if (num > 0) {
        str = str.substr(num + 1);
        var params = str.split("&");
        for (var i = 0; i < params.length; i++) {
            var n = params[i].indexOf("=");
            params[i] = params[i].substr(n + 1);
        }
        $('#userName').attr("value", params[0]);
        $('#userGender').attr("value", params[1]);
        $('#userEmail').attr("value", params[2]);
        $('#userAge').attr("value", params[3]);
        $('#userId').attr("value", params[4]);
    }

    //$('#addUser').submit(function (e) {
    //
    //    e.preventDefault();
    //
    //    var data = {};
    //
    //    $.each(this, function (i, v) {
    //        var input = $(v);
    //        if (input.val() != "") {
    //            var value = input.val();
    //            if (input.name == "id") {
    //                value = parseInt(input.val());
    //            }
    //            data[input.attr("name")] = value;
    //        }
    //    });
    //
    //    $.ajax({
    //        contentType: 'application/json; charset=utf-8',
    //        type: 'POST',
    //        url: '/web/users',
    //        dataType: 'json',
    //        data: JSON.stringify(data),
    //        success: function(responseData, textStatus){
    //            console.log("post success" + responseData);
    //
    //            console.log("post success" + textStatus);
    //            //window.location.href = "/web/views/users.jsp";
    //        }
    //    });
    //
    //});
});