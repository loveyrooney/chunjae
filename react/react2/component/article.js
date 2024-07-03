export default function ARTICLE (prop) {
    return(
        <div key={prop.id}>
            <p>{prop.title}</p>
            <p>{prop.content}</p>
        </div>
    );
}