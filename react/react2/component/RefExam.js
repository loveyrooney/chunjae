import {useRef, useState} from "react";

const RefExam = ()=>{
    const nameRef = useRef('');
    const korRef = useRef('');
    const engRef = useRef('');
    const [form,setForm] = useState([]);
    const submitForm = ()=>{
        let sum = Number(korRef.current.value)+Number(engRef.current.value);
        let one = {name:nameRef.current.value
            , kor:korRef.current.value
            , eng:engRef.current.value
            , sum:sum
            , avg:sum/2};
        let newForm = [...form,one];
        setForm(newForm);
    }
    return(<>
        <input ref={nameRef} type="text" placeholder="name"/>
        <input ref={korRef} type="number" placeholder="kor"/>
        <input ref={engRef} type="number" placeholder="eng"/>
        <button type="button" onClick={submitForm}>등록</button>
        <ul>
            <li>이름 국어 영어 총점 평균</li>
            {form.map((i,idx)=>{return <li key={"s"+idx}>{i.name}, {i.kor}, {i.eng}, {i.sum}, {i.avg}</li>})}
        </ul>
    </>);
}

export default RefExam;