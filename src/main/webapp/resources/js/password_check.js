window.addEventListener ("load",  function() {

    const buttons = document.querySelectorAll(".password_check");

    buttons.forEach(button => {

        button.addEventListener("mousedown", e => {
            
            if(e.button == 0 ) {
                const name = e.target.dataset.for;
            const input  = document.querySelector(`input[name='${name}']`);
            input.setAttribute("type","text");
          }
        });
    
        button.addEventListener("mouseout", e => {
            if(e.button == 0 ) {
            const name = e.target.dataset.for;
            const input  = document.querySelector(`input[name='${name}']`);
            input.setAttribute("type","password");
          }
        });
    });
});