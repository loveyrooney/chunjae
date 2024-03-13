"use strict";

//var는 선언만 되고 할당되지 않아도 변수 호이스팅에 의해 undefined가 할당된다.
//let은 선언만 되고 할당되지 않으면 에러를 일으킨다.

//var는 전역변수이다. 그래서  for문 바깥 i는 3이 나온다.
for(var i=0; i<2; i++){
    console.log(`var ${i}`);
}
console.log(`var ${i}`);

//let은 블록레벨 스코프를 가진다. for문 바깥 j는 에러가 난다.
for(let j=0; j<2; j++){
    console.log(`let ${j}`);
}
//console.log(`let ${j}`);

//-------

//원시 타입, primitive : 변수 안에 저장
let a = 10; //number
let b = 'aa'; //string
let c = 10.2; //number
let d = 10 == 10; //boolean
let e = null; //콘솔은 object로 나오지만 이건 js개발 자체적 문제.
//그 외에 undefined, symbol, bigint 등이 있다.
//number 타입 중에 Infinity(0으로 나누는 등, 음수를 0으로 나누면 음의무한대), NaN (문자열을 숫자로 나누는 등)
//boolean 에서 false의 경우는 0,NaN,null,undefined,'' 일 때

//참조 타입, reference : 저장되어 있는 그곳을 가리킴
let f = [];
let g = {};
let h = function () {};
console.log('a',typeof a);
console.log('b',typeof b);
console.log('c',typeof c);
console.log('d',typeof d);
console.log('e',typeof e);
console.log('f',typeof f);
console.log('g',typeof g);
console.log('h',typeof h);