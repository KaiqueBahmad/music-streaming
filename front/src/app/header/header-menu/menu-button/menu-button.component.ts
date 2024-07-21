import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-menu-button',
  standalone: true,
  imports: [],
  template:`
  <button> {{buttonName}}</button>
  `,
  styleUrl: './menu-button.component.css'
})
export class MenuButtonComponent {
  @Input({ required: true }) buttonName!: string;
}
