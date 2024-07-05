import {useMemo, useState} from "react";

const Memo1 = ()=>{
    const [count, setCount]=useState(1);
    const fact=function (n){
        for(let i=1; i<=1000000; i++){
            return n<1? 1:n*fact(n-1)
        }
    }
    // let result=fact(count);
    let result=useMemo(()=>fact(count), [count]);

    return <>
        <input onChange={(e)=>setCount(Number(e.target.value))} value={count}/>
        <div>{count}!={result}</div>
    </>
}

export default Memo1;