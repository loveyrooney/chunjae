let ele_hamburger = document.getElementsByClassName('hamburger')[0];
ele_hamburger.addEventListener('click',function (){
    //console.log('hello');
    document.getElementsByTagName('nav')[0]
        .classList.toggle('visible');
});
