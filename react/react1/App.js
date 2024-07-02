import './App.css';
import "./css/body.css";
import {Component} from "react";
import LIST from "./component/list";
import DIV from "./component/div";
import HEADER from "./component/header";
import EXAMLIST from "./component/examlist";
import ARTICLE from "./component/article";
import SEARCH from "./component/search";
import TABLE from "./component/TABLE";

// 함수 방식
// export default function App (){} 으로 한번에 써도 됨
// const App = ()=>{} export default App 으로 써도 됨
function App() {
    // part 1
    const name = "흥민";
    const age = 30;
    const person = {name:name,age:age};
    let i=10;
    const persons = [{id:"p1",name:name,addr:"런던"}
        ,{id:"p2",name:"지성",addr:"서울"}
        ,{id:"p3",name:"두리",addr:"서울"}];
    //const h1_st = {color:"white", background:"silver"};
    DIV.defaultProps={
        color:"blue"
        ,border:"1px solid silver"
    }
    // part 3
    const today = new Date();
    const date = `${today.getFullYear()}.${today.getMonth()+1}.${today.getDate()}`;
    const todos = [{id:"t1",description:"Swimming",date:date, priority:"Medium"}
    ,{id:"t2",description: "Coffee with Mike",date:date,priority: "Low"}
    ,{id:"t3",description: "Movie night",date:date,priority: "High"}]

    // return 값이 undefined 면 안된다. 하지만 undefined 인 변수를 리턴 내부에 사용하는 건 가능
  return (
    <>
        <h1>part 1. hello, react</h1>
        <p>이름 : {person.name}</p>
        <p>나이 : {(person.age>i) ? person.age : i+" (조건값)"}</p>
        <LIST name={name} age={age} obj={persons}></LIST>
        <DIV name={person.name} age={person.age} color={"green"} border={"1px solid red"}></DIV>
        <DIV name={"지성"} age={40}></DIV>
        <hr/>
        <h1>part 2. hello, component</h1>
        <HEADER text={["뉴스","자유게시판","공지사항"]}/>
        <div className="bodywrap">
            <EXAMLIST user="흥민" text={["IT","과학","스포츠"]}/>
            <ARTICLE/>
        </div>
        <hr/>
        <h1>part 3. hello, component exam</h1>
        <SEARCH/>
        <TABLE data={todos}/>
    </>
  );
}

export default App;

// 컴포넌트 방식
// class App extends Component {
//     render() {
//         return (
//             <h1>heo</h1>
//         );
//     }
// }
//
// export default App;