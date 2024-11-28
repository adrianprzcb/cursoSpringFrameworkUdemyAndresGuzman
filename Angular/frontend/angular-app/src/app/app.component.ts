import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Hola mundo angular 19';
  enabled: Boolean = false;


  courses: string[] = ['Angular', 'React', 'Vue'];


  setEnabled(): void {
    if (this.enabled) {
      this.enabled = false;
    } else {
      this.enabled = true;
    }
    console.log('Hemos hecho click en setEnabled');
  }
}
