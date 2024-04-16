/*
    AJAX 의 방법들
    XMLHttpRequest : .open(method,url), .setRequestHeader()
    fetch
*/

document.getElementById("btn").onclick = function () {
    const xhr = new XMLHttpRequest();
    xhr.open("get", "sample.html");
    // Accept : client 가 서버에서 응답받을 데이터의 MIME type 정보. 설정하지 않으면 */*
    // Content-Type: requestBody 에 담아 전송할 데이터의 MIME type 정보
    xhr.setRequestHeader("Accept", "text/html");
    xhr.send();
    xhr.onreadystatechange = function (e) {
        /* readyState (mdn 참고)
           0 : UNSENT, .open() 호출 이전
           1 : OPENED, .open() 호출
           2 : HEADERS_RECEIVED, .send() 호출
           3 : LOADING, .responseText 값이 미완성된 상태 (서버가 응답하는 중)
           4 : DONE, 서버 응답이 완료되었을 때
         */
        if (xhr.readyState == xhr.DONE) {
            if (xhr.status == 200) {
                console.log(xhr.readyState);
                console.log(xhr.status);
                document.getElementById("result").innerHTML = xhr.responseText;
            } else {
                console.log("error");
            }
        }
    }
}

