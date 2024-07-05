import {Link, useParams} from "react-router-dom";
const Home = ()=>{
    return(<>
        <h2>HOME</h2>
        <ul>
            <li><Link to="/about/1">about 1</Link></li>
            <li><Link to="/product/1">Product 1</Link></li>
        </ul>
    </>);
}

export default Home;