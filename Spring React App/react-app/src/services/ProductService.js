import axios from "axios";

const initProducts = [
    { id: 1, name: 'Product 1', price: 100, description : 'fefefefe'  },
    { id: 3, name: 'Product 2', price: 200, description : 'This is a 2e2eda' },
    { id: 4, name: 'Product 3', price: 300, description: 'This is a product' },
]


export const listProducts = () => {
    return initProducts;
}

const baseUrl = 'http://localhost:8080/products';

export const findAll = async() => {
    try {
        const response = await axios.get(baseUrl);
        return response;
    } catch (error) {
        console.log('Error: ', error);
    }
   return [];

}


export const create = async({name, description, price}) =>{

    try {
        const response = await axios.post(baseUrl, {name: name, description: description, price: price});
        return response;
    } catch (error) {
        console.log('Error: ', error);
    }
    return [];

}