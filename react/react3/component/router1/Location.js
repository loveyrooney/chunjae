import {useLocation, useSearchParams} from "react-router-dom";

const Location = ()=>{
    const [searchParams, setSearchParams] = useSearchParams();
    let name = searchParams.get('name');
    let age = searchParams.get('age');
    return(<div>
        <h2>location - querystring</h2>
        <p>name : {name}</p>
        <p>age : {age}</p>
    </div>);
}

export default Location;