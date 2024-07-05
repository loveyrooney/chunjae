import {Link} from "react-router-dom";
const About = ()=>{
    return(<>
        <h2>About</h2>
        <ul>
            <li><Link to="/about/1">about 1</Link></li>
            <li><Link to="/about/2">about 2</Link></li>
            <li><Link to="/about/3">about 3</Link></li>
        </ul>
    </>);
}

export default About;