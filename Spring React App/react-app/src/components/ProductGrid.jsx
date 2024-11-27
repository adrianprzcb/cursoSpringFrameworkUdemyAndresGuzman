import { ProductDetail } from './ProductDetail';
import { PropTypes } from 'prop-types';

export const ProductGrid = ( { handlerProductSelected, handlerRemove, products = []}) => {
    return (
        <table className='table table-hover'>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Update</th>
                    <th>Remove</th> 
                </tr>
            </thead>
            <tbody>
                {products.map(product => {
                    return <ProductDetail handlerProductSelected={handlerProductSelected} handlerRemove ={handlerRemove} product={product} key={product.name}/>
                })}
            </tbody>
        </table>

    )
}

ProductGrid.propTypes = {
    products: PropTypes.array.isRequired,
    handlerRemove: PropTypes.func.isRequired,
    handlerProductSelected: PropTypes.func.isRequired
}