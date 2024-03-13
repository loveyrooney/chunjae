//배열이나 객체나 typeof(arr)는 object 가 나오기 때문에
//배열을 확인하려면 Array.isArray(arr)를 쓰도록 한다.

let arr = ['a1','a2','a3','a4'];
//배열은 참조변수, 배열의 내용이 들어있는 메모리 주소를 가리킨다.
console.log(arr[0]);
console.log(arr.length);
console.log(typeof(arr), Array.isArray(arr));

let score = [1,2, 3, 4, 5];
console.log(score);
let sum = 0;

//for .. of
for(item of score) {
    console.log('forof', item);
    sum += item;
}
console.log('forof',sum);
//forEach : 매개변수에 배열의 요소, 배열의 인덱스, 배열 자체 를 넣을 수 있다.
score.forEach((element,index,array)=>{
    sum += element;
    document.write(`forEach ${element} / ${index} / ${array}`);
});
document.write('<br>');
document.write(`총합 : ${sum}`); // sum을 위에서 합쳤기 때문에 15가 디폴트상태에서 시작
document.write('<br>');

//for.. in : 배열에서는 쓰지 않는다.
for(item in score){
    console.log('forin',score[item]); //그냥 item을 넣으면 string, 0부터 열거
    sum += score[item];
}
console.log('forin',sum); //sum을 위에서 합쳤기 때문에 30이 디폴트상태에서 시작

window.onload= ()=>{
    let names = [];
    document.getElementById('btn1').onclick = ()=>{
        let name = document.getElementById('name').value;
        names.push(name);
        console.log(names);
    }
    document.getElementById('btn2').onclick = ()=>{
        for(let i=0; i<names.length; i++){
            console.log(names[i]);
        }
    }
}

