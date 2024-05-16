let did;
let init = function(deptid) {
    did = deptid;
}

window.onload=function () {
    //console.log(did);
    let li;
    document.getElementById("add").onclick=function () {
        let form = document.querySelector("form");
        let data =  { "first_name" : form.first_name.value, "salary" : form.salary.value };
        fetch("/insertemp/"+did, {
            method : "post"
            ,headers : {"Content-Type" : "application/json;charset=utf-8"
                , "Accept" : "application/json"}
            ,body : JSON.stringify(data)
        }).then(res=>{
            if(!res.ok) // res.status 로 표현 가능
                throw new Error();
            else
                return res.json();
        }).then(data=>{
            //console.log(data);
            dynamicList(li, data);
            form.first_name.value = '';
            form.salary.value = '';
        }).catch(error=>{
            console.log(error);
        });
    }

    fetch("/emplist/"+did, {
        method: "get"
        , headers: {"Accept": "application/json"}
    }).then(res=>{
        //console.log(res); // body는 readableStream 타입이다.
        if(!res.ok)
            throw new Error("not load");
        return res.json();
    }).then(list=>{
        list.forEach(data=>{
           dynamicList(li,data);
        });
    }).catch(error=>{
        console.log(error);
    });

    function dynamicList(li,data) {
        li = document.createElement("li");
        li.appendChild(document.createTextNode(data.first_name+" "));
        li.appendChild(document.createTextNode(data.salary));
        document.getElementById("emplist").appendChild(li);
    }

}

