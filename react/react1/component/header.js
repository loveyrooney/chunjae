import "../css/header.css";
import EXAMLIST from "./examlist";
export default function HEADER (prop) {
    return(
        <>
            <header>
                <nav>
                    <ul className="header_ul">
                        {prop.text.map((data,index)=><li key={"m"+index}>{data}</li>)}
                    </ul>
                </nav>
            </header>
        </>
    )
}