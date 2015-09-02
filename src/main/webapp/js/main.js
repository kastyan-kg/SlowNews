$(function() {

    function toggleEditClasses() {
        $(".site-header").toggleClass("site-header--select-mode");
        $(".news-list").toggleClass("news-list--select-mode");
    }

    $(".news-item__action-button").click(function(event) {
       toggleEditClasses();
       $(event.target).siblings("label").click();
    });

    $("#select-mode-cancel").click(function() {
        toggleEditClasses();
    });

    $('#select-mode-save').click(function() {
        $('#select-news-form').submit();
    });

});