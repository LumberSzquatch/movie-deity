$(document).ready(function(){
    // Add smooth scrolling to all links in navbar + footer link
    $(".navbar a, a, footer a[href='#landing']").on('click', function(event) {
        // Make sure this.hash has a value before overriding default behavior
        if (this.hash !== "") {
            // Prevent default anchor click behavior
            event.preventDefault();

            // Store hash
            var hash = this.hash;

            // Using jQuery's animate() method to add smooth page scroll
            // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 900, function(){

                // Add hash (#) to URL when done scrolling (default click behavior)
                window.location.hash = hash;
            });
        } // End if
    });

    //If UserController has errors in BindingResult, scroll down to signUp form on page return
    if ($('.form-error').length > 0) {
        $.fn.scrollView = function () {
            return this.each(function () {
                $('html, body').animate({
                    scrollTop: $(this).offset().top
                }, 1000);
            });
        }
        $('#signUp').scrollView();
    }

    // Makes scrolling look smooth
    $(window).scroll(function() {
        $(".slideanim").each(function(){
            var pos = $(this).offset().top;

            var winTop = $(window).scrollTop();
            if (pos < winTop + 600) {
                $(this).addClass("slide");
            }
        });
    });

    // This removes the errors, but then validation is gone for good, want a reset of some sort
    $('#formReset').on('click', function(event) {
        // $('#signUpForm').validator('destroy');
        // $('#signUpForm').validator().resetForm(true); //DOESN'T WORK...
    });

});