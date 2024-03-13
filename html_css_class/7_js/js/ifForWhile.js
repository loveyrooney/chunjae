// let score;
// if (score>=90){
//
// } else if (score>=80) {
//
// }
//90>score>=80 이렇게 쓰거나 score>=80 && score<90 이렇게 쓸 필요 없음

//j의 스코프에 대해서 생각해 볼것
let j=10;
for( ; ; j--){
    if(j==5) break
    console.log(j);
}
console.log(`outside ${j}`);

window.onload = function () {
    document.getElementById('btn').addEventListener('click',()=>{
        let first = Number(document.getElementById('first').value);
        let end = Number(document.getElementById('end').value);
        for( ; first<=end; first++){
            if (first%2) console.log(first);
        }
    });
}

let sum = 0;
let nums = '';
for(let k=1; k<=20; k++) {
    if(k%3==0) {
        nums += k+' ';
        sum += k;
    }
}
console.log(nums);
console.log(`합계는 : ${sum}`);

let l = 2;
while(l<=10) {
    if (l%2==0) console.log(l);
    l++;
}

//break는 반복문(for, while)이나 switch문에서 사용하는 것. if문 아님.

for(let m=1; m<10; m++){
    if(m%3==0) continue
    console.log(m);
    //if(m%3!=0) console.log(m);
}
/*
let m=0;
while(m<9){
    m++;


    if(m%3==0) continue
    console.log(m);
}

let m=1;
while(m<10){
    if(m%3!=0) console.log(m);
    m++;
}
*/
