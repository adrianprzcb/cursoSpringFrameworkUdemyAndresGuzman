
export const ProductForm = () => {

    const initialDataForm = {
        name: '',
        description: '',
        price: 0
    }

    return 
    (
        <form>
            <input placeholder="Name"
            name="name"
            value={initialDataForm.name}
            onChange={} 
            />
            <input placeholder="Description"
            name="Description"
            value={initialDataForm.description}
            onChange={} 
            />
            <input placeholder="Price"
            name="Price"
            value={initialDataForm.price}
            onChange={} 
            />
        </form>
    )
}