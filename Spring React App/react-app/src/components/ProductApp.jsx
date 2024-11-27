import { useState } from "react" 

const initProducts = [
    { name: 'Product 1', price: 100 },
    {  name: 'Product 2', price: 200 },
    { name: 'Product 3', price: 300 },
]


export const ProductApp = () => {
    const [products, setProducts] = useState(initProducts)

    return (
        <>
        <h1>Product App</h1>
        </>
    )
}