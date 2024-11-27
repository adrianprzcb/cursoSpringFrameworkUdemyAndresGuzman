import { PropTypes } from 'prop-types';

export const ProductDetail = ({ handlerRemove, product = {}}) => {
    return(
        <tr>
                        <td> { product.name }</td>
                        <td> { product.price }</td>
                        <td> { product.description }</td>
                        <td>
                            <button onClick={() => handlerRemove(product.name)}>Remove</button>
                        </td>
                    </tr>
    )
}


ProductDetail.propTypes = {
    product: PropTypes.object.isRequired,
    handlerRemove: PropTypes.object.isRequired
}