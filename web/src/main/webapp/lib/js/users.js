function deleteUser(id) {
    $.ajax({
        url: '/web/users?id=' + id,
        type: 'DELETE',
        success: function (data) {
            if(data == 'success') {
                window.location.reload();
            } else {
                window.location.href = "/web/login"
            }
        }
    });
}

function updateUser(id, name, gender, email, age) {
    window.location.href = '/web/views/user.jsp?name=' + name
        + '&gender=' + gender
        + '&email=' + email
        + '&age=' + age
        + '&id=' + id;
}
