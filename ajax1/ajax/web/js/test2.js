document.getElementById("btn").onclick=function () {
    const xhr = new XMLHttpRequest();
    xhr.open("post","test2_result.jsp");
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.setRequestHeader("Accept","text/html");

    const data = {name:"hong",age:20};
    // jsp에서는 json 형식을 받을 수 없어서 get 방식의 파라미터=값 으로 세팅을 해준다. 이 타입이 x-www-form-urlencoded
    const value = Object.keys(data).map(key=>`${key}=${data[key]}`).join('&');
    xhr.send(value);
    xhr.onreadystatechange=function () {
        if(xhr.readyState === xhr.DONE && xhr.status ==200){
            console.log(xhr.responseText);
            document.getElementById("result").innerHTML = xhr.responseText;
        }
    }
}