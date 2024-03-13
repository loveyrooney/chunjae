"use strict"

//'추가'버튼 클릭 이벤트
let fn_add= function(event) {
    console.log('test', event.key);
    event.preventDefault();
    if(event.key==='Enter' || event.key==undefined){
            let new_input = document.getElementById('new_input');
            let selector = document.getElementById('left_selector');
        let data = new_input.value;
       if(data){
            let ele_option = document.createElement('option');
            let txt = document.createTextNode(data);
            ele_option.appendChild(txt);
            console.log("add");
            
            selector.appendChild(ele_option);
            new_input.value = '';
      }
}
};
let add=document.getElementById('add');

add.addEventListener('click', fn_add);
add.addEventListener('keyup',fn_add);

/*
selector가져오기 
*/
let left_selector= document.getElementById('left_selector')
let right_selector= document.getElementById('right_selector')

let rmove_btn=document.getElementById('rmove_btn');
let lmove_btn=document.getElementById('lmove_btn');

//'왼쪽에서 오른쪽' 버튼 누르기
let fn_rightmove=function(event){
    event.preventDefault;
    if(event.key==='Enter'){
        let selected_list = left_selector.selectedOptions;
    
        [...selected_list].forEach(item=>{
            right_selector.appendChild(item);
    
        });
    }
  }
    
let fn_leftmove=function(event){
    event.preventDefault;
    if(event.key==='Enter') {

    let selected_list = right_selector.selectedOptions;
    
    [...selected_list].forEach(item=>{
        left_selector.appendChild(item);

    });
  }
};  

rmove_btn.addEventListener('click',fn_rightmove);
rmove_btn.addEventListener('keydown',fn_rightmove)

 lmove_btn.addEventListener('click', fn_leftmove);
 lmove_btn.addEventListener('keydown', fn_leftmove);

 left_selector.addEventListener('dblclick', function(event){
        let item= event.target;
        console.log(item);
        this.removeChild(item);

});

left_selector.addEventListener('keydown', function(event){
      if(event.key==='Enter'){
        let selected_options=  left_selector.selectedOptions;
        [... selected_options].forEach(item=>{
            this.removeChild(item);
        });
      }
});