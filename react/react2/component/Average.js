import {useMemo, useRef, useState} from "react";

const Average = ()=>{
    const [list,setList] = useState([]);
    const inputRef = useRef(null);
    const [number,setNumber] = useState(0);
    const avg = (numbers)=>{
        if(numbers.length===0) return 0;
        const sum = numbers.reduce((a,b)=>a+b);
        console.log("sum: ",sum);
        setNumber(sum/numbers.length);
    }
    const onInsert = ()=>{
        let num = parseInt(inputRef.current.value);
        let newlist = [...list,num];
        setList(newlist);
        console.log(newlist);
        avg(newlist);
    }
    //const avgmemo = useMemo(()=>{avg(list)});
    return(<>
        <input ref={inputRef} type="text"/>
        <button type="button" onClick={onInsert}>등록</button>
        <p>평균 : {number}</p>
        <ol>
            {list.map((i,idx)=>{return <li key={idx}>{i}</li>})}
        </ol>
    </>);
}

export default Average;