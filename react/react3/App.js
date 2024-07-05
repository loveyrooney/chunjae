import './App.css';
import Sections from "./component/Sections";
import AppendSection from "./component/AppendSection";
import {useRef, useState} from "react";

function App() {
  let [list,setList] = useState([
    {id:"a1",name:"hong",age:10}
      ,{id:"a2",name:"park",age:20}
      ,{id:"a3",name:"lee",age:30}
  ]);
  const onRemove = (id)=>{
    setList(list.filter(item=>item.id!==id));
  }
  const nameRef = useRef('');
  const ageRef = useRef(0);
  let dataRef = useRef([nameRef,ageRef]);
  const nextId = useRef(3);
  const onAppend = ()=>{
    let data = {id:"a"+ ++nextId.current
      , name:nameRef.current.value
      , age:ageRef.current.value}
    console.log(data);
    setList([...list,data]);
  }
  return (<>
    <h1>sections</h1>
    <Sections data={list} onRemove={onRemove}/>
    <AppendSection ref={dataRef} onAppend={onAppend}/>
  </>);
}

export default App;
