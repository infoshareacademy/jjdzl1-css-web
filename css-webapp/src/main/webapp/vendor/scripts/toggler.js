$(function () {$('[data-toggle="popover"]').popover()})
$(function () {$('[data-toggle="tooltip"]').tooltip()})

$(document).ready(function () {
    if (!$('#sidebar').length) {
        $('#sidebarCollapse').hide();
    }
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('d-none');
    });
});