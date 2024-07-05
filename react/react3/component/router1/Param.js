import {useParams} from "react-router-dom";

const Param = ()=>{
    let data = useParams();
    return(<>
        <h2>Param</h2>
        <div>name : {data.name}</div>
        <div>age : {data.age}</div>
    </>);
}

export default Param;