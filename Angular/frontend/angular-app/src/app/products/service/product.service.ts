import { Injectable } from '@angular/core';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private products: Product[] = [
    {
      id: 1,
      name: 'Mesa Mesa',
      description: 'Excelente mesa',
      price: 42
    },
    {
      id: 2,
      name: 'Tabla',
      description: 'Excelente tabla',
      price: 55
    }
  ]


  constructor() { }


  findAll():
}
