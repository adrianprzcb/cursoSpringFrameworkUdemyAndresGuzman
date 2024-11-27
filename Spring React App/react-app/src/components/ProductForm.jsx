import { useEffect, useState } from "react";

const initialDataForm = {
    name: '',
    description: '',
    price: 0
}

//eslint-disable-next-line react/prop-types
export const ProductForm = ({ productSelected, handlerAdd })  => {


    const [form, setForm] = useState(initialDataForm);
    const { name, description, price } = form;

    useEffect(() => {
        setForm(productSelected);
    }


    return (
        <form onSubmit={(event) => {
            event.preventDefault();

            if(!name || !description || !price) {
                alert('All fields are required');
                return;
            }

           // console.log(form);
            handlerAdd(form);
            setForm(initialDataForm);
        }}>
            <div>
            <input placeholder="Name"
            style={{marginBottom: '4px'}}
            name="name"
            value={name}
            onChange={(event) => setForm({
                ...form,
                name: event.target.value
            })} 
            />
            </div>

            <div>
            <input placeholder="Description"
             style={{marginBottom: '4px'}}
            name="Description"
            value={description}
            onChange={(event) => setForm({
                ...form,
                description: event.target.value
            })}  
            />

            </div>

         
            <div>
            <input placeholder="Price"
            style={{marginBottom: '4px'}}
            name="Price"
            value={price}
            onChange={(event) => setForm({
                ...form,
                price: event.target.value
            })} 
            />

            </div>  
            <div>
            <button type="submit">Add</button>

            </div>
        </form>
    );
};