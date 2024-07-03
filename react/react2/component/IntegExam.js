import {useRef, useState} from "react";

const IntegExam = ()=>{
    const [user,setUser] = useState([{name:"짱구",age:5},{name:"봉미선",age:29},{name:"채성아",age:24}]);
    const [index,setIndex] = useState(-1);
    if(index!=-1){
        //console.log("idx",index);
        let newUser = [...user];
        //console.log(newUser);
        newUser.splice(index,1);
        //console.log(newUser);
        setUser(newUser);
        setIndex(-1);
    }
    const [color,setColor] = useState('black');
    const changeColor = (e)=>{
        if(e._reactName == "onMouseEnter")
            setColor('red');
        else
            setColor('black');
    }
    const nameRef = useRef();
    const ageRef = useRef();
    const addUser = ()=>{
        let newUser = [...user,{name:nameRef.current.value, age:Number(ageRef.current.value)}];
        setUser(newUser);
    }
    return(<>
        <form>
            <input ref={nameRef} type="text" name="name" placeholder="name"/>
            <input ref={ageRef} type="number" name="age" placeholder="age"/>
            <button type="button" onClick={addUser}>추가</button>
        </form>
        <ul>
            {user.map((i,idx)=>{
                return <li style={{color}} key={idx}
                           onMouseEnter={changeColor} onMouseOut={changeColor}
                           onClick={()=>{setIndex(idx);}}>{i.name}, {i.age}</li>
            })}
        </ul>
    </>);
}

export default IntegExam;