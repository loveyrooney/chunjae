//함수 선언문
function prt(a,b) {
    console.log(`hello, print function: ${a+b}`);
}
//함수 호출
prt(2,5);

function add(a1,b1,c1){
    let result = a1+b1+c1;
    return result;  //리턴에는 항상 값 하나만 들어갈 수 있다.
}
let a=100, b=200, c=300;
let result = add(a,b,c); //함수 호출문에는 값이 없이 부를수도, 값이 n개가 들어갈수도 있다.
//함수 호출문에 들어가는 값은 primitive, reference 모두 가능.
console.log(result);

let name = 'hong', age = 20;
function prt(name,age){
    console.log(`1. ${name} ${age}`);
}
prt(name,age);

let kor=100, eng=90;
function callprt(name,kor,eng){ //여기서 name, kor, eng 는 call by value
    console.log(`2. ${name} ${kor} ${eng}`);
    return kor+eng;
}
let result1 = callprt(name,kor,eng);
console.log(`3. ${result1}`);

//함수는 호출, 함수안에서 배열 출력
let arr2 = [10,20,30];
function fn(arr2) {   //여기서 arr2는 call by reference
    arr2.forEach((data) => {
        console.log(data);
    });
}
fn(arr2);

//함수에서 배열을 받아와서 출력
function getArr() {
    let data = [20,30,40];
    return data;
}
let t = getArr();
for(let T=0; T<t.length; T++){
    console.log(t[T]);
}


//함수 선언문과 함수 표현식의 차이
//함수 선언문은 함수 호이스팅이 발생.
//함수 표현식은 변수 호이스팅이 발생하나, let이나 const 등에 익명함수로 넣어놓으면(first-class function, 일급함수) 탐지 가능.
//함수 선언문은 고정된 객체라면 함수 표현식은 가변적으로 쓸수 있음.
//함수 선언문은 변수에 할당 불가, 함수 표현식은 할당 가능.

//함수 표현식
//num1,num2는 func 함수 내의 지역변수, 그리고 func라는 함수의 매개변수(parameter).
const func = function (num1, num2=0) {
    //add는 func함수 내의 지역변수.
    let add = num1+num2;
    return add;
}
let result2 = func(100, 20); // 함수 호출 안에 넣는 값은 인자(argument)
//func(100); num2의 디폴트값을 설정해뒀기 때문에 100+0
console.log(result2);

window.onload=()=>{
    document.getElementById('cal').onclick=()=>{
        let num1 = Number(document.getElementById('num1').value);
        let num2 = Number(document.getElementById('num2').value);
        //cal 함수를 이 라인에서 호출하면 에러.
        const cal = (num1,num2)=>{
            console.log(`add: ${num1+num2}`);
            console.log(`sub: ${num1-num2}`);
            console.log(`mul: ${num1*num2}`);
            if (num2==0) console.log('div: 0으로 나눌 수 없습니다.');
            else console.log(`div: ${num1/num2}`);
        }
        cal(num1,num2);
    }
}