import "../css/search.css"

const SEARCH = ()=>{
    const foo = ()=>{
        let search = document.querySelector("#search");
        console.log(search.value);
    }
    return(
        <div className="searchwrap">
            <input id="search" type="text" name="search" placeholder="Search"/>
            <button type="button" onClick={foo}>SEARCH</button>
        </div>
    )
}

export default SEARCH;