function sendGreeting() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/greet',
        data: 'name=' + $('#name').val(),
        dataType: 'text'
    }).done(function(data) {
        $('.form-group label:first').before('<p>' + data + '</p>');
    }).fail(function(err){
        alert(err);
    });
}