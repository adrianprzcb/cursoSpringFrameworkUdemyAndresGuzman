import { Injectable } from '@angular/core';
import { Product } from '../models/product';
import { map, Observable, of } from 'rxjs';
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

  private url: string = 'http://localhost:8080/products'

  findAll(): Observable<Product []> {
    return this.http.get<Product[]>(this.url).pipe(
      map((response: any) =>
        response._embedded.products as Product[]),
    );
  }


  create(product: Product): Observable<Product>{
    return  this.http.post<Product>(this.url, product);
  }

  update(product: Product): Observable<Product>{
    return this.http.put<Product>(`${this.url}/${product.id}`, product)
  }



}
