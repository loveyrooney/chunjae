import '../css/list.css';

/* 반복문으로 나열되는 요소가 있을 때는 key 를 지정해야 함.
 Virtual DOM 에서 key 기반으로 바뀐 요소를 찾기 때문에 지정 안하면 속도 느림
 key 값은 html 요소에서 보이지 않으며, 숫자보다는 고유값으로 지정하는 것이 좋음
*/
export default function LIST(prop) {
    return <ul>
        { (prop.name === "손흥민" || prop.age >10) &&
            prop.obj.map(data=><li key={data.id} className="list">
                <span>{data.id}, </span>
                <span>{data.name}, </span>
                <span>{data.addr}</span>
            </li>)
        }
    </ul>
}