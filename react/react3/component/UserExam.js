import {useReducer, useRef, useState} from "react";
import Users from "./Users";
import AddUser from "./AddUser";

const UserExam = ()=>{
    const [users,setUsers] = useState([
        {id:"u1", name:"짱구",email:"zzanggu@test.com"}
        ,{id:"u2", name:"봉미선",email:"bong@test.com"}
    ]);
    const [list,dispatcher] = useReducer([{id:"u1", name:"짱구",email:"zzanggu@test.com"}
        ,{id:"u2", name:"봉미선",email:"bong@test.com"}]);
    const onRemove = (id)=>{
        setUsers(users.filter(u=>u.id!==id));
    }
    const nameRef = useRef('');
    const emailRef = useRef('');
    const userRef = useRef([nameRef,emailRef]);
    const onAdd = ()=>{
        console.log(nameRef.current.value);
        let id = Number(users[users.length-1].id.slice(1))+1;
        console.log(id);
        setUsers([...users,{id:"u"+id, name:nameRef.current.value, email:emailRef.current.value}]);
    }
    return(<>
        <h1>Users</h1>
        <Users users={users} onRemove={onRemove}/>
        <AddUser onAdd={onAdd} ref={userRef}/>
    </>);
}

export default UserExam;