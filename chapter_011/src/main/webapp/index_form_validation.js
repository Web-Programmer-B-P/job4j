$(document).ready(function () {
    let validName = false;
    let validSurname = false;

    $('form').submit(function (event) {
        event.preventDefault();
        let name = $('#name').val();
        let surname = $('#surname').val();
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
    });
});

function addRow() {
    let sex = $('input[name="radio"]:checked').val();
    if (sex === 'man') {
        sex = 'Мужской';
    } else {
        sex = 'Женский';
    }
    let name = $('#name').val();
    let surname = $('#surname').val();
    let comment = $('#comment').val();
    $('#table_row tr:last').after(
        '<tr>'
        + '<td>' + name + '</td>'
        + '<td>' + surname + '</td>'
        + '<td>' + comment + '</td>'
        + '<td>' + sex + '</td>'
        + '</tr>');
}