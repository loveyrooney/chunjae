document.getElementById('btn').onclick=function () {
    // const xhr = new XMLHttpRequest();
    // xhr.open("get","form_json");
    // xhr.send();
    // xhr.onreadystatechange=function (e) {
    //     if(xhr.readyState === xhr.DONE && xhr.status === 200){
    //         const data = xhr.response;
    //         console.log(data, typeof data);
    //         let obj = JSON.parse(data);
    //         let d = "";
    //         obj.forEach(item=>{
    //             let ele = document.createElement("li");
    //             let ele_span = document.createElement("span");
    //             let txt = document.createTextNode(item.name+", ");
    //             ele_span.appendChild(txt);
    //             let ele_span2 = document.createElement("span");
    //             let txt2 = document.createTextNode(item.age);
    //             ele_span2.appendChild(txt2);
    //             ele.appendChild(ele_span);
    //             ele.appendChild(ele_span2);
    //             document.getElementById('result2').appendChild(ele);
    //         });
    //         console.log(obj, typeof obj);
    //     } else
    //         console.log("error",e);
    // }

    fetch("form_json"
        ,{
                method : "get"
                ,headers : { "Accept" : "text/json" }
        }
    ).then(response=>{
        if(response.ok)
            return response.json();
        else
            throw new Error("not found");
    }).then(res=>{
        console.log(res);
        res.forEach(item=>{
            let ele = document.createElement("li");
            let ele_span = document.createElement("span");
            let txt = document.createTextNode(item.name+', '+item.age);
            ele_span.appendChild(txt);
            ele.appendChild(ele_span);
            document.getElementById('result2').appendChild(ele);
        });
    }).catch(error=>{
        console.log("error: ",error);
    }).finally(()=>{
        console.log("end");
    });

}