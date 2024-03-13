let now;
document.getElementById('show').onclick = () => {
    now = setInterval(() => {
        let today = new Date();
        document.getElementById('clock').innerHTML = `${today.getHours()}:${today.getMinutes()}:${today.getSeconds()}`;
    }, 1000);
}
document.getElementById('stop').onclick = () => {
    clearInterval(now);
}
let scores = [];
document.getElementById('add').onclick = () => {
    let name = document.getElementById('name').value;
    let kor = Number(document.getElementById('kor').value);
    scores.push({name: name, kor: kor});
    document.getElementById('ul').innerHTML += `<li>${name} ${kor}</li>`;
}
document.getElementById('pass').onclick = () => {
    let filtered = scores.filter(e => e.kor >= 60);
    let ul = document.getElementById('ul');
    ul.innerHTML = ``;
    filtered.forEach(e => {
        ul.innerHTML += `<li>${e.name} ${e.kor}</li>`;
    });
}
