window.onload = () => {
  //1번 1-2+3-4+5 =? innerhtml로 출력
  document.getElementById("click").onclick = () => {
    let input = Number(document.getElementById("num").value);
    let expression = "";
    let result = 1;
    for (let i = 2; i <= input; i++) {
      if (i % 2 == 0) {
        expression += `-${i}`;
        result -= i;
      } else {
        expression += `+${i}`;
        result += i;
      }
    }
    document.getElementById("result").innerHTML = `1${expression} = ${result}`;
  };

  //2번 이름 국어 영어 추가 결과보기
  //이름 국어 영어 총점 평균 ( 총점 내림차순으로 innerhtml출력)
  let names = [],
    kors = [],
    engs = [];
  document.getElementById("add").onclick = () => {
    let name = document.getElementById("name").value;
    let kor = Number(document.getElementById("kor").value);
    let eng = Number(document.getElementById("eng").value);
    names.push(name);
    kors.push(kor);
    engs.push(eng);
  };
  document.getElementById("show").onclick = () => {
    let temp_name, temp_kor, temp_eng;
    for (let i = 0; i < names.length - 1; i++) {
      for (let j = 1; j < names.length; j++) {
        if (kors[i] + engs[i] < kors[j] + engs[j]) {
          temp_name = names[i];
          temp_kor = kors[i];
          temp_eng = engs[i];
          names[i] = names[j];
          kors[i] = kors[j];
          engs[i] = engs[j];
          names[j] = temp_name;
          kors[j] = temp_kor;
          engs[j] = temp_eng;
        }
      }
    }
    console.log(names, kors, engs);
    for (let k = 0; k < names.length; k++) {
      document.getElementById("ul").innerHTML += `<li>이름: ${
        names[k]
      }, 국어: ${kors[k]}, 영어: ${engs[k]}, 총점: ${
        kors[k] + engs[k]
      }, 평균: ${(kors[k] + engs[k]) / 2}</li>`;
    }
  };
};

let arr = [];
arr.push("a1", "a2", "a3");
arr[1] = "p2";
arr.pop("a2");
arr.unshift("t1");
arr.unshift("t1");
console.log(arr);
