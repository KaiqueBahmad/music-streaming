import { Component } from '@angular/core';
import { MenuButtonComponent } from './menu-button/menu-button.component';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-header-menu',
  standalone: true,
  imports: [MenuButtonComponent, NgFor],
  template:`
  <div id="header-menu"  *ngFor="let btn of buttons">
    <app-menu-button class="menu-button" [buttonName]="btn" ></app-menu-button>
  </div>
`,
  styleUrl: './header-menu.component.css'
})
export class HeaderMenuComponent {
  public buttons:string[] = ['Home', 'Search', 'Genres','Playlists']
}
