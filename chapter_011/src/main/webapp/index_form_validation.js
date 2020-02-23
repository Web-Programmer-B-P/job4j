$(document).ready(function () {
    var validName = false;
    var validSurname = false;

    $('form').submit(function (event) {
        event.preventDefault();
        var name = $('#name').val();
        var surname = $('#surname').val();
        if (name !== '') {
            validName = true;
            console.log(validName);
            $('.parentName').removeClass('has-error').addClass('has-success')
                .append("<span class='glyphicon glyphicon-ok form-control-feedback' aria-hidden='true'></span>");
            $('.parentName .glyphicon-remove').remove();
        } else {
            validName = false;
            $('.parentName').removeClass('has-success').addClass('has-error')
                .append("<span class='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span>");
            $('.parentName .glyphicon-ok').remove();
        }

        if (surname !== '') {
            validSurname = true;
            console.log(validName);
            $('.parentSurname').removeClass('has-error').addClass('has-success')
                .append("<span class='glyphicon glyphicon-ok form-control-feedback' aria-hidden='true'></span>");
            $('.parentSurname .glyphicon-remove').remove();
        } else {
            validSurname = false;
            $('.parentSurname').removeClass('has-success').addClass('has-error')
                .append("<span class='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span>");
            $('.parentSurname .glyphicon-ok').remove();
        }

        if (validName === true && validSurname === true) {
            $('form').unbind('submit').submit();
        }
    })
});