import {useState} from "react";

const Say = ()=>{
    const [msg,setMsg] = useState('');
    const [color,setColor] = useState('black');
    const onClickEnter = ()=>{
        setMsg("짱구 님이 입장하셨습니다.");
    }
    const onClickLeave = ()=>{
        setMsg("짱구 님이 퇴장하셨습니다.")
    }
    return(<>
        <button type="button" onClick={onClickEnter}>입장</button>
        <button type="button" onClick={onClickLeave}>퇴장</button>
        <h5 style={{color}}>{msg}</h5>
        <button style={{color:"red"}} onClick={()=>{setColor('red')}}>red</button>
        <button style={{color:"black"}} onClick={()=>{setColor('black')}}>black</button>
    </>)
}

export default Say;