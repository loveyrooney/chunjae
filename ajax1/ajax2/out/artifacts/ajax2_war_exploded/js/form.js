document.getElementById("btn").onclick=function () {
    const form = document.getElementsByName("form")[0];
    let d = new FormData(form);
    console.log(d);
    let result = {};
    // checkbox 등과 같은 경우, value 가 복수개이기 때문에 value[] 를 만든다.
    for(let [key,value] of d){
        let s = document.querySelector('[name='+key+']');
        if(s.length>1) {
            if (result[key] == undefined)
                result[key] = [];
            result[key].put(value);
        } else {
            result[key]=value;
        }
    }
    console.log(result);
    const valuestr = Object.keys(result).map(key=> `${key}=${result[key]}`).join('&');

    // XMLHttpRequest
    const xhr = new XMLHttpRequest();
    xhr.open("post","ajax2_result.jsp");
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.setRequestHeader("Accept","text/html");
    xhr.send(valuestr);
    xhr.onreadystatechange=function (e) {
        if(xhr.readyState === xhr.DONE && xhr.status == 200){
            document.getElementById("result")
                .insertAdjacentHTML("afterbegin",xhr.responseText);
        } else {
            console.log("error: ",e);
        }
    }
}