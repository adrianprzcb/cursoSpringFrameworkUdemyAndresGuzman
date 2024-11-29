import { Component, EventEmitter, Output } from '@angular/core';
import { Product } from '../../models/product';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'product-form',
  imports: [FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {

  product: Product = {
    id: 0,
    name: '' ,
    description: '',
    price: 0};


    @Output() newProductEvent = new EventEmitter();

    onSubmit(): void{
      this.newProductEvent.emit(this.product);
      console.log(this.product)
    }

}

