window.onload=()=>{
    let names = [], kors =[], engs=[];
    document.getElementById('add').onclick=()=>{
        let name = document.getElementById('name').value;
        let kor = Number(document.getElementById('kor').value);
        let eng = Number(document.getElementById('eng').value);
        names.push(name);
        kors.push(kor);
        engs.push(eng);
    }
    document.getElementById('show').onclick=()=>{
        for(let i=0; i<names.length; i++){
            console.log(`이름: ${names[i]} 국어: ${kors[i]} 영어: ${engs[i]} 총점: ${kors[i]+engs[i]} 평균: ${(kors[i]+engs[i])/2}`);
        }
    }
}
