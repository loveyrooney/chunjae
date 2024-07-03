import {useState} from "react";
import Say from "./say";
import EventPractice from "./EventPractice";
import MyRef from "./MyRef";
import Iterator from "./Iterator";
import LifeCycle from "./LifeCycle";
import IntegExam from "./IntegExam";

export default function MAIN(){
    // console.dir(useState());
    let [count,setCount] = useState(0);
    const countHandler = (e)=>{
        //console.log(e.target.innerText);
        if(e.target.innerText=="+")
            setCount(count+=1);
        else
            setCount(count-=1);
    }
    const h1 = {color:"white", background:"silver"};
    return (
        <>
            <h1 style={h1}>part 1. useState</h1>
            <h3>primitive</h3>
            <button type="button" onClick={countHandler}>+</button>
            <button type="button" onClick={countHandler}>-</button>
            <p>{count}</p>
            <hr/>
            <h3>multiple state</h3>
            <Say></Say>
            <hr/>
            <h3>useState reference</h3>
            <EventPractice/>
            <h1 style={h1}>part 2. useRef</h1>
            <MyRef/>
            <h1 style={h1}>part 3. useEffect (LifeCycle)</h1>
            <LifeCycle/>
            <hr/>
            <IntegExam/>
            <h1 style={h1}>part 4. iterator</h1>
            <Iterator/>

        </>
    )
}