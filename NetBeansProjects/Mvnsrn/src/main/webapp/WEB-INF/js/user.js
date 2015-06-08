/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $('#createuser').click(function () {
        $('#reqister').css('display', 'block');
        $('#reguser').css('display', 'none');
    });


    $('#hidebtn').click(function () {
        $('#reqister').css('display', 'none');
    });

    datetime();
    $('#datetime').val(dt);

    $('#savebtn').click(function () {

        var first = $('#firstname').val();
        var last = $('#lastname').val();
        var email = $('#email').val();
        var date = $('#datetime').val();

        if (first === "" || last === "" || email === "" || date === "") {
            alert("all fields required");
            return;
        } else {
            var data = "first=" + first + "&last=" + last + "&email=" + email + "&date=" + date;
//                        var jsn = {'first': first, 'last': last};
//                        var jsonfile = {json: JSON.stringify(jsn)};//"
            $.ajax({
                type: "POST",
                url: "addUser.htm",
                data: data,
                success: function (response) {
                    alert(response);
                    $('input[type=text]').val("");
                }
                ,
                error: function (e) {
                    alert('Error: ' + e);
                }
            });

        }

    });

    $('#userlist').click(function () {
        $('#reqister').css('display', 'none');
        deleteuser();

    });

    $('#reguser').on('click', 'input.dluser', function () {

        var id = $(this).attr('id');

        var data = "email=" + id;

        $.ajax({
            type: "POST",
            url: "deleteUser.htm",
            data: data,
            success: function (response) {
                deleteuser();
            }
            ,
            error: function (e) {
                alert('Error: ' + e);
            }
        });

    });

});


function datetime() {
    var d = new Date();

    var curr_day = d.getDate();
    var curr_month = d.getMonth();
    var curr_year = d.getFullYear();

    var curr_hour = d.getHours();
    var curr_min = d.getMinutes();
    var curr_sec = d.getSeconds();

    curr_month++; // In js, first month is 0, not 1
    year_2d = curr_year.toString().substring(2, 4)

    $("#txtDate").val(curr_day + " " + curr_month + " " + year_2d)
    return dt = curr_month + "/" + curr_day + "/" + curr_year;
}

function deleteuser() {
    $.ajax({
        url: "getUsers.htm",
        success: function (data) {
            var jsn = JSON.parse(data);
            var tbl = "<tr><th>FirstName</th><th>LastName</th><th>Email</th><th>Date</th><th></th></tr>";
            if (jsn) {
                for (var n = 0; n < jsn.length; n++) {

                    tbl += "<tr><td>" + jsn[n].firstname + "</td>" +
                            "<td>" + jsn[n].lastname + "</td><td>" + jsn[n].email +
                            "</td><td>" + jsn[n].date +
                            "</td><td><input type='button' class='dluser' id='" + jsn[n].email + "' value='Delete'/></td></tr>";
                }
                $('#users').html(tbl);
                $('#reguser').css('display', 'block');
            }
        }
        ,
        error: function (e) {
            alert('Error: ' + e);
        }
    });
}
