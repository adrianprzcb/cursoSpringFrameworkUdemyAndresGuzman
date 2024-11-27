import { PropTypes } from 'prop-types';

export const ProductDetail = ({ handlerProductSelected, handlerRemove, product = {}}) => {
    return(
        <tr>
                        <td> { product.name }</td>
                        <td> { product.price }</td>
                        <td> { product.description }</td>
                        <td>
                            <button onClick={() => handlerProductSelected(product)}>Update</button>
                        </td>
                        <td>
                            <button onClick={() => handlerRemove(product.name)}>Remove</button>
                        </td>
                    </tr>
    )
}


ProductDetail.propTypes = {
    product: PropTypes.object.isRequired,
    handlerRemove: PropTypes.func.isRequired,
    handlerProductSelected: PropTypes.fun.isRequired
}