$(document).ready(function () {
    if (!$('#sidebar').length) {
        $('#sidebarCollapse').hide();
    }
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('d-none');
    });
});