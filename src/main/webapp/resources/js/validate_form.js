class ValidateForm {
    constructor(options) {
        this.tags = options.tags;
        this.form = document.querySelector(options.selector).closest("form");

        for(const item of this.tags) {
			item.tag = this.form.elements[item.tag];

			if(item.eq)
                item.eq = this.form.elements[item.eq];        	
        }

        document.querySelector(options.selector).addEventListener("click", e => {                		
            for(const item of this.tags)            	
                if(!this.valid(item)) return;		
            
            this.form.submit();
        });        
    }

    valid(item) {

        if(item.condition != undefined && !eval(item.condition) ) {
            alert(item.msg);
            item.tag.focus();
            return false;
        }
        
         if(item.eq && item.tag.value !== item.eq.value) {
                 alert(item.msg);
                 item.tag.focus();
                 return false;
             }
         
         if(!item.tag.value) {
            alert(item.msg);
            item.tag.focus();
            return false;
        }
         return true;
     }
}