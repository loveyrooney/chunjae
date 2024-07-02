export default function EXAMLIST (prop) {
    return(
        <nav className="aside">
            <p>{prop.user} 님</p>
            <p>기사목록</p>
            <ul>
                {prop.text.map((data,index)=><li key={"l"+index}>{data}</li>)}
            </ul>
        </nav>
    )
}