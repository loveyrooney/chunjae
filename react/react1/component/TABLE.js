import "../css/table.css";

const TABLE = (prop)=> {
    return(
        <div className="tablewrap">
            <table>
                <thead>
                    <tr><th>Id</th><th>Description</th><th>Date</th><th>Priority</th></tr>
                </thead>
                <tbody>
                    {prop.data.map(data =>
                        <tr key={data.id} className="tbody">
                            <td>{data.id}</td>
                            <td>{data.description}</td>
                            <td>{data.date}</td>
                            <td>{data.priority}</td>
                        </tr>)}
                </tbody>
            </table>
        </div>
    )
}

export default TABLE;