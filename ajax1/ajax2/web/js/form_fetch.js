document.getElementById("btn").onclick=function () {
    const form = document.getElementsByName("form")[0];
    let d = new FormData(form);
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
    const valuestr = Object.keys(result).map(key=> `${key}=${result[key]}`).join('&');
    console.log(valuestr);

    // fetch 는 Promise 객체를 리턴한다.
    fetch("ajax2_result.jsp"
        ,{
            method : "post"
            ,headers : {'Accept':'text/html' ,'Content-Type' : 'application/x-www-form-urlencoded'}
            ,body : valuestr
        }
    ).then(response=>{
        if(response.ok)
            return response.text();
        else
            throw new Error('not load');
    }).then(text=>{
        document.getElementById('result').insertAdjacentHTML('afterbegin',text);
    }).catch(error=>{
        console.log(error)
    }).finally(()=>{
        console.log("finally");
    });

}