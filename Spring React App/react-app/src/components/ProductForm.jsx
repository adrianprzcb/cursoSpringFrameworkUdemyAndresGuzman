
const initialDataForm = {
    name: '',
    description: '',
    price: 0
}

export const ProductForm = () => {


    const [form, setForm] = useState(initialDataForm);
    const { name, description, price } = form;

    return 
    (
        <form>
            <input placeholder="Name"
            name="name"
            value={name}
            onChange={} 
            />
            <input placeholder="Description"
            name="Description"
            value={description}
            onChange={} 
            />
            <input placeholder="Price"
            name="Price"
            value={price}
            onChange={} 
            />
        </form>
    )
}