import { useEffect, useState } from "react" 



export const ProductApp = () => {
    const [products, setProducts] = useState(initProducts);

    useEffect(() => {
     setProducts(initProducts);
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