//spread syntax
//함수에서 매개변수 개수를 특정할 수 없을때 사용
const show = (...args)=>{
    for(let i =0; i<args.length; i++){
        console.log(args[i]);
    }
}
show();
show('kim');
show(1,'lee',true);
show([6,7,8],[9,10,11]);

//배열에서 배열의 요소들을 합칠 때 사용
let arr11 = [11,22,33];
let arr22 = [44,55];
let result11 = [...arr11, arr22];
console.log(result11);
let result22 = [...arr11, ...arr22];
console.log(result22);

//arrow function
const arrow = (A,B,C)=> A+B+C; //함수에 리턴만 있는경우 중괄호 생략 가능
console.log(arrow(3,6,9));
const arrow2 = param => param+1; // 매개변수 하나인 경우 괄호도 생략 가능
console.log(arrow2(1));

//callback
const originalfn = (arg1,arg2,cb)=>{
    let argsfn = cb(arg1,arg2);
    console.log(argsfn/2);
}
let cb = (a,b)=> a+b;
originalfn(10,90,cb); //콜백함수 따로 선언하고 변수를 인자에 넣어도 되고,
originalfn(10,90,(a,b)=>a*b); //간단하다면 함수자체를 인자에 넣어도 된다.

//즉시 실행 함수, IIFE
(()=>{console.log('IIFE');})();