import {useReducer, useState} from "react";

const Type = {
    DEPOSIT : 'DEPOSIT'
    ,WITHDRAW : 'WITHDRAW'
}
const reducer = (balance,action)=>{
    switch (action.type){
        case Type.DEPOSIT: return balance + action.money;
        case Type.WITHDRAW: return balance - action.money;
        default : return balance;
    }
}
const ReducerExam = ()=>{
    const [money,setMoney] = useState(0);
    const [balance,dispatcher] = useReducer(reducer,0);
    return(<>
        <h1>Bank</h1>
        <input type="number" onChange={(e)=>{setMoney(Number(e.target.value))}}/>
        <button onClick={()=>dispatcher({type:Type.DEPOSIT,money:money})}>입금</button>
        <button onClick={()=>dispatcher({type:Type.WITHDRAW,money:money})}>출금</button>
        <div>잔액 : {balance}</div>
    </>);
}

export default ReducerExam;