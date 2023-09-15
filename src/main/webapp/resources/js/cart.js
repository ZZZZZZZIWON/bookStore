window.addEventListener("load", () => {
    document.querySelectorAll(".cart").forEach(item => {
        item.addEventListener("click", e =>{
            const target = e.target.closest("tr");
            const bookid = target.dataset.bookid;

            fetch(`add_cart/${bookid}`, {
                method: "GET",
            })
            .then(resp => resp.text())
            .then(result  =>{
                if(result == "OK")
                alert("장바구니에 담기 성공")
            });
        });
    });
});