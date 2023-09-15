$(function() {
    $(".password_check").each( (index, item) => {
        $(item).on("mousedown", e => {
            if(e.button == 0 ) 
                $(`input[name='${e.target.dataset.for}']`).attr("type", "text");
        })
        
        $(item).on("mouseup", e => {
            if(e.button == 0 ) 
            $(`input[name='${e.target.dataset.for}']`).attr("type", "password");
        });
    });
});

