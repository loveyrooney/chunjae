/*
<script 속성 src=""></script>
defer : 브라우저가 페이지의 파싱을 모두 끝내면 스크립트 실행
async : 브라우저가 페이지를 파싱하는 동안 스크립트 실행
모두 선언하지 않을 경우 : 브라우저가 페이지를 파싱하기 전에(HTML 태그 순서에 도달할때) 스크립트 가져와서 바로 실행
*/

console.log(document.body);
console.log(document.getElementById('d1'));
// console.log(document.getElementById('txt').value='hong');
console.log(document.getElementsByClassName('c1')[0].childNodes);

document.getElementById('btn1').onclick = ()=>{
    document.getElementById('result').innerHTML += `<li>hello$'</li>`;
}

// let ele_li = document.getElementsByTagName('li');
// console.log(ele_li);
// for(let i=0; i<ele_li.length; i++){
//     ele_li[i].style.backgroundColor='yellow';
// }

let ele_t2 = document.getElementsByName('t2');
console.log(ele_t2);
ele_t2[1].setAttribute('value','kkkk');
let get_t2_ = ele_t2[1].getAttribute('value');
console.log(get_t2_);

let layout_img = document.getElementsByClassName('layout');
for(let j=0; j<layout_img.length; j++){
    layout_img[j].addEventListener('mouseover',function (){
       for(let k=0; k<layout_img.length; k++){
           layout_img[k].style.border='';
       }
       let v = document.getElementById('view');
       v.setAttribute('src', this.src);
       v.setAttribute('alt', this.alt);
       this.style.border = '3px solid yellow';
    });
}

//addEventListener 안에 화살표함수 쓰면 this 동작 불가. 이유 찾을 것.

let child = document.body.children;
console.log(child);
let li = document.getElementsByTagName('li')[1];
console.log(li.className, li.tagName, li.textContent);

let r1 = document.getElementsByClassName('a');
let r2 = document.querySelectorAll('li');
console.log(r1,r2);

// let red = document.querySelectorAll('.yellow');
// for(let l=0; l<red.length; l++){
//     red[l].className = 'green';
// }

let ul_2 = document.getElementsByTagName('ul')[1];
console.log(ul_2.children, ul_2.firstElementChild, ul_2.lastElementChild, ul_2.nextElementSibling, ul_2.previousElementSibling);

r2.forEach(e=>{
   if(e.classList.contains('yellow')) {
       //e.classList.replace('yellow','orange');
       e.className = 'green';
   }
});

let result2 = document.getElementById('result2');
document.getElementById('btn2').addEventListener('click',(e)=>{
    console.log(e);
    e.preventDefault();
    let name = document.getElementById('name');
    let ele_li = document.createElement('li');
    let txt= document.createTextNode(name.value);
    ele_li.appendChild(txt);
    result2.appendChild(ele_li);
});
result2.addEventListener('click',(e)=>{
    e.target.classList.toggle('orange');
});
result2.addEventListener('dblclick',(e)=>{
    e.target.parentElement.removeChild(e.target);
})

let d2 = document.getElementById('d2');
let ele_span = document.createElement('span');
let txt_span = document.createTextNode('span');
ele_span.appendChild(txt_span);
//d2.appendChild(ele_span); //타겟 자식 자리에 생긴다.
//d2.append(ele_span); //타겟 자식 자리에 생긴다.
//d2.after(ele_span); //nextSibling 자리에 생긴다.

let tagbody = document.getElementsByTagName('body')[0];
console.log(tagbody);
tagbody.insertBefore(ele_span, d2); //d2 이전에 ele_span을 추가해라.

let ele_table = document.querySelector('tbody');
ele_table.addEventListener('mouseover',(e)=>{
   e.target.parentElement.classList.toggle('yellow');
});

let add_btn = document.querySelector('#btn3');
let input = document.getElementById('txt_input');
let left_select = document.querySelector('.left_select');
let right_select = document.querySelector('.right_select');
add_btn.addEventListener('keyup',()=>{
    let ele_opt = document.createElement('option');
    ele_opt.setAttribute('value',input.value);
    let txtnode = document.createTextNode(input.value);
    ele_opt.appendChild(txtnode);
    left_select.appendChild(ele_opt);
});

// document.getElementById('left').addEventListener('click',()=>{
//     let left_select_first = left_select.firstElementChild;
//     let ele_opt = document.createElement('option');
//     ele_opt.setAttribute('value', left_select_first.value);
//     ele_opt.appendChild(document.createTextNode(left_select_first.value));
//     right_select.appendChild(ele_opt);
//     left_select_first.remove();
// });

