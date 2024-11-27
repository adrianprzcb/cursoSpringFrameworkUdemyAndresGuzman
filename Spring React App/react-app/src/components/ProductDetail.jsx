
export const ProductGrid = ({ product = {}}) => {
    return(
        <tr key={product.name}>
                        <td> { product.name }</td>
                        <td> { product.price }</td>
                        <td> { product.description }</td>
                    </tr>
    )
}