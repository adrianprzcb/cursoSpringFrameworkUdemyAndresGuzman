import { Component, OnInit } from '@angular/core';

import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ProductService } from '../../service/product.service';
import { Product } from '../../models/product';
import { FormComponent } from '../form/form.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product',
  imports: [FormComponent, FormsModule],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit{

  constructor(private service: ProductService) {}

  products: Product[] = [];

  ngOnInit(): void {
    this.service.findAll().subscribe(products => {
      this.products = products;
    })
  }



}
