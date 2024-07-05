import {useEffect, useState} from "react";
import axios from "axios";
import Newses from "./Newses";
import NewsDetail from "./NewsDetail";
import {BrowserRouter, Routes, Route, useLocation, Link} from "react-router-dom";

const NewsAPI = ()=>{
    const key = '1f6eda1800a340aab387da3a96467b9f';
    const [news, setNews] = useState([]);
    let datas = [];

    useEffect(()=>{
        const fetchArticle = async ()=>{
            try{
                const response = await axios.get(`https://newsapi.org/v2/top-headlines?country=us&apiKey=${key}`);
                //console.log(response.data.articles);
                console.log("call api");
                //datas = response.data.articles;
                setNews(response.data.articles);
            } catch (e){
                console.error(e);
            }

        }
        fetchArticle();
    },[]);
    //console.log(news);
    const onRemove = ()=>{

    }


    return(
        <BrowserRouter>
            <h1>News API</h1>
            <ul>
                <li><Link to="/newslist">newslist</Link></li>
            </ul>
            <Routes>
                <Route path="/newslist" element={(news.length>0) ?<Newses data={news} onRemove={onRemove}/>:<></>}></Route>
                <Route path="/news/:id" element={<NewsDetail data={news}/>}/>
                <Route path="/news?" element={<NewsDetail data={news}/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default NewsAPI;