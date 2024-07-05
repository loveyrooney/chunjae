import Header from "./Header";
import Home from "./Home";
import About from "./About";
import Product from "./Product";
import NotFound from "./NotFound";
import Param from "./Param";
import Web from "./Web";
import WebPost from "./WebPost";
import Location from "./Location";
import {BrowserRouter, Routes, Route} from "react-router-dom";
const Router1 = ()=>{
    return(<>
        <h1>Router</h1>
        <BrowserRouter>
            <Header/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/about" element={<About/>}/>
                <Route path="/product" element={<Product/>}/>
                <Route path="/param/:name/:age" element={<Param/>}/>
                <Route path="/param" element={<Param/>}/>
                <Route path="/web/" element={<Web/>}>
                    <Route path=":id" element={<WebPost/>}/>
                </Route>
                <Route path="/location?" element={<Location/>}></Route>
                <Route path="*" element={<NotFound/>}/>
            </Routes>
        </BrowserRouter>
    </>);
}

export default Router1;