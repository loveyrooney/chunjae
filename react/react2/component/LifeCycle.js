import {useEffect, useState} from "react";

const LifeCycle = ()=>{
    const [count, setCount] = useState(0);
    const [irum,setIrum] = useState('');
    useEffect(()=>{
        console.log("every render (componentDidUpdate) ");
    });
    useEffect(()=>{
        console.log("first render (componentDidMount) ");
    },[]);
    useEffect(()=>{
        console.log("only {count} update :",count,irum);
    },[count]);
    return(<>
        <button onClick={()=>{setCount(count+1)}}>click!</button>
        <input type="text" onChange={(e)=>{setIrum(e.target.value)}} value={irum}/>
    </>);
}

export default LifeCycle;