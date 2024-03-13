//closer
//count 하는 함수 안에 count가 있으면 계속 새로 생성하는 문제는 count 변수를 함수 밖으로 빼야 하는데,
//그 밖으로 뺀 count 변수가 전역 영역에 있지 않게끔 함수로 한번 더 감싸는 것.
//여기서 count 변수는 초기화가 안되므로 필요한 경우에만 사용하는 것이 좋음.
const addcount = (()=>{
    let count = 0;
    let fn = ()=>{
        count++;
        return count;
    }
    return fn;
})();

window.onload=()=>{
    document.getElementById('btn1').onclick=()=>{
        document.getElementById('result1')
            .innerHTML="hello";
        document.getElementById('ol')
            .innerHTML += `<li>${addcount()}</li>`;
    }
}

//정렬
let arr = [10,4,2,6,7];
let temp;
for(let i=0; i<arr.length-1; i++){
    for(let j=i+1; j<arr.length; j++){
        if(arr[i] > arr[j]){
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
}
console.log(arr);