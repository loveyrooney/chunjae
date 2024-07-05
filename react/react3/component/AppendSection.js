import {forwardRef} from "react";

// 부모의 ref 를 받기 위해서는 forwardRef 라는 함수 내부에 받아야 한다.
const AppendSection = forwardRef((prop,ref)=>{
    console.log(ref);
    let [nameRef,ageRef] = ref.current;
    return(<>
        <input ref={nameRef} type="text" placeholder="name"/>
        <input ref={ageRef} type="number" placeholder="age"/>
        <button type="button" onClick={()=>{prop.onAppend()}}>추가</button>
    </>);
});

export default AppendSection;