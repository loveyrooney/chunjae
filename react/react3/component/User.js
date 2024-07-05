const User = (prop)=>{
    return(
        <tr>
            <td>{prop.id}</td>
            <td>{prop.name}</td>
            <td>{prop.email}</td>
            <td><button type="button" onClick={()=>{prop.onRemove(prop.id)}}>삭제</button></td>
        </tr>
    );
}

export default User;