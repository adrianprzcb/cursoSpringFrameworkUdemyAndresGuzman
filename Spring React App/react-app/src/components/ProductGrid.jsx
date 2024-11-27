
export const ProductGrid = ({oroducts}) => {
    return (
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
            </thead>
            <thead>
                {products.map(product => {
                    return (<tr key={product.name}>
                        <td> { product.name }</td>
                        <td> { product.price }</td>
                        <td> { product.description }</td>
                    </tr>)
                })}
            </thead>
        </table>

    )
}