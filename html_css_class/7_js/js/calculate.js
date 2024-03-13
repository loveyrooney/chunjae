window.onload = function () {
    document.getElementById('btn').addEventListener('click',con);
    function con() {
        let name = document.getElementById('name');
        let age = document.getElementById('age');
        console.log(name.value, age.value);
    }

    document.getElementById('btn2')
        .addEventListener('click',()=>{
            let korean = Number(document.getElementsByName('korean')[0].value);
            let english = Number(document.getElementById('english').value);
            let math = Number(document.getElementById('math').value);
            let avg = (korean+english+math)/3;
             console.log(avg,parseInt(avg));
            switch (parseInt(avg/10)) {
                case 10:
                case 9:
                    console.log('수');
                    break
                case 8:
                    console.log('우');
                    break
                case 7:
                    console.log('미');
                    break
                case 6:
                    console.log('양');
                    break
                default :
                    console.log('가');
            }
        });
}

