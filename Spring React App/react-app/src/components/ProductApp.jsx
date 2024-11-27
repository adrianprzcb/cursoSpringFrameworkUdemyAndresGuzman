import { useEffect, useState } from "react" 
import { listProducts } from "../services/ProductService";
import { ProductGrid } from "./ProductGrid";
import { ProductForm } from "./ProductForm";



export const ProductApp = () => {
    const [products, setProducts] = useState([]);

    const [productSelected, setProductSelected] = useState({
        name: '',
        description: '',
        price: ''
    })

    useEffect(() => {
        const result = listProducts();
     setProducts(result);
    }, [])

        const handlerAddProduct = (product) =>{
            console.log(product);
            setProducts([...products, {...product}])
            setProducts(products.map(prod => {
                if(prod.name === product.name) {
                    return {...product};
                }
                return prod;
        }))
        }

        const handlerRemoveProduct = (name) => {
            console.log(name);
            setProducts(products.filter(product => product.name !== name));
        }

        const handlerProductSelected = (product) => {
            setProductSelected({...product});
        }
        
    return (
        <>
        <div>
            <h1>Productos</h1>
        </div>

        <div>
            <ProductForm handlerAdd = {handlerAddProduct} productSelected={productSelected}/>
        </div>

        <div> 
            <ProductGrid products={products} handlerRemove={handlerRemoveProduct} handlerProductSelected={handlerProductSelected}/>
        </div>
        </>
    )
}
