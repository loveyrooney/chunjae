import {useState} from "react";

const EventPractice = ()=>{
    const [obj,setObj] = useState({
        username:''
        ,msg:''
    });
    const {username,msg} = obj;
    const onChangeEvent = (e)=>{
        const changeObj = {
            ...obj
            ,[e.target.name]:e.target.value
        }
        //console.log(changeObj);
        setObj(changeObj);
    }
    const onClickEvent = ()=>{
        alert("username : "+username+"\nmsg : "+msg);
        setObj({
            username: ''
            ,msg: ''
        });
    }

    return(<>
        <input type="text" name="username" placeholder="name"
            value={username} onChange={onChangeEvent}/>
        <input type="text" name="msg" placeholder="comment"
               value={msg} onChange={onChangeEvent}/>
        <button onClick={onClickEvent}>확인</button>
    </>);
}

export default EventPractice;