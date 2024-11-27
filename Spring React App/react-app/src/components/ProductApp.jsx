import { useEffect, useState } from "react" 
import { listProducts } from "../services/ProductService";



export const ProductApp = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const result = listProducts();
     setProducts(result);
    }, [])

    return (
        <>
        <h1>Product App</h1>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
            </thead>
            <thead>
                {products.map(product => {
                    return (<tr key={product.name}>
                        <td> { product.name }</td>
                        <td> { product.price }</td>
                        <td> { product.description }</td>
                    </tr>)
                })}
            </thead>
        </table>
        </>
    )
}