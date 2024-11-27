import { useEffect, useState } from "react" 
import { listProducts } from "../services/ProductService";
import { ProductGrid } from "./ProductGrid";
import { ProductForm } from "./ProductForm";



export const ProductApp = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const result = listProducts();
     setProducts(result);
    }, [])

    return (
        <>
        <div>
            <h1>Productos</h1>
        </div>

        <div>
            <ProductForm />
        </div>

        <div> 
            <ProductGrid products={products} />
        </div>
        </>
    )
}
