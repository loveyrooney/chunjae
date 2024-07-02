export default function DIV ({color,border,name,age}) {
    // props 를 구조분해 할당 방식으로 받을 수 있다.
    const style = {
        color:color
        ,border:border
    };
    return <div style={style}>
        <p>이름 (props) : {name}</p>
        <p>나이 (props) : {age}</p>
    </div>
}