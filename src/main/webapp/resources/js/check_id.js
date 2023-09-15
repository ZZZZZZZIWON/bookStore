
let checkId = false;

window.addEventListener("load", () =>  {
    const button = document.getElementById("check_id");
    const button_sync = document.getElementById("check_id_sync");

    document.querySelector("input[name='custid']").addEventListener("change", e => {
        checkId = false;
    })

    // [비동기] 중복확인
    button.addEventListener("click", () => { 
        const id = document.querySelector("input[name='custid']").value;

		const xhr = new XMLHttpRequest();
		xhr.open("GET", `checkId/${id}`, true);

        xhr.onreadystatechange = () => {
            console.log(xhr.readyState);

            if(xhr.readyState == xhr.DONE) {
                if(xhr.status == 200) {
                    if(xhr.responseText === "OK") {
                    	checkId = true;
                    	alert("사용 가능한 아이디 입니다.");
                    } else {                    
                    	alert("다른 사용자가 이미 등록한 아이디 입니다.");
                    }
                } 
            }
        };
		xhr.send();

    });


    // [동기] 중복확인
    button_sync.addEventListener("click", () => { 
        const id = document.querySelector("input[name='custid']").value;

		const xhr = new XMLHttpRequest();
		xhr.open("GET", `checkId/${id}`, false);
		
		xhr.send();

        if(xhr.responseText === "OK") {
        	checkId = true;
        	alert("사용 가능한 아이디 입니다.");
        } else {                    
        	alert("다른 사용자가 이미 등록한 아이디 입니다.");
        }
    });
});