
const initialDataForm = {
    name: '',
    description: '',
    price: 0
}

export const ProductForm = () => {


    const [form, setForm] = useState(initialDataForm);
    const { name, description, price } = form;

    return 
    // eslint-disable-next-line no-unreachable
    (
        <form>
            <input placeholder="Name"
            style={{marginBottom: '2px'}}
            name="name"
            value={name}
            onChange={(event) => setForm({
                ...form,
                name: event.target.value
            })} 
            />
            <input placeholder="Description"
             style={{marginBottom: '2px'}}
            name="Description"
            value={description}
            onChange={(event) => setForm({
                ...form,
                description: event.target.value
            })}  
            />
            <input placeholder="Price"
            style={{marginBottom: '2px'}}
            name="Price"
            value={price}
            onChange={(event) => setForm({
                ...form,
                price: event.target.value
            })} 
            />

            <button type="submit">Add</button>
        </form>
    )
}