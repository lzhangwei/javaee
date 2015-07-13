function deleteUser(id) {
    $.ajax({
        url: '/web/users?id=' + id,
        type: 'DELETE',
        success: function () {
            window.location.reload();
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
