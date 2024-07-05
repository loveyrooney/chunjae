import User from "./User";

const Users = ({users,onRemove})=>{
    return(<table>
        <thead>
            <tr><th>번호</th><th>이름</th><th>이메일</th></tr>
        </thead>
        <tbody>
        {users.map(u=>{ return <User key={u.id} id={u.id} name={u.name} email={u.email} onRemove={onRemove}/>})}
        </tbody>
    </table>);
}

export default Users;