import {useEffect, useReducer} from "react";
const reducer = (state,action)=>{
    console.log('reducer...',state,action);
    switch (action) {
        case 'add' : return state+1
        case 'sub' : return state-1
        default : return state
    }
}
const UseReducer = ()=>{
    const [state,dispatcher] = useReducer(reducer,0);
    const addCount = ()=>{
        dispatcher('add');
    }
    const subCount = ()=>{
        dispatcher('sub');
    }
    useEffect(()=>{
        console.log("render")
    });
    return <>
        <button onClick={addCount}>+</button>
        <button onClick={subCount}>-</button>
        <div>결과 : {state}</div>
    </>
}

export default UseReducer;