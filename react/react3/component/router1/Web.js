import {Link, Outlet} from "react-router-dom";
//중첩 라우트의 부모 컴포넌트 내부에서 자식 컴포넌트가 추가 되어야 하는 위치에 Outlet 을 써 준다.
const Web = ()=>{
    return(<div>
        <h2>web - 중첩 Routes</h2>
        <ul>
            <li><Link to="1">post-1</Link></li>
            <li><Link to="2">post-2</Link></li>
            <li><Link to="3">post-3</Link></li>
            <li><Link to="4">post-4</Link></li>
        </ul>
        <Outlet/>
    </div>);
}

export default Web;