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

});