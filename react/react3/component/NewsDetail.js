import {Link, useParams, useSearchParams} from "react-router-dom";

const NewsDetail = (prop)=>{
    //console.log(prop.data,Date.now());
    //처음부터 url 파라미터로 해당 컴포넌트에 접근할 경우, 이 컴포넌트 마운트 타임과 prop 받아오는 타임에 약 220ms 정도 차이가 난다.
    let param = useParams();
    let [querystring] = useSearchParams();
    console.log(param.id,querystring.get('id'));
    let board;
    if(param.id!=null)
        board = prop.data[param.id.slice(1)];
    else if(querystring!=null)
        board = prop.data[querystring.get('id')];
    else
        board = {author:'',title:'',content:''};
    return(<div>
        <ul>
            <li>작성자 : {(board)?board.author:''}</li>
            <li>타이틀 : {(board)?board.title:''}</li>
            <li>내용 : {(board)?board.content:''}</li>
        </ul>
    </div>);
    //return(<></>);
}

export default NewsDetail;