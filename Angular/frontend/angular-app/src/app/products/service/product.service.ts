import { Injectable } from '@angular/core';
import { Product } from '../models/product';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

   products: Product[] = [
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
  ];


  constructor(private http: HttpClient) { }

  private url: string = 'http:localhost:8080/products'

  findAll(): Observable<Product []> {
    return this.http.get<Product[]>(this.url)
  }
}
