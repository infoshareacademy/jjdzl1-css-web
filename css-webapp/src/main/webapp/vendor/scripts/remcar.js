$(document).ready(function () {

    $.fn.populate = function (data) {
        var formFields = $(this).find(":input");
        formFields.each(function (index) {
            $(this).val(data[$(this).prop('id')]);
        });
    };

    var form = $("#newcar"),
        formFields = form.find(":input"),
        data = {};

    form.change(function () {

        formFields.each(function (index) {
            data[$(this).prop('id')] = $(this).val();
        });

        var storageKey = window.location.pathname + "||" + $(this).prop('id');

        localStorage.setItem(storageKey, JSON.stringify(data));
    });

    var storageKey = window.location.pathname + "||newcar";
    var formData = localStorage.getItem(storageKey);

    form.populate(JSON.parse(formData));
});