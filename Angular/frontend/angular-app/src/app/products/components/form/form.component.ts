import { Component } from '@angular/core';
import { Product } from '../../models/product';

@Component({
  selector: 'product-form',
  imports: [],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {

  product: Product = new Product()

}
