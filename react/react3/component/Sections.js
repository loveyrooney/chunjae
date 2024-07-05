import Section from "./Section";

const Sections = ({data, onRemove})=>{
    //console.log(data);
    return(<div>
        {data.map(item=>{
            return <Section key={item.id} id={item.id} name={item.name} age={item.age} onRemove={onRemove}></Section>
        })}
    </div>);
}

export default Sections;