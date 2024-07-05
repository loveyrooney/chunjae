import {useCallback, useMemo, useState} from "react";

const UseCallBack = ()=>{
    const [count,setCount] = useState(0);
    const [todos,setTodos] = useState([]);
    // const addTodo = ()=>{
    //     setTodos((t)=>[...t,{id:todos.length+1,title:'title'}])
    // }
    const addTodo = useCallback(()=>{
        setTodos((t)=>[...t,{id:todos.length+1,title:'title'}])
    },[todos]);
    return <>
        <Todos todos={todos} addTodo={addTodo}></Todos>
        <hr/>
        <input type="number" value={count} onChange={(e)=>{setCount(e.target.value)}}/>
        <div>{count}</div>
    </>
}

const Todos = ({todos,addTodo})=>{
    return(<>
        <h2>My Todos</h2>
        {
            todos.map(i=>{
                return <p key={i.id}>{i.title}</p>
            })
        }
        <button onClick={addTodo}>add todo</button>
    </>);
}

export default UseCallBack;