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

        const handlerAddProduct = (product) =>{
            console.log(product);
            setProducts([...products, {...product}])
        }

        const handlerRemoveProduct = (id) => {
            console.log(id);
           setProducts(products.filter(product => product.id !== id));

        }
        
    return (
        <>
        <div>
            <h1>Productos</h1>
        </div>

        <div>
            <ProductForm handlerAdd = {handlerAddProduct}/>
        </div>

        <div> 
            <ProductGrid products={products} />
        </div>
        </>
    )
}
