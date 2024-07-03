import {useEffect, useRef, useState} from "react";
import Average from "./Average";
import RefExam from "./RefExam";

const MyRef = ()=>{
    const inputvalue = useRef('');
    const onClickEvent = ()=>{
        console.log(inputvalue);
        console.log(inputvalue.current.value);
    }
    const [count,setCount] = useState(0);
    const numRef = useRef(0);
    const addCount = ()=>{
        setCount(count+1);
        console.log("addState : ",count);
    }
    useEffect(()=>{
        console.log("render..",count,numRef.current);
    });
    return(<>
        <input ref={inputvalue} type="text" name="txt" placeholder="write number"/>
        <button onClick={onClickEvent}>확인</button>
        <hr/>
        <h3>state vs ref</h3>
        <button onClick={addCount}>state</button>
        <button onClick={()=>{numRef.current+=1; console.log("addRef : ",numRef.current)}}>ref</button>
        <hr/>
        <h3>average 구하기</h3>
        <Average/>
        <h3>exam</h3>
        <RefExam/>
    </>);
}

export default MyRef;