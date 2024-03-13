/*
객체는 표현할수 있는 모든 것이다.
객체는 값(속성,property)과 동작(메서드)으로 구성할 수 있고, 값은 변수에, 동작은 함수에 할당한다.
(객체의 값을 속성, 동작인 함수를 메서드라고 한다.)
이 값과 동작을 변수와 함수에 할당한 틀을 클래스라고 한다.
이 클래스에 의해 만들어져서 메모리에 올라온 객체를 인스턴스라고 한다.

js에서 객체를 생성하는 방법은
Function 생성자 함수, Object 생성자 함수, 객체 리터럴, 생성자 함수, 클래스 가 있다.
 */

//Function 생성자 함수
const op = new Function('a','b','return a+b');
console.log(op(10,20));


//Object 생성자 함수
let person1 = new Object();
person1.name = 'kim';
person1.age = 20;
person1.isMale = true;
person1.prt_name = ()=>{console.log(person1.name)};

let person2 = new Object();
person2.name = 'lee';
person2.age = 25;
person2.isMale = false;
person2.prt_name = ()=>{console.log(person2.name)};

console.log(person1, typeof(person1));
console.log(person2, Array.isArray(person2));
person2.prt_name();


//객체 리터럴 : { attribute: property } 형태로 작성
let person3 = {
    name: 'park', age: 30, isMale: true
};
let person4 = {
    name: 'park', age: 30, isMale: true, prt_gender: () => person4.isMale
};

console.log(person3,typeof(person3));
console.log(person4, person4.name, person4['age'], person4.prt_gender());


//생성자 함수 : 화살표 함수로 사용 불가, 익명함수로 할당
let Person5 = function(name,age){
    this.name = name;
    this.age = age;
    //여기다 메서드를 만들면 인스턴스마다 똑같은 메서드를 계속 만듦.(메모리 낭비)
    this.show = function(){console.log('instance method')};
};
//인스턴스 메서드는 프로토타입을 사용해 생성자 객체에 한 번만 만들어서 인스턴스가 이거를 상속해서 쓰도록 한다.
Person5.prototype.prt = function (){console.log(this.name,this.age)};
//생성자의 정적 메서드는 다음과 같이 만든다. 이것은 생성자 객체에 하나 만든 내장 메서드이다.
Person5.view = function () {
    console.log('Person5 static method');
}

let p5_1 = new Person5('hong',40);
let p5_2 = new Person5('kang',50);

console.log(p5_1);
p5_2.prt(); //생성자 객체 프로토타입 메서드
p5_2.show(); //인스턴스에서 계속 만들어지는 메서드
Person5.view(); //생성자 객체 내장 메서드 (정적 메서드)

/*
mdn 보는 법
내장객체 속성 : 변수
내장객체 메서드 : prototype 붙어있으면 인스턴스 상속 가능
내장객체 정적 메서드 : prototype 안 붙어있으면 인스턴스 상속 불가
 */


//클래스
class Person6 {
    constructor(name,age) {
        this.name = name;
        this.age = age;
    }
}

Person6.prototype.prt = function (){console.log(this.name,this.age)};

let p6_1 = new Person6('oh',60); //인스턴스
console.dir(p6_1);
p6_1.prt();

/*
자바스크립트는 프로토타입 개념으로 객체를 상속하고 활용한다.
그것을 표현한 틀이 생성자 함수인데, 최근 클래스라는 표현법이 생겼고 (자바스러운)
매커니즘은 같으나 표현법을 자바 클래스 처럼 쓸 수가 있다.
 */


//자바스크립트 내장객체
//Date()
let date = new Date();
console.log(date);
console.log(date.getFullYear());
console.log(`월`,date.getMonth()+1);
console.log(`일`,date.getDate());
console.log(`시`,date.getHours());
console.log(`분`,date.getMinutes());
console.log(`초`,date.getSeconds());
//요일 표기 switch문 써보기

//Array(), Object()
let arr1 = new Array(10);
let arr2 = [10,2,6,3,9];
let arr3 = new Array(10,20);
console.log(arr1,typeof(arr1), typeof(arr2), typeof(arr3));
console.log(Array.prototype);

//array와 object의 활용
let arr11 = [];
let obj1 = {name:'kim', age:20};
let obj2 = {name:'lee',age:30};
arr11.push(obj1,obj2);
console.log(arr11);
arr11.forEach((e,i)=>{
    console.log(i, e.name, e.age);
});

//얕은 복사는 참조값 복사이기 때문에 참조한 사본에서 객체 변경 시 원본도 전부 다 변경된다.
let copy1 = arr2; //변수할당
copy1[0] = 100;
console.log(arr2, copy1);
console.log(Object.is(arr2,copy1)); //같은 값을 가리키는 두 개의 참조변수.
let arr4 = [100,2,6,3,9];
console.log(Object.is(arr2[0],arr4[0])); //값이 같지만 별개로 할당된 배열

//깊은 복사는 내용 복사이고 사본에서 변경하면 사본만 변경된다.
let copy2 = [...arr2]; //1. 전개연산자로 복사
copy2[0] = 200;
console.log(arr2, copy2);

let copy3 = [];
Object.assign(copy3,arr2); //2. Object.assign()
copy3[0] = 300;
console.log(arr2,copy3);

//3. Array.prototype.concat()
let arr_concat = arr4.concat();
console.log(Object.is(arr4, arr_concat),arr_concat);

//Object.is()는 객체의 경우 같은 메모리 참조하는지의 여부를, 스트링의 경우는 같은 값인지를 판별함.
let string = 'hello';
let string_concat = string.concat();
console.log(Object.is(string,string_concat),string_concat);

let scores = [70,90,85,100,60]
console.log(scores.find(e=>e>=90)); //배열 안에서 90이상인 요소를 찾아 그 첫번째 값을 반환
console.log(scores.filter(e=>e>=90)); //배열 안에서 90 이상인 요소를 걸러 모두 반환
scores[0] = 95;
console.log(scores.filter(e=>e>=90)); //filter가 반환하는 배열은 얕은복사본
console.log(scores.every(e=>e>=50 && typeof(e)=='number'));
console.log(scores.map(e=>e*10)); //배열 안의 각 요소에 10을 곱한 후 배열을 반환

//Number()
console.log(Number.MAX_VALUE, Number.MIN_VALUE);
console.log(Number.isNaN(10), Number.isNaN('a'/10), Number.isInteger(10.2));

//Math()
//ceil()은 타겟보다 큰 정수 중에 가장 작은 수, floor()는 타겟보다 작은 정수 중에 가장 큰 수

//String()
let data = 'hong;kim;lee;park';
console.log(data.split(';').join('\n'));
data.split(';').forEach(e=>{console.log(e)});
console.log(data.charAt(3));
console.log('100100'.indexOf('1',2)); //2번째 인덱스 부터 '1'을 찾으라는 뜻
console.log(data.substring(0,4),data.substring(13));