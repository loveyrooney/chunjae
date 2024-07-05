import {Link} from "react-router-dom";

const Newses = (prop)=>{
    //console.log(prop.data);
    return(<table>
        <thead>
            <tr><th>title</th><th>publishedAt</th></tr>
        </thead>
        <tbody>
        {prop.data.map((d,i)=>{
            return <tr key={"n"+i}>
                <td><Link to={"/news/n"+i}>{d.title.slice(0,50)+"..."}</Link></td>
                <td>{d.publishedAt}</td>
                <td><button type="button" onClick={()=>{prop.onRemove(i)}}>del</button></td>
            </tr>
        })}
        </tbody>
    </table>);
}

export default Newses;