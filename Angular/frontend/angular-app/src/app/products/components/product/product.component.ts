import { Component, OnInit } from '@angular/core';

import { ProductService } from '../../service/product.service';
import { Product } from '../../models/product';
import { FormComponent } from '../form/form.component';

@Component({
  selector: 'app-product',
  imports: [FormComponent],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit{

  constructor(private service: ProductService) {}

  products: Product[] = [];

  productSelected: Product = new Product();

  ngOnInit(): void {
    this.service.findAll().subscribe(products => {
      this.products = products;
    })
  }


  addProduct(product: Product){

    if(product.id > 0){
      this.products = this.products.map( prod => {
        if(prod.id == product.id){
          return {...product};
        }
        return prod;
      })
    }else{

      product.id = new Date().getTime();

      this.service.create(product).subscribe(productNew =>
      {
        this.products = [... this.products, {...productNew}]
      }
      )
      this.products.push(product)
    }

  }

  onUpdateProduct(productRow: Product){
    this.productSelected = {...productRow};
  }

  onRemoveProduct(id: number) : void{

    this.products = this.products.filter(products => products.id != id);

  }



}
