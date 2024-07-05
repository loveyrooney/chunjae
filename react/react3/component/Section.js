const Section = ({id,name,age,onRemove})=>{
    return(<>
        <p>
            <span>번호 : {id}</span>
            <span>이름 : {name}</span>
            <span>나이 : {age}</span>
            <button onClick={()=>{onRemove(id)}}>삭제</button>
        </p>
    </>);
}

export default Section;