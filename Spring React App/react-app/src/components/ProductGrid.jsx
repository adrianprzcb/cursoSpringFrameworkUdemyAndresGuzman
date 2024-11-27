import { ProductDetail } from './ProductDetail';
import { PropTypes } from 'prop-types';

export const ProductGrid = ( {handlerRemove, products = []}) => {
    return (
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                   {/* <th>Remove</th> */} 
                </tr>
            </thead>
            <tbody>
                {products.map(product => {
                    return <ProductDetail handlerRemove ={handlerRemove} product={product} key={product.name}/>
                })}
            </tbody>
        </table>

    )
}

ProductGrid.propTypes = {
    products: PropTypes.array.isRequired,
    handlerRemove: PropTypes.object.isRequired
}