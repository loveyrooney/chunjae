window.onload=function () {
    document.getElementsByName("logout").forEach((i)=>{
        i.onclick=function () {
            console.log("logout");
            window.location.href="/logout";
        }
    });
}