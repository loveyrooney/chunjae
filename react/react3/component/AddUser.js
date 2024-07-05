import {forwardRef} from "react";

const AddUser = forwardRef((prop,ref)=>{
    //console.log(ref)
    let [nameRef,emailRef] = ref.current;
    return(<div>
        <input ref={nameRef} type="text" placeholder="name"/>
        <input ref={emailRef} type="text" placeholder="email"/>
        <button type="button" onClick={()=>{prop.onAdd()}}>추가</button>
    </div>);
});

export default AddUser;