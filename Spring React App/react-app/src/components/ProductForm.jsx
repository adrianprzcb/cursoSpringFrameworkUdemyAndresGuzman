
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
            value={form.name}
            onChange={} 
            />
            <input placeholder="Description"
            name="Description"
            value={form.description}
            onChange={} 
            />
            <input placeholder="Price"
            name="Price"
            value={form.price}
            onChange={} 
            />
        </form>
    )
}