let bid = '';
function init(data) {
    bid = data;
    console.log(bid);
}

async function delData (boardId) {
    await fetch("/del/"+boardId,{
        method : "get"
        ,headers : { Accept : "application/json", ContentType: "application/json"}
    }).then(res=>{
        console.log(res);
        if(!res.ok)
            throw new Error();
        else
            return res.text();
    }).then(data=>{
        alert(data);
        location.href="/list";
    }).catch(error=>{
        console.log(error);
    });
}

async function writeSub () {
    let form = document.querySelector("form");

}

window.onload = function () {
    fetch(`/sublist/${bid}`, {
        method : "get"
        ,headers : {Accept: 'application/json', ContentType : 'application/json' }
    }).then(res=>{
        //console.log(res);
        if(!res.ok)
            throw new Error();
        else
            return res.json();
    }).then(data=>{
        //console.log(data);
        data.forEach(d=>{
            let li = document.createElement("li");
            let li_txt = document.createTextNode(d.content);
            li.appendChild(li_txt);
            document.querySelector("#sublist").appendChild(li);
        });
    }).catch(error=>{
        console.log(error);
    });
}