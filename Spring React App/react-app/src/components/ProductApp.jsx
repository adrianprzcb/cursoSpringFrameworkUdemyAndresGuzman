import { useEffect, useState } from "react" 
import { listProducts } from "../services/ProductService";
import { ProductGrid } from "./ProductGrid";



export const ProductApp = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const result = listProducts();
     setProducts(result);
    }, [])

    return (
        <>
        <h1>Productos</h1>
        <ProductGrid products={products} />
        </>
    )
}