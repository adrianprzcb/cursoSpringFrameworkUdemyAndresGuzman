import { useState } from "react" 

const initProducts = [
    { name: 'Product 1', price: 100, description : 'fefefefe'  },
    {  name: 'Product 2', price: 200, description : 'This is a 2e2eda' },
    { name: 'Product 3', price: 300, description: 'This is a product' },
]


export const ProductApp = () => {
    const [products, setProducts] = useState(initProducts)

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